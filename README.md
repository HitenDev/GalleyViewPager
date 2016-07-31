# GalleyViewPager
先看效果

![](https://github.com/ileelay/GalleyViewPager/blob/master/screen/screen.gif)

这是一个用ViewPager实现的Galley，与普通的画廊不同的是，第一张图片和最后一张图片与两侧是没有间隙的

代码很简单，是基于ViewPager修改，主要是修改子View的Measure宽度

```
GalleyViewPager viewPager = (GalleyViewPager) findViewById(R.id.viewPager);
        //设置Page之间的Margin值
        viewPager.setPageMargin((int) (20*density));
        //设置右侧的显示宽度
        viewPager.setEndWidth((int) (80*density));
        //设置Adapter
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 5;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = new ImageView(container.getContext());
                imageView.setImageResource(R.mipmap.car);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                container.addView(imageView);
                return imageView;

            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });
    //设置setOffscreenPageLimit为Pager的个数，必须要设置
    viewPager.setOffscreenPageLimit(5);

```
