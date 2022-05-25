package com.micoder.infiniteswipevp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import com.micoder.infiniteswipevp.adapter.CoffeeAdapter;
import com.micoder.infiniteswipevp.model.Coffee;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView ivLogo;
    Animation animLogoMove, animTransition;
    RelativeLayout relativeMain;

    HorizontalInfiniteCycleViewPager viewPager;
    List<Coffee> listCoffee = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivLogo=findViewById(R.id.iv_logo);
        viewPager=findViewById(R.id.view_pager);
        relativeMain=findViewById(R.id.relative_main);

        animLogoMove= AnimationUtils.loadAnimation(this,R.anim.logo_move);
        animTransition= AnimationUtils.loadAnimation(this,R.anim.transition);

        initData();

        CoffeeAdapter adapter=new CoffeeAdapter(this,listCoffee);
        viewPager.setAdapter(adapter);

        ivLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ivLogo.setVisibility(View.VISIBLE);
                ivLogo.startAnimation(animLogoMove);

                viewPager.setVisibility(View.VISIBLE);
                viewPager.startAnimation(animTransition);
            }
        });

    }

    private void initData() {
        listCoffee.add(new Coffee("Something1", "something1", getString(R.string.dummy), R.drawable.cup_capucino, R.drawable.back_cappu, R.drawable.coffee, Color.parseColor("#2d181c")));
        listCoffee.add(new Coffee("Something2", "something2", getString(R.string.dummy), R.drawable.cup_greentea, R.drawable.back_green, R.drawable.tea, Color.parseColor("#5d6d1b")));
        listCoffee.add(new Coffee("Something3", "something3", getString(R.string.dummy), R.drawable.cup_mocha, R.drawable.back_mocha, R.drawable.choco, Color.parseColor("#b38868")));

    }
}