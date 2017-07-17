# AutoBanner
自动无限轮播图

Step 1. Add the JitPack repository to your build file
```
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency
```
	dependencies {
	        compile 'com.github.Brioal:AutoBanner:1.2'
	}
```
## 多次加载之后可能会造成不能滑动的问题，暂时解决办法是显示之前先调用mBannerView.removeAllViews()方法
