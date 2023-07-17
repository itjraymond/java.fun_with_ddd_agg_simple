package ca.jent.funwithdddaggsimple.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class Money extends BigDecimal {

    public static Money of(String value) {
        return new Money(value);
    }

    public static Money of(Double value) {
        return new Money(value);
    }

    public static Money of(BigDecimal value) {
        return new Money(value.toString());
    }

    public Money(char[] in, int offset, int len) {
        super(in, offset, len);
    }

    public Money(char[] in, int offset, int len, MathContext mc) {
        super(in, offset, len, mc);
    }

    public Money(char[] in) {
        super(in);
    }

    public Money(char[] in, MathContext mc) {
        super(in, mc);
    }

    public Money(String val) {
        super(val);
    }

    public Money(String val, MathContext mc) {
        super(val, mc);
    }

    public Money(double val) {
        super(val);
    }

    public Money(double val, MathContext mc) {
        super(val, mc);
    }

    public Money(BigInteger val) {
        super(val);
    }

    public Money(BigInteger val, MathContext mc) {
        super(val, mc);
    }

    public Money(BigInteger unscaledVal, int scale) {
        super(unscaledVal, scale);
    }

    public Money(BigInteger unscaledVal, int scale, MathContext mc) {
        super(unscaledVal, scale, mc);
    }

    public Money(int val) {
        super(val);
    }

    public Money(int val, MathContext mc) {
        super(val, mc);
    }

    public Money(long val) {
        super(val);
    }

    public Money(long val, MathContext mc) {
        super(val, mc);
    }
}
