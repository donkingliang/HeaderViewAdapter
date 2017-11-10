# HeaderViewAdapter
HeaderViewAdapter可以对已有的RecyclerView.Adapter进行包装，使其具备给列表添加头部和添加尾部的功能。就相当给RecyclerView扩展了类似ListView的addHeaderView和addFooterView的功能。

**效果图** 

![LinearList](https://github.com/donkingliang/HeaderViewAdapter/blob/master/%E6%95%88%E6%9E%9C%E5%9B%BE/LinearList.gif)   ![GridList](https://github.com/donkingliang/HeaderViewAdapter/blob/master/%E6%95%88%E6%9E%9C%E5%9B%BE/GridList.gif)

**1、引入依赖** 

在Project的build.gradle在添加以下代码

```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
在Module的build.gradle在添加以下代码

```
	compile 'com.github.donkingliang:HeaderViewAdapter:1.1.0'
```
