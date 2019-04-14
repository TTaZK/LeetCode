
public class SineFunction extends AnyTrigFunction {
    private Double T;
    private Double A;

    public SineFunction(Double A, Double T) {
        this.A = A;
        this.T = T;
    }

    @Override
    public Double trigFunction(Double t) {
        Double temp = 2 * Math.PI / T * t;
        return A * Math.sin(temp);
    }

    public void setA(Double a) {
        A = a;
    }

    public Double getA() {
        return A;
    }

    public void setT(Double t) {
        T = t;
    }

    public Double getT() {
        return T;
    }
}
