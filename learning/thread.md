

################################################
History:
2022/06/01    zcj    release 1

################################################

����ֻ�����ԣ�
https://developer.android.google.cn/guide/background/threading

���̣߳�
�����̵߳ĳɱ��ܸߣ������Ӧ�ó�ʼ��ʱ������һ���̳߳ء�
��ؽ�ExecutorService ��ʵ��������Application���������ע��������

Ӧ�������������Activityʹ�õ�����λ��
Application

class MyApplication : Application() {
    val executorService: ExecutorService = Executors.newFixedThreadPool(4)
}

ExecutorService�����������̵߳�
Executor��������ִ�г���ģ����߳�


����һ���ࣺ

class  exe( private val executor :Executor)
{
    
    fun th<out T>(out T){
         executor.execute{
	      daima()
	 }
    }
    fun daima(){...}


}

�����߳�ͨ�ţ�
���߳�Ҫ֪�����̵߳Ľ������Ҫʹ�ûص���
��ʱ��ʹ�ø߽׺���

class  exe( private cal executor :Executor)
{
    
    fun th<out T>(out T,
    callback: (���ص���������) -> Unit){
    
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

