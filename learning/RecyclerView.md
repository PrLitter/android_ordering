https://developer.android.google.cn/guide/topics/ui/layout/recyclerview
************************************************
ѧϰrecycleview:
************************************************

RecyclerView �ǰ������������ݶ�Ӧ����ͼ�� ViewGroup�������������ͼ����ˣ���
RecyclerView ��ӵ������еķ�ʽ������κ���������Ԫ����ͬ��

�б��е�ÿ������Ԫ�ض���һ�� ViewHolder ������ж��塣���� ViewHolder ʱ������
û���κι��������ݡ����� ViewHolder ��RecyclerView �Ὣ��󶨵������ݡ�����
��ͨ����չ RecyclerView.ViewHolder ������ ViewHolder��

RecyclerView ��������Щ��ͼ����ͨ���� Adapter �е��÷���������ͼ�󶨵������ݡ�
������ͨ����չ RecyclerView.Adapter ������ Adapter��

���ֹ��������������б��еĸ���Ԫ�ء�������ʹ�� RecyclerView ���ṩ��ĳ������
��������Ҳ���Զ����Լ��Ĳ��ֹ����������ֹ����������ڿ�� LayoutManager �����ࡣ

https://github.com/android/views-widgets-samples/tree/main/RecyclerViewKotlin/


ʵ�ֲ��裺
    ���ȣ�ȷ���б���������ۡ�һ����˵��������ʹ�� RecyclerView ���ĳ����׼
    ���ֹ�������
    
    ����б���ÿ��Ԫ�ص���ۺ���Ϊ�����ݴ���ƣ���չ ViewHolder �ࡣ����
    ViewHolder �汾�ṩ���б�������й��ܡ����� ViewHolder �� View �ķ�װ������
    �Ҹ���ͼ�� RecyclerView ����
    
    �������ڽ����������� ViewHolder ��ͼ������� Adapter��



�滮���֣�
    LinearLayoutManager:һά�б�
    GridLayoutManager:��ά����



ʵ��adapter��viewholder
  ȷ�����ֺ�����Ҫʵ�� Adapter �� ViewHolder�������������ʹ�ã���ͬ�������ݵ�
  ��ʾ��ʽ��ViewHolder �ǰ����б��и��б���Ĳ��ֵ� View �ķ�װ������Adapter ��
  ������Ҫ���� ViewHolder ���󣬻���Ϊ��Щ��ͼ�������ݡ�����ͼ��������������Ĺ���
  ��Ϊ���󶨡���



    