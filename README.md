# PyramidTextMenu-java(ptm4j)

---
## 什么是PyramidTextMenu？
![logo](https://img-blog.csdn.net/20181011011530298?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2xnajEyM3hq/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

**PyramidTextMenu**（以下称**PTM**）是一个开源的层级文本菜单框架，使用Java语言，主要使用于创建命令行应用程序、客服机器人、文字游戏等场景。
**PTM**提供了便捷、简明、多样的的层级文本菜单应用程序开发方法，这意味着开发者使用**PTM**即可在非常短的时间内开发出需要的层级菜单应用。

---
## PyramidTextMenu框架优势
 - 开放源代码
 - 简化菜单构建过程
 - 菜单具有完整生命周期，开发更灵活
 - 支持同时向**多用户**提供服务
 - 支持通过脚本语言实现**热更新**或**插件开发**
 - 快速集成到项目

![优势](https://img-blog.csdn.net/20181011071838790?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2xnajEyM3hq/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

---
## PyramidTextMenu的特性
| 特性 | 描述 |
|:--------:| :-------------|
| 多用户 | 向多位用户提供菜单选择的服务 |
| 快速集成 | 灵活的I/O接口使集成更加便捷 |
| 热更新 | 使用脚本文件动态增减菜单选项、创建新菜单 |
| 生命周期| 菜单(目录)拥有完整的生命周期：onCreate()、onLoad()、onStart()、onStop()、onBack()、onUnload() ，开发灵活。|
| 去环形 | 避免产生环形菜单导致无法正常返回至上一级目录 |

---
## 版本更新

### v1.3.0
支持使用脚本语言（Lua）开发TextMenu.