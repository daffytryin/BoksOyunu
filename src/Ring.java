public class Ring {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;

    public Ring(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public void run() {

        if (checkWeight()) {
            // İlk dövüşçüyü belirleme
            double randomValue = Math.random();
            if (randomValue < 0.5) {
                System.out.println(f1.name + " dövüşe başlıyor!");
                while (f1.health > 0 && f2.health > 0) {
                    System.out.println("======== YENİ ROUND ===========");
                    f2.health = f1.hit(f2);
                    if (isWin()){
                        break;
                    }
                    f1.health = f2.hit(f1);
                    if (isWin()){
                        break;
                    }
                    printScore();
                }
            } else {
                System.out.println(f2.name + " dövüşe başlıyor!");
                while (f1.health > 0 && f2.health > 0) {
                    System.out.println("======== YENİ ROUND ===========");
                    f1.health = f2.hit(f1);
                    if (isWin()){
                        break;
                    }
                    f2.health = f1.hit(f2);
                    if (isWin()){
                        break;
                    }
                    printScore();
                }
            }
        } else {
            System.out.println("Sporcuların ağırlıkları uyuşmuyor.");
        }

    }
    /*Ring sınıfının run() metodu içerisinde, %50 olasılıkla hangi dövüşçünün ilk olarak saldıracağı belirlenmektedir.
    Math.random() fonksiyonu kullanılarak rastgele bir değer elde edilir ve bu değere göre ilk
    saldıracak dövüşçü belirlenir. Eğer değer 0.5'ten küçükse f1 saldırır, aksi halde f2 saldırır.*/

    public boolean checkWeight() {
        return (f1.weight >= minWeight && f1.weight <= maxWeight) && (f2.weight >= minWeight && f2.weight <= maxWeight);
    }

    public boolean isWin() {
        if (f1.health == 0) {
            System.out.println("Maçı Kazanan : " + f2.name);
            return true;
        } else if (f2.health == 0){
            System.out.println("Maçı Kazanan : " + f2.name);
            return true;
        }

        return false;

        //*//
    }


    public void printScore() {
        System.out.println("------------");
        System.out.println(f1.name + " Kalan Can \t:" + f1.health);
        System.out.println(f2.name + " Kalan Can \t:" + f2.health);
    }
}