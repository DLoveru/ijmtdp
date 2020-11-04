package ch07ThreadPerMessage.a7_2;

public class Host {
    private final Helper helper = new Helper();

    public void request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        //如果是直接调用，相当于同步操作，那么打印的效果如下
        helper.handle(count, c);
        System.out.println("    request(" + count + ", " + c + ") END");
    }
}
/**①
 * main BEGIN
 *     request(10, A) BEGIN
 *         handle(10, A) BEGIN
 * AAAAAAAAAA
 *         handle(10, A) END
 *     request(10, A) END
 *     request(20, B) BEGIN
 *         handle(20, B) BEGIN
 * BBBBBBBBBBBBBBBBBBBB
 *         handle(20, B) END
 *     request(20, B) END
 *     request(30, C) BEGIN
 *         handle(30, C) BEGIN
 * CCCCCCCCCCCCCCCCCCCCCCCCCCCCCC
 *         handle(30, C) END
 *     request(30, C) END
 * main END
 */
