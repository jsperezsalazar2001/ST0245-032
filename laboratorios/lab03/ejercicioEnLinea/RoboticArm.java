package laboratorio3;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * This class contains the methods that simulate a robotic arm, 
 * these move stacks of blocks or unitary blocks from one column to another.
 * @author Juan Sebastián Pérez Salazar
 */
public class RoboticArm {
    
    public static int n;
    public static Stack[] arrayStacks;
    public static Block[] arrayBlocks;
    
    public static void moveAOntoB(int a, int b){
        if(a != b){
            Block blockA = arrayBlocks[a];

            Block blockB = arrayBlocks[b];

            Stack stackA = arrayStacks[blockA.currentPos];
            Stack stackB = arrayStacks[blockB.currentPos];

            boolean already=false;
            for (Iterator it = stackA.iterator(); it.hasNext();) {

                Block block = (Block) it.next();
                if(block.numBlock == a) already = true;
                if(already && block.numBlock != a){
                    arrayStacks[block.pos0].push(block);
                    block.currentPos= block.pos0;
                    it.remove();
                }
            }

            already=false;
            for (Iterator it = stackB.iterator(); it.hasNext();) {

                Block block = (Block) it.next();
                if(block.numBlock == b) already = true;
                if(already && block.numBlock != b){
                    arrayStacks[block.pos0].push(block);
                    block.currentPos= block.pos0;
                    it.remove();
                }
            }

            stackB.push(stackA.pop());
            blockA.currentPos = blockB.currentPos;
        }
    }
    
    public static void moveAOverB(int a, int b){
        if(a != b){
            Block blockA = arrayBlocks[a];

            Block blockB = arrayBlocks[b];

            Stack stackA = arrayStacks[blockA.currentPos];
            Stack stackB = arrayStacks[blockB.currentPos];

            boolean already=false;
            for (Iterator it = stackA.iterator(); it.hasNext();) {

                Block block = (Block) it.next();
                if(block.numBlock == a) already = true;
                if(already && block.numBlock != a){
                    arrayStacks[block.pos0].push(block);
                    block.currentPos= block.pos0;
                    it.remove();
                }
            }

            stackB.push(stackA.pop());
            blockA.currentPos = blockB.currentPos;
        }
    }
    
    public static void pileAOntoB(int a, int b){
        if(a != b){
            Block blockA = arrayBlocks[a];
            Block blockB = arrayBlocks[b];

            Stack stackA = arrayStacks[blockA.currentPos];
            Stack stackB = arrayStacks[blockB.currentPos];

            boolean already=false;
            for (Iterator it = stackB.iterator(); it.hasNext();) {

                Block block = (Block) it.next();
                if(block.numBlock == b) already = true;
                if(already && block.numBlock != b){
                    arrayStacks[block.pos0].push(block);
                    block.currentPos= block.pos0;
                    it.remove();
                }
            }

            already=false;
            for (Iterator it = stackA.iterator(); it.hasNext();) {

                Block block = (Block) it.next();
                if(block.numBlock == a) already = true;
                if(already){
                    stackB.push(block);
                    block.currentPos= blockB.currentPos;
                    it.remove();
                }
            }
        }
    }
    
    public static void pileAOverB(int a, int b){
        if(a != b){
            Block blockA = arrayBlocks[a];
            Block blockB = arrayBlocks[b];

            Stack stackA = arrayStacks[blockA.currentPos];
            Stack stackB = arrayStacks[blockB.currentPos];

            boolean already=false;
            for (Iterator it = stackA.iterator(); it.hasNext();) {

                Block block = (Block) it.next();
                if(block.numBlock == a) already = true;
                if(already){
                    stackB.push(block);
                    block.currentPos= blockB.currentPos;
                    it.remove();
                }
            }
        }
    }
    
    public static void quit(){
        for(int i=0; i<arrayStacks.length; i++){
            System.out.print(i +": ");
            Stack stack = arrayStacks[i];
            for (Iterator it = stack.iterator(); it.hasNext();) {
                Block block = (Block)it.next();
                System.out.print(block.numBlock + " ");
            }
            System.out.println();
        }
    }
    /**
     * This class contains the tests of the previous methods.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sca = new Scanner(System.in);
        
        int number = sca.nextInt();
        if(number>25) n = 25;
        else n = number;
        
        arrayStacks = new Stack[n];
        arrayBlocks = new Block[n];
        
        for(int i=0; i<n; i++){
            arrayStacks[i] = new Stack();
            arrayBlocks[i] = new Block(i, i, i);
            arrayStacks[i].push(arrayBlocks[i]);
        }
                
        String message = sc.nextLine();
        while(!message.equals("quit")){
            
            String chain = message.substring(7, 11);
            int a = Character.getNumericValue(message.charAt(5));
            int b = Character.getNumericValue(message.charAt(12));
            if(message.startsWith("move") && chain.equals("onto")) moveAOntoB(a, b);
            if(message.startsWith("move") && chain.equals("over")) moveAOverB(a, b);
            if(message.startsWith("pile") && chain.equals("onto")) pileAOntoB(a, b);
            if(message.startsWith("pile") && chain.equals("over")) pileAOverB(a, b);
            
            message = sc.nextLine();
        }
        
        quit();
    }
    
}
