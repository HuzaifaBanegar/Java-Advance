package Generics;

public class Pair <First, Second>{
    private First first;
    private Second second;

    Pair (First first, Second second){
        this.first = first;
        this.second = second;
    }

    public First getFirst(){
        return this.first;
    }

    public  Second getSecond(){
        return this.second;
    }
}

