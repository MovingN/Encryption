/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Monica Ciuchetti
 */
public class Vigenere implements Runnable{

    private int ir;//inizio riga
    private int fr;//fine riga
    private int ic;//inizio colonna
    private int fc;//fine colonna
    private Matrice matrix;

    /**
     * 
     * @param ir 
     * @param fr
     * @param ic
     * @param fc
     * @param matrix 
     */
    public Vigenere(int ir, int fr, int ic, int fc, Matrice matrix) {
        this.ir = ir;
        this.fr = fr;
        this.ic = ic;
        this.fc = fc;
        this.matrix = matrix;
    }

    @Override
    public void run() {
        popola();
    }

    private void popola(){//popola un quadrante per volta in quanto un thread gestisce un solo quadrante
        int c,r,car;
        for(r=ir; r<fr; r++) {
            for(c=ic; c<fc; c++) {
                car = r + c + 65;
                if(car>90) {
                    car = car - 26;
                }
                this.matrix.setElemento(r, c, car);
            }
        }
    }
}
