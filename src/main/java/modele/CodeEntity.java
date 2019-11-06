/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author pedago
 */
public class CodeEntity {
    
    private String discount_code;
    private float rate ;

    public CodeEntity(String code, float tx){
        this.discount_code=code;
        this.rate=tx;
    }
    public String getDiscount_code() {
        return discount_code;
    }

    public void setDiscount_code(String discount_code) {
        this.discount_code = discount_code;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
    
}
