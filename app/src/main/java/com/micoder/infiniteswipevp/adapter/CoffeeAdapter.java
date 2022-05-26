package com.micoder.infiniteswipevp.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.micoder.infiniteswipevp.R;
import com.micoder.infiniteswipevp.model.Coffee;

import java.util.List;

public class CoffeeAdapter extends PagerAdapter {

    private Context context;
    private List<Coffee> listCoffee;

    public CoffeeAdapter(Context context, List<Coffee> listCoffee) {
        this.context = context;
        this.listCoffee = listCoffee;
    }

    @Override
    public int getCount() {
        return listCoffee.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_food,container,false);

        ImageView ivImage=view.findViewById(R.id.iv_image);
        ImageView ivDecoration=view.findViewById(R.id.iv_decoration);
        TextView tvTitle=view.findViewById(R.id.tv_title);
        TextView tvSubtitle=view.findViewById(R.id.tv_subtitle);
        TextView tvDesc=view.findViewById(R.id.tv_desc);
        RelativeLayout relativeBack=view.findViewById(R.id.relative_back);

        ivImage.setImageResource(listCoffee.get(position).getImage());
        ivDecoration.setImageResource(listCoffee.get(position).getDecoration());
        relativeBack.setBackgroundResource(listCoffee.get(position).getBackground());
        tvTitle.setText(listCoffee.get(position).getTitle());
        tvSubtitle.setText(listCoffee.get(position).getSubTitle());
        tvDesc.setText(listCoffee.get(position).getDescription());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+listCoffee, Toast.LENGTH_SHORT).show();
            }
        });

        container.addView(view);

        return view;
    }
}
