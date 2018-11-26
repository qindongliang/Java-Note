package design_pattern.callback.demo2;

/***
 *通过接口定义回调函数
 */
public interface CallBack {
    //检查作业属于老师的功能，但由学生触发，故称回调
    public void checkWork();

}
