package ch07ThreadPerMessage.a7_3;

public class Host {
    private final Helper helper = new Helper();

    public void request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        new Thread() {
            public void run() {
                helper.handle(count, c);
            }
        }.run();//将start改为run，说明线程还未启动，因此就是同步操作
        System.out.println("    request(" + count + ", " + c + ") END");
    }
}
/** 线程的状态 可运行状态->启动状态->运行->(如果有阻塞）->退出
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
