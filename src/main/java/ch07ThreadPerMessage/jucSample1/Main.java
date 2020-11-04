package ch07ThreadPerMessage.jucSample1;

public class Main {
    public static void main(String[] args) {
        System.out.println("main BEGIN");
        Host host = new Host();
        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'C');
        System.out.println("main END");
    }
}
/**
 * main BEGIN
 *     request(10, A) BEGIN
 *     request(10, A) END
 *     request(20, B) BEGIN
 *     request(20, B) END
 *     request(30, C) BEGIN
 *     request(30, C) END
 * main END
 *         handle(10, A) BEGIN
 *         handle(20, B) BEGIN
 *         handle(30, C) BEGIN
 * BACABCBACABCBACBACBACBACABCA
 *         handle(10, A) END
 * BCBCBCBCBCBCBCBCBCBCCB
 *         handle(20, B) END
 * CCCCCCCCCC
 *         handle(30, C) END
 */
