import java.util.*;

public class UserInputListMenu {
        private static List<String> dizi = new ArrayList<>();  // String türünde bir liste oluşturuldu.
        private static Scanner scanner = new Scanner(System.in);  // Kullanıcı girişi için bir Scanner nesnesi oluşturuldu.

        public static void main(String[] args) {
            boolean exit = false;  // Programın çalışma durumunu kontrol etmek için

            while (!exit) {
                System.out.println("\n--- MENÜ ---");
                System.out.println("1. Eleman Ekle");
                System.out.println("2. En Üst Indexli Elemanı Kaldır");
                System.out.println("3. En Üst Indexli Elemanı Görüntüle");
                System.out.println("4. Elemanları Sırala");
                System.out.println("5. Elemanları Ters Çevir");
                System.out.println("6. Dizidaki Eleman Sayısı");
                System.out.println("7. Belirli Bir Elemanın Sayısı");
                System.out.println("8. Belirli Bir Elemanın İndeksleri");
                System.out.println("9. Dizinin Kopyasını Al");
                System.out.println("10. Belirli Bir Elemanı Kaldır");
                System.out.println("11. Belirli Bir Aralıktaki Elemanları Filtrele");
                System.out.println("12. Güncel Elemanları Listele");
                System.out.println("0. Çıkış");
                System.out.print("Seçiminizi yapın: ");

                int choice = scanner.nextInt();  // Kullanıcının menüden seçim yapması bekleniyor.
                scanner.nextLine();  // Boş satırı oku

                switch (choice) {
                    case 1:
                        System.out.print("Eklemek istediğiniz elemanı girin: ");
                        dizi.add(scanner.next());  // Kullanıcının girdiği elemanı listeye ekle.
                        break;
                    case 2:
                        if (!dizi.isEmpty()) {
                            dizi.remove(dizi.size() - 1);  // Eğer liste boş değilse en üstteki elemanı kaldır.
                            System.out.println("En üstteki eleman kaldırıldı.");
                        } else {
                            System.out.println("Dizi boş.");
                        }
                        break;
                    case 3:
                        String topElement;
                        if (dizi.isEmpty()) topElement = null;
                        else topElement = dizi.get(dizi.size() - 1);
                        if (topElement != null) {
                            System.out.println("En Üst Eleman: " + topElement);
                        } else {
                            System.out.println("Dizi boş.");
                        }
                        break;
                    case 4:
                        Collections.sort(dizi);  // Elemanları sırala.
                        System.out.println("Elemanlar sıralandı.");
                        break;
                    case 5:
                        Collections.reverse(dizi);  // Elemanları ters çevir.
                        System.out.println("Elemanlar ters çevrildi.");
                        break;
                    case 6:
                        System.out.println("Dizideki Eleman Sayısı: " + dizi.size());  // Listenin eleman sayısını yazdır.
                        break;
                    case 7:
                        System.out.print("Sayısını öğrenmek istediğiniz elemanı girin: ");
                        String countElement = scanner.next();
                        long count = 0;
                        int i = 0;
                        while (i < dizi.size()) {
                            if (dizi.get(i).equals(countElement)) {
                                count++;
                            }
                            i++;
                        }
                        System.out.println("Elemanın Dizideki Sayısı: " + count);  // Belirli bir elemanın dizide kaç kez geçtiğini say.
                        break;
                    case 8:
                        System.out.print("İndeksini öğrenmek istediğiniz elemanı girin: ");
                        String indexElement = scanner.next();
                        List<Integer> indexes = new ArrayList<>();
                        for (int j = 0; j < dizi.size(); j++) {
                            if (dizi.get(j).equals(indexElement)) {
                                indexes.add(j);
                            }
                        }
                        System.out.println("Elemanın İndeksi: " + indexes);  // Belirli bir elemanın dizideki tüm indekslerini yazdır.
                        break;
                    case 9:
                        List<String> diziCopy = new ArrayList<>(dizi);  // Dizinin kopyasını al.
                        System.out.println("Dizinin Kopyası: " + diziCopy);
                        break;
                    case 10:
                        System.out.print("Kaldırmak istediğiniz elemanı girin: ");
                        String removeElement = scanner.next();
                        Iterator<String> iterator = dizi.iterator();
                        while (iterator.hasNext()) {
                            String element = iterator.next();
                            if (element.equals(removeElement)) {
                                iterator.remove();
                            }
                        }
                        System.out.println("Belirtilen eleman kaldırıldı.");  // Belirli bir elemanı listeden kaldır.
                        break;
                    case 11:
                        System.out.print("Başlangıç elemanını girin: ");
                        String start = scanner.next();
                        System.out.print("Bitiş elemanını girin: ");
                        String end = scanner.next();
                        List<String> filteredList = new ArrayList<>();
                        for (String element : dizi) {
                            if (element.compareTo(start) >= 0 && element.compareTo(end) <= 0) {
                                filteredList.add(element);
                            }
                        }
                        System.out.println("Belirli Bir Aralıktaki Elemanlar: " + filteredList);  // Belirli bir aralıktaki elemanları filtrele ve yazdır.
                        break;
                    case 12:
                        listCurrentElements();  // Güncel elemanları listele.
                        break;
                    case 0:
                        exit = true;
                        System.out.println("Programdan çıkılıyor.");
                        break;
                    default:
                        System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
                        break;
                }

                listCurrentElements();  // Her seçimden sonra güncel elemanları listele.
            }
        }
        private static void listCurrentElements() {
            System.out.println("Güncel Elemanlar: " + dizi);  // Güncel elemanları yazdır.
        }
    }


