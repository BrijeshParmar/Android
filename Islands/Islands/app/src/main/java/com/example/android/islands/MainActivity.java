package com.example.android.islands;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int nextInt(){
        int x=(Math.random()<0.5)?0:1; return x;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final float scale = this.getResources().getDisplayMetrics().density;
        int pixels = (int) (64 * scale + 0.5f);
        int white=pixels/4;
        //View v=new TextView();
        //Random r= new Random(3);

        //System.out.println(nextInt());
        final int[][] a = new int[][]
                {{nextInt(),nextInt() , nextInt(),nextInt(),nextInt()},
                {nextInt(), nextInt(),nextInt() , nextInt(), nextInt()},
                {nextInt(),nextInt(),nextInt(), nextInt(), nextInt()},
                {nextInt(), nextInt(), nextInt(), nextInt(), nextInt()},
                {nextInt(), nextInt(), nextInt(), nextInt(),nextInt()}
        };

        LinearLayout parent = (LinearLayout) findViewById(R.id.rl);
        parent.setOrientation(LinearLayout.VERTICAL);
        for(int hk=0;hk<5;hk++){
            //setContentView(parent);
            LinearLayout linearLayout= new LinearLayout(this);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            //setContentView(linearLayout);
            for(int jk=0;jk<5;jk++){

                if(a[hk][jk]==1){

                    TextView textView = new TextView(this);
                    textView.setBackgroundResource(R.color.colorPrimaryDark);
                    textView.setText("");
                    textView.setWidth(pixels);
                    textView.setHeight(pixels);
                    linearLayout.addView(textView);
                }
                else{
                    TextView textView = new TextView(this);
                    textView.setText("");
                    textView.setWidth(pixels);
                    textView.setHeight(pixels);
                    textView.setBackgroundResource(R.color.colorPrimary);
                    textView.setBackgroundColor(0);
                    linearLayout.addView(textView);
                }
            }
           // parent.addView(tv);
            parent.addView(linearLayout);

        }
        final EditText et=new EditText(this);
        et.setHint("Enter number of islands");
        parent.addView(et);

        Button b= new Button(this);
        Button r=new Button(this);

        b.setText("Submit");
        r.setText("Reset");
        parent.addView(b);
        parent.addView(r);
        final Button tv=new Button(this);
        new CountDownTimer(10000, 1000) {

            @Override
            public void onTick(long l) {
                tv.setText("Time :"+l/1000);
            }

            @Override
            public void onFinish() {
                tv.setText("Time Up");
                showResult(3);

            }
        }.start();
        parent.addView(tv);
        final Handler handle =new Handler();

        //final TextView tx=new TextView(this);
       // parent.addView(tx);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(et.getText().toString().trim().length()==0){
                    showResult(2);
                }
                else if(Integer.valueOf(et.getText().toString())==countIslands(a)){
                    showResult(1);
                    handle.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    },3000);
                    Intent i = getBaseContext().getPackageManager()
                            .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                else{
                    showResult(0);
                }
            }
        });
        r.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        System.out.println("Number of Islands is: " +
                countIslands(a));
    }

    void showResult(int i) {
        if(i==3){
            Toast.makeText(this,"Too Slow!Try Next",Toast.LENGTH_SHORT).show();
        }
        else if(i==2){
            Toast.makeText(this,"Please Enter Valid Number",Toast.LENGTH_SHORT).show();
        }
        else if(i==1)
            Toast.makeText(this,"You Are Correct!",Toast.LENGTH_SHORT).show();
        else{
            Toast.makeText(this,"Try Another number!",Toast.LENGTH_SHORT).show();

        }

    }

    static int countIslands(int a[][])
    {
        int n = a.length;
        int m = a[0].length;

        DisjointUnionSets dus = new DisjointUnionSets(n*m);

		/* The following loop checks for its neighbours
		and unites the indexes if both are 1. */
        for (int j=0; j<n; j++)
        {
            for (int k=0; k<m; k++)
            {
                // If cell is 0, nothing to do
                if (a[j][k] == 0)
                    continue;

                // Check all 8 neighbours and do a union
                // with neighbour's set if neighbour is
                // also 1
                if (j+1 < n && a[j+1][k]==1)
                    dus.union(j*(m)+k, (j+1)*(m)+k);
                if (j-1 >= 0 && a[j-1][k]==1)
                    dus.union(j*(m)+k, (j-1)*(m)+k);
                if (k+1 < m && a[j][k+1]==1)
                    dus.union(j*(m)+k, (j)*(m)+k+1);
                if (k-1 >= 0 && a[j][k-1]==1)
                    dus.union(j*(m)+k, (j)*(m)+k-1);
                if (j+1<n && k+1<m && a[j+1][k+1]==1)
                    dus.union(j*(m)+k, (j+1)*(m)+k+1);
                if (j+1<n && k-1>=0 && a[j+1][k-1]==1)
                    dus.union(j*m+k, (j+1)*(m)+k-1);
                if (j-1>=0 && k+1<m && a[j-1][k+1]==1)
                    dus.union(j*m+k, (j-1)*m+k+1);
                if (j-1>=0 && k-1>=0 && a[j-1][k-1]==1)
                    dus.union(j*m+k, (j-1)*m+k-1);
            }
        }

        // Array to note down frequency of each set
        int[] c = new int[n*m];
        int numberOfIslands = 0;
        for (int j=0; j<n; j++)
        {
            for (int k=0; k<m; k++)
            {
                if (a[j][k]==1)
                {

                    int x = dus.find(j*m+k);

                    // If frequency of set is 0,
                    // increment numberOfIslands
                    if (c[x]==0)
                    {
                        numberOfIslands++;
                        c[x]++;
                    }

                    else
                        c[x]++;
                }
            }
        }
        return numberOfIslands;
    }
}

// Class to represent Disjoint Set Data structure
class DisjointUnionSets
{
    int[] rank, parent;
    int n;

    public DisjointUnionSets(int n)
    {
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        makeSet();
    }

    void makeSet()
    {
        // Initially, all elements are in their
        // own set.
        for (int i=0; i<n; i++)
            parent[i] = i;
    }

    // Finds the representative of the set that x
    // is an element of
    int find(int x)
    {
        if (parent[x] != x)
        {
            // if x is not the parent of itself,
            // then x is not the representative of
            // its set.
            // so we recursively call Find on its parent
            // and move i's node directly under the
            // representative of this set
            return find(parent[x]);
        }

        return x;
    }

    // Unites the set that includes x and the set
    // that includes y
    void union(int x, int y)
    {
        // Find the representatives (or the root nodes)
        // for x an y
        int xRoot = find(x);
        int yRoot = find(y);

        // Elements are in the same set, no need
        // to unite anything.
        if (xRoot == yRoot)
            return;

        // If x's rank is less than y's rank
        // Then move x under y so that depth of tree
        // remains less
        if (rank[xRoot] < rank[yRoot])
            parent[xRoot] = yRoot;

            // Else if y's rank is less than x's rank
            // Then move y under x so that depth of tree
            // remains less
        else if(rank[yRoot]<rank[xRoot])
            parent[yRoot] = xRoot;

        else // Else if their ranks are the same
        {
            // Then move y under x (doesn't matter
            // which one goes where)
            parent[yRoot] = xRoot;

            // And increment the the result tree's
            // rank by 1
            rank[xRoot] = rank[xRoot] + 1;
        }
    }
}
