/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

/**
 *
 * @author acer
 */
public class Config<T>{
    
    private int BLOCK_SIZE;
    private int N_BLOCKS;
    private int SCREEN_SIZE;
    private T MAX_GHOST;
    private int PACMAN_SPEED;

    public Config(int BLOCK_SIZE, int N_BLOCKS, T MAX_GHOST, int PACMAN_SPEED) {
        this.BLOCK_SIZE = BLOCK_SIZE;
        this.N_BLOCKS = N_BLOCKS;
        this.SCREEN_SIZE = BLOCK_SIZE * N_BLOCKS;
        this.MAX_GHOST = MAX_GHOST;
        this.PACMAN_SPEED = PACMAN_SPEED;
    }

    
    
    /**
     * @return the BLOCK_SIZE
     */
    public int getBLOCK_SIZE() {
        return BLOCK_SIZE;
    }

    /**
     * @return the N_BLOCKS
     */
    public int getN_BLOCKS() {
        return N_BLOCKS;
    }

    /**
     * @return the SCREEN_SIZE
     */
    public int getSCREEN_SIZE() {
        return SCREEN_SIZE;
    }

    /**
     * @return the MAX_GHOST
     */
    public T getMAX_GHOST() {
        return MAX_GHOST;
    }

    /**
     * @return the PACMAN_SPEED
     */
    public int getPACMAN_SPEED() {
        return PACMAN_SPEED;
    }
    

    
}
