https://developer.android.google.cn/guide/topics/ui/layout/recyclerview
************************************************
学习recycleview:
************************************************

RecyclerView 是包含与您的数据对应的视图的 ViewGroup。它本身就是视图，因此，将
RecyclerView 添加到布局中的方式与添加任何其他界面元素相同。

列表中的每个独立元素都由一个 ViewHolder 对象进行定义。创建 ViewHolder 时，它并
没有任何关联的数据。创建 ViewHolder 后，RecyclerView 会将其绑定到其数据。您可
以通过扩展 RecyclerView.ViewHolder 来定义 ViewHolder。

RecyclerView 会请求这些视图，并通过在 Adapter 中调用方法，将视图绑定到其数据。
您可以通过扩展 RecyclerView.Adapter 来定义 Adapter。

布局管理器负责排列列表中的各个元素。您可以使用 RecyclerView 库提供的某个布局
管理器，也可以定义自己的布局管理器。布局管理器均基于库的 LayoutManager 抽象类。

https://github.com/android/views-widgets-samples/tree/main/RecyclerViewKotlin/


实现步骤：
    首先，确定列表或网格的外观。一般来说，您可以使用 RecyclerView 库的某个标准
    布局管理器。
    
    设计列表中每个元素的外观和行为。根据此设计，扩展 ViewHolder 类。您的
    ViewHolder 版本提供了列表项的所有功能。您的 ViewHolder 是 View 的封装容器，
    且该视图由 RecyclerView 管理。
    
    定义用于将您的数据与 ViewHolder 视图相关联的 Adapter。



规划布局：
    LinearLayoutManager:一维列表
    GridLayoutManager:二维网格



实现adapter和viewholder
  确定布局后，您需要实现 Adapter 和 ViewHolder。这两个类配合使用，共同定义数据的
  显示方式。ViewHolder 是包含列表中各列表项的布局的 View 的封装容器。Adapter 会
  根据需要创建 ViewHolder 对象，还会为这些视图设置数据。将视图与其数据相关联的过程
  称为“绑定”。



    