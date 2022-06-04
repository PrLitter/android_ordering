

################################################
History:
2022/06/01    zcj    release 1

################################################

以下只是来自：
https://developer.android.google.cn/guide/background/threading

多线程：
创建线程的成本很高，因此在应用初始化时仅创建一次线程池。
务必将ExecutorService 的实例保存在Application类或依赖项注入容器。

应用类可以让所有Activity使用的用用位置
Application

class MyApplication : Application() {
    val executorService: ExecutorService = Executors.newFixedThreadPool(4)
}

ExecutorService：用来管理线程的
Executor：是用来执行程序的，即线程


定义一个类：

class  exe( private val executor :Executor)
{
    
    fun th<out T>(out T){
         executor.execute{
	      daima()
	 }
    }
    fun daima(){...}


}

与主线程通信：
主线程要知道子线程的结果，就要使用回调。
此时，使用高阶函数

class  exe( private cal executor :Executor)
{
    
    fun th<out T>(out T,
    callback: (返回的数据类型) -> Unit){
    
         executor.execute{
	 try{
	  daima()
	  callback(vas) 
	 }
	 catch(e:Exception){
	   callback(vae)
	 }
	     
	 }
    }
    fun daima(){...}

}

