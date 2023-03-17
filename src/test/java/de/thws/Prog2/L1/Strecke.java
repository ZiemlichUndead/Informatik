package de.thws.Prog2.L1;

public class Strecke {
    public int start;
    public int end;

    public Strecke(int start, int end) {
        if(start > end){
            this.start = end;
            this.end = start;
        }else{
            this.start = start;
            this.end = end;
        }
    }

    public boolean intersects(Strecke s){
        return start<s.start&&end>s.start || s.start<start && s.end>start;
    }

    @Override
    public String toString() {
        if(start == end){
            return start+"";
        }

        String s = start+"";
        for (int i = end-start; i > 0; i--) {
            s+="-";
        }
        s+=end;
        return s;
    }
}
