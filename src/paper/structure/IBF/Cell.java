package paper.structure.IBF;

import java.io.UnsupportedEncodingException;

public class Cell {
    private int count;
    private int idSum;
    private int hashSum;

    public void add(int id, int idHashValue) {
        idSum += id;
        hashSum += idHashValue;
        count++;
    }

    public void delete(int id, int idHashValue) {
        idSum -= id;
        hashSum -= idHashValue;
        count--;
    }

    public boolean isPure() {
        try {
            if(hashSum / count == InvertibleBloomFilter.genIdHash(String.valueOf(idSum/count).getBytes("UTF-8")))
//            if ((count == -1 || count == 1)
//                    && (InvertibleBloomFilter.genIdHash(String.valueOf(idSum).getBytes("UTF-8")) == hashSum))

                return true;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setIdSum(int idSum) {
        this.idSum = idSum;
    }

    public void setHashSum(int hashSum) {
        this.hashSum = hashSum;
    }

    public int getCount() {
        return count;
    }

    public int getIdSum() {
        return idSum;
    }

    public int getHashSum() {
        return hashSum;
    }
}
