package Lists.itrable.comperable;

public class Cricketer implements Comparable<Cricketer> {
    
    int id;
    String name;
    int runs;

    Cricketer(int id,String name,int runs)
    {
        this.id=id;
        this.name=name;
        this.runs=runs;
    }

    public int compareTo(Cricketer that)
    {
        return Integer.compare(this.runs,that.runs);
    }
    public String toString(){
        return (this.id+" "+this.name+"="+this.runs);
    }
}
