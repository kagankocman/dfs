public class Uygulama {
    private int adimSayisi = -1;
    private int gecenSure;
    private long baslamaZamani;
    private long bitisZamani;

    public int getAdimSayisi() {
        return adimSayisi;
    }

    public void setAdimSayisi(int adimSayisi) {
        this.adimSayisi = adimSayisi;
    }

    public void adimSayisiniGoster() {
        System.out.println("Adim sayisi : " + this.getAdimSayisi());
    }

    public void gecenSureyiGoster() {
        System.out.println("Gecen sure : " + this.getGecenSure() + " ms");
    }

    public int getGecenSure() {
        return gecenSure;
    }

    public void setGecenSure(int gecenSure) {
       this.gecenSure = gecenSure;
    }

    public long getBaslamaZamani() {
        return baslamaZamani;
    }

    public void setBaslamaZamani(long baslamaZamani) {
       this.baslamaZamani = baslamaZamani;
    }

    public long getBitisZamani() {
        return bitisZamani;
    }

    public  void setBitisZamani(long bitisZamani) {
        this.bitisZamani = bitisZamani;
    }
}

