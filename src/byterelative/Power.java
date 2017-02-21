package byterelative;

/**
 * Created by renguifu on 2017/2/13.
 * 问题：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
 */
public class Power {
    public double Power1(double base, int exponent) {
        if (base == 0 && exponent < 0) {
            throw new RuntimeException("分母不能为0");
        } else if (base == 0) {
            return 0;
        } else if (exponent == 0) {
            return 1;
        } else if (exponent > 0) {
            double result = 1;
            for (int i = 1; i <= exponent; i++) {
                result = result * base;
            }
            return result;
        } else {
            double temp = 1;
            for (int i = 1; i <= -exponent; i++) {
                temp = temp * base;
            }
            double result = 1 / temp;
            return result;
        }
    }
    public double Power(double base, int exponent) {
        int absExponent;
        if(exponent >0){
            absExponent = exponent;
        }else if(exponent <0){
            if(base == 0){
                return 1;
            }
            absExponent = - exponent;
        }else {
            return 1;
        }
        double temp = base;
        double result =1;
        while(absExponent !=0){
            if((absExponent & 1)==1){
                result *= temp;
            }
            temp *= temp;
            absExponent >>= 1;
        }
        return exponent >0 ? result:(1 / result);
    }
}
