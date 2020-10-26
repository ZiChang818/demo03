实验3_ui组件

Android Listvew的用法

1、展示各列表信息（头像以及小信息）

   线性布局文件（simple_item.xml）

```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/background_selector"
    android:orientation="horizontal"
    android:padding="10dp">

    <TextView
        android:id="@+id/animal_name"
        android:layout_width="292dp"
        android:layout_height="91dp"
        android:gravity="center_vertical|left"
        android:textColor="#000000"
        android:textSize="24sp" />

    <ImageView
        android:id="@+id/animal_pic"
        android:layout_width="90dp"
        android:layout_height="91dp"
        android:padding="10dp" />
</LinearLayout>
```

 添加信息：

```
 public String[] names = new String[] {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
    public int[] images = new int[] {R.drawable.lion, R.drawable.tiger, R.drawable.monkey,
            R.drawable.dog, R.drawable.cat, R.drawable.elephant};
```

输出内容：

```
//输出内容
        List<Map<String, Object>> listitems = new ArrayList<>();
        for(int i=0;i<names.length;i++){
            Map<String,Object> listitem =new HashMap<>();
            listitem.put("animal_name",names[i]);
            listitem.put("animal_pic",images[i]);
            listitems.add(listitem);
        }
        final SimpleAdapter simpleAdapter =new SimpleAdapter(this, listitems, R.layout.simple_item,
                new String[]{"animal_name", "animal_pic"}, new int[]{R.id.animal_name, R.id.animal_pic});
        ListView listView = findViewById(R.id.mylist);
        listView.setAdapter(simpleAdapter);
```

效果展示：





2、增加监听器

```
//点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //日志打印点击情况
                Log.i("-CRAZYIT-", names[position] + " clicked");
                Toast toast = Toast.makeText(MainActivity.this, names[position], Toast.LENGTH_SHORT);
                toast.show();
            }
        });
```

3、增加点击背景颜色

   在xml文件里添加：

```
 android:background="@drawable/background_selector"
```

 部署其他的xml文件：

```
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android" >

    <item android:state_pressed="true" android:drawable="@color/pink"></item>
    <item android:drawable="@color/white"></item>
</selector>
```

效果图：





创建自定义布局的AlertDialog

1、login.xml 布局文件

```
<?xml version="1.0" encoding="utf-8"?>
<TableLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/loginForm"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TableRow android:paddingStart="12dp">

        <ImageView
            android:id="@+id/imageView2"
            android:layout_width="match_parent"
            android:layout_height="193dp"
            app:srcCompat="@drawable/apppic" />
    </TableRow>

    <TableRow android:paddingStart="12dp">
        <!-- 输入用户名的文本框 -->
        <EditText
            android:layout_width="460dp"
            android:layout_height="82dp"
            android:hint="Username"
            android:selectAllOnFocus="true"
            android:textSize="24sp" />
    </TableRow>

    <TableRow android:paddingStart="12dp">
        <!-- 输入密码的文本框 -->
        <EditText
            android:layout_width="match_parent"
            android:layout_height="99dp"
            android:hint="Password"
            android:inputType="textPassword"
            android:textSize="24sp" />
    </TableRow>

</TableLayout>
```

效果预览图



2、mainactivity进入

```
public class Main2Activity extends Activity {
    private TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);
        show = findViewById(R.id.show);
    }

    public void customView(View source) {
        // 加载\res\layout\login.xml界面布局文件
        TableLayout loginForm = (TableLayout) getLayoutInflater().inflate(R.layout.login, null);
        new AlertDialog.Builder(this)
        // 设置对话框的标题
        .setTitle("  ANDROID APP  ")
        // 设置对话框显示的View对象
        .setView(loginForm)
        // 为对话框设置一个“确定”按钮
        .setPositiveButton("登录", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        })
        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        })
        // 创建并显示对话框
        .create().show();
        }

}
```

运行效果图：





使用xml定义菜单

1、

2、

3、

4、

创建上下文操作模式（ActionMode）的上下文菜单

1、

2、

3、

4、



