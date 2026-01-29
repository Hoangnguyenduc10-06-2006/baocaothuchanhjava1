import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Scanner sc = new Scanner(System.in);

    // ===== MAIN =====
    public static void main(String[] args) {
        int choice;

        do {
            showMainMenu();
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    twoSum();
                    break;
                case 2:
                    moveZeroes();
                    break;
                case 3:
                    validPalindrome();
                    break;
                case 4:
                    reverseWords();
                    break;
                case 5:
                    happyNumber();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    // ===== MENU =====
    static void showMainMenu() {
        System.out.println("\n==== MENU THUẬT TOÁN JAVA ====");
        System.out.println("1. Two Sum");
        System.out.println("2. Move Zeroes");
        System.out.println("3. Valid Palindrome");
        System.out.println("4. Reverse Words");
        System.out.println("5. Happy Number");
        System.out.println("0. Exit");
        System.out.print("Nhập lựa chọn của bạn: ");
    }

    // ===== TWO SUM =====
    static void twoSum() {
        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();
        int[] a = new int[n];

        System.out.println("Nhập các phần tử:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.print("Nhập target: ");
        int target = sc.nextInt();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] + a[j] == target) {
                    System.out.println("Indices: " + i + ", " + j);
                    return;
                }
            }
        }
        System.out.println("Không tìm thấy cặp số phù hợp.");
    }

    // ===== MOVE ZEROES =====
    static void moveZeroes() {
        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();
        int[] a = new int[n];

        System.out.println("Nhập các phần tử:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != 0) {
                a[index++] = a[i];
            }
        }

        for (int i = index; i < n; i++) {
            a[i] = 0;
        }

        System.out.println("Mảng sau khi dồn số 0:");
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    // ===== VALID PALINDROME =====
    static void validPalindrome() {
        System.out.print("Nhập chuỗi: ");
        String s = sc.nextLine();

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0, right = s.length() - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println("Chuỗi đối xứng? " + isPalindrome);
    }

    // ===== REVERSE WORDS =====
    static void reverseWords() {
        System.out.print("Nhập chuỗi: ");
        String s = sc.nextLine();

        // xử lý nhiều khoảng trắng
        s = s.replaceAll("\\s+", " ").trim();

        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) sb.append(" ");
        }

        System.out.println("Chuỗi sau khi đảo từ:");
        System.out.println(sb.toString());
    }

    // ===== HAPPY NUMBER =====
    static void happyNumber() {
        System.out.print("Nhập số n: ");
        int n = sc.nextInt();

        int slow = n, fast = n;
        do {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        } while (slow != fast);

        if (slow == 1) {
            System.out.println("Đây là số hạnh phúc.");
        } else {
            System.out.println("Đây KHÔNG phải là số hạnh phúc.");
        }
    }

    static int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
