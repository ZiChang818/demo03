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
![imag](https://github.com/ZiChang818/demo03/blob/master/photo/alistview%E8%BF%90%E8%A1%8C%E5%9B%BE.png)






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

![imag](https://github.com/ZiChang818/demo03/blob/master/photo/alterdialog%E7%95%8C%E9%9D%A2%E9%A2%84%E8%A7%88%E5%9B%BE.png)

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

![imag](https://github.com/ZiChang818/demo03/blob/master/photo/alterdialog%E7%95%8C%E9%9D%A2%E8%BF%90%E8%A1%8C%E5%9B%BE.png)





使用xml定义菜单

1、定义main3activity

```
public class Main3Activity extends AppCompatActivity {

    // 定义“字体大小”菜单项的标识
    private static final int FONT_10 = 0x111;
    private static final int FONT_16 = 0x114;
    private static final int FONT_20 = 0x115;
    // 定义“普通菜单项”的标识
    private static final int PLAIN_ITEM = 0x11b;
    // 定义“字体颜色”菜单项的标识
    private static final int FONT_RED = 0x116;
    private static final int FONT_BLACK = 0x118;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        text = findViewById(R.id.txt);
    }
    // 当用户单击MENU键时触发该方法
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // -------------向menu中添加“字体大小”的子菜单-------------
        SubMenu fontMenu = menu.addSubMenu("字体大小");


        // 设置菜单头的标题
        fontMenu.setHeaderTitle("选择字体大小");
        fontMenu.add(0, FONT_10, 0, "10号字体");
        fontMenu.add(0, FONT_16, 0, "16号字体");
        fontMenu.add(0, FONT_20, 0, "20号字体");
        // -------------向menu中添加“普通菜单项”-------------
        menu.add(0, PLAIN_ITEM, 0, "普通菜单项");
        // -------------向menu中添加“字体颜色”的子菜单-------------
        SubMenu colorMenu = menu.addSubMenu("字体颜色");

        // 设置菜单头的图标

        // 设置菜单头的标题
        colorMenu.setHeaderTitle("选择文字颜色");
        colorMenu.add(0, FONT_RED, 0, "红色");
        colorMenu.add(0, FONT_BLACK, 0, "黑色");
        return super.onCreateOptionsMenu(menu);
    }
    // 选项菜单的菜单项被单击后的回调方法
    @Override
    public boolean onOptionsItemSelected(MenuItem mi)
    {
        // 判断单击的是哪个菜单项，并有针对性地做出响应
        switch (mi.getItemId())
        {
            case FONT_10: text.setTextSize(10 * 2);	break;

            case FONT_16: text.setTextSize(16 * 2); break;
            case FONT_20: text.setTextSize(20 * 2); break;
            case FONT_RED: text.setTextColor(Color.RED); break;
            case FONT_BLACK: text.setTextColor(Color.BLACK); break;
            case PLAIN_ITEM:
                Toast.makeText(Main3Activity.this,
                        "您单击了普通菜单项", Toast.LENGTH_SHORT)
                        .show();
                break;
        }
        return true;
    }
}
```

2、layout.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <TextView
        android:id="@+id/txt"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="hello! 818"></TextView>
</LinearLayout>
```

效果图：
![imag](https://github.com/ZiChang818/demo03/blob/master/photo/xml%E5%AE%9A%E4%B9%89%E8%8F%9C%E5%8D%951.png)
![imag](https://github.com/ZiChang818/demo03/blob/master/photo/xml%E5%AE%9A%E4%B9%89%E8%8F%9C%E5%8D%95%E6%9B%B4%E6%94%B9%E5%A4%A7%E5%B0%8F.png)
![imag](https://github.com/ZiChang818/demo03/blob/master/photo/xml%E5%AE%9A%E4%B9%89%E8%8F%9C%E5%8D%95%E6%9B%B4%E6%94%B9%E9%A2%9C%E8%89%B2.png)







创建上下文操作模式（ActionMode）的上下文菜单

1、

2、

3、

4、



