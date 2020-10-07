package ru.progwards.java1.lessons.bigints;
import java.math.BigDecimal;
import java.math.BigInteger;
public class BigAlgebra {
    public BigAlgebra(){}
    public static BigDecimal fastPow(BigDecimal num, int pow){
        BigDecimal tmp = num;
        BigDecimal res = new BigDecimal("1");
        for (int i=1; i<=pow; i++){
            res = res.multiply(tmp);
        }
        return res;
    }
    // Вычислить Фибоначчи
    BigInteger fibonacci(int n){
        BigInteger fiboprev1 = new BigInteger("0");
        BigInteger fiboprev2 = new BigInteger("1");
        BigInteger RESfiboNumber = new BigInteger("0");
        switch (n) {
            case 0:
                RESfiboNumber = new BigInteger(String.valueOf(n));
            case 1:
                RESfiboNumber = new BigInteger(String.valueOf(n));
            default:
            for (int i = 2; i <= n; i++) {
                RESfiboNumber = fiboprev1.add(fiboprev2);
                fiboprev1 = fiboprev2;
                fiboprev2 = RESfiboNumber;
            }
        }
        return RESfiboNumber;
    }
}
