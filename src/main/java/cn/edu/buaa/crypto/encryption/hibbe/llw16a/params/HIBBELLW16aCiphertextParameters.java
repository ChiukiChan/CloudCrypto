package cn.edu.buaa.crypto.encryption.hibbe.llw16a.params;

import cn.edu.buaa.crypto.algebra.PairingUtils;
import cn.edu.buaa.crypto.pairingkem.params.PairingCiphertextParameters;
import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.PairingParameters;

/**
 * Created by Weiran Liu on 2016/5/17.
 *
 * Liu-Liu-Wu prime-order HIBBE ciphertext parameters.
 */
public class HIBBELLW16aCiphertextParameters extends PairingCiphertextParameters {
    private final Element C0;
    private final Element C1;

    public HIBBELLW16aCiphertextParameters(PairingParameters pairingParameters, Element C0, Element C1) {
        super(pairingParameters);
        this.C0 = C0.getImmutable();
        this.C1 = C1.getImmutable();
    }

    public Element getC0() {
        return this.C0.duplicate();
    }

    public Element getC1() {
        return this.C1.duplicate();
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof HIBBELLW16aCiphertextParameters) {
            HIBBELLW16aCiphertextParameters that = (HIBBELLW16aCiphertextParameters) anObject;
            //Compare C0
            if (!PairingUtils.isEqualElement(this.C0, that.getC0())) {
                return false;
            }
            //Compare C1
            if (!PairingUtils.isEqualElement(this.C1, that.getC1())) {
                return false;
            }
            //Compare Pairing Parameters
            return this.getParameters().toString().equals(that.getParameters().toString());
        }
        return false;
    }
}