package test.volatileAndSynchronized;

public class SyncCodeBlock {
    public int i;

    public void syncTask(){
        synchronized (this){
            i++;
        }
    }
}