---
author: Xie Haijun
title: 自建博客（一） - 初识HUGO
description: Hugo 是 Go 编写的静态网站生成器，速度快，易用，可配置。依赖于 Markdown 文件，Hugo 只需要几分之一秒就可以渲染一个经典的中型网站，Hugo 非常适合博客，文档等等网站的生成。
date: 2022-11-13
#lastmod: 2022-11-12T00:50:00+08:00
lastmod: #BUILD_TIME
keywords: [ "Hugo", "博客", "blog" ]
slug: blog-1-chinese
image: https://images.ewancle.com/blog/imghugo-what.png
# 如果要在该帖子/页面中使用库，请使用前面的参数 math。
# math: true
categories:
    - DevOps # 和 content/categories下的分类目录同名
#    - 测试
categoryes_weight: 1
tags: 
    - Blog
tags_weight: 1

---

<!-- {{< audio-music 1304708603 >}} -->
<!-- 设置说明 https://www.jianshu.com/p/1f974b6fb2dd -->
{{< music id="1901371647" server="netease" type="song" auto="netease" fixed="false" mini="false" autoplay="true" theme="#2980b9" loop="all" order="list" preload="auto" volume="0.1" mutex="true" lrc-type="1" list-folded="false" >}}



![Hugo](https://images.ewancle.com/blog/imghugo-logo-wide.svg) 

## Hugo 简介

在网络发达的信息时代，一直使用搜索引擎查询各种资料和跳坑的参考示例，大部分都会跳到别人博客下。有时候一篇排版井然有序，有归档有搜索的博文能带来事倍功半的效果。我以前一直使用文本，excel，word等文档记录，但是用下来发现有时候多台电脑办公很难同步，而且归档凌乱，不方便查找。感觉自己组建一个私人博客很有必要，第一用来做技术笔记，第二很符合程序员的分享精神，第三可以学习新技术。

目前了解下来，市面上主流的，能静态托管的开源框架有【ruby语言的[jekyll](https://link.zhihu.com/?target=https%3A//github.com/mojombo/jekyll)  , nodejs语言的[hexo](https://link.zhihu.com/?target=https%3A//github.com/tommy351/hexo) , Java语言的[solo](https://github.com/88250/solo) ......】

今天我们要介绍的框架叫作[Hugo](https://gohugo.io/getting-started/quick-start/)。Hugo 是一个基于Go 语言的框架，也可以快速方便的创建自己的博客。

原生 Markdown 和 Emacs Org-Mode 支持，以及通过*外部助手*支持的其他语言（请参阅[支持的格式](https://gohugo.io/content-management/formats/)），我们可以将自己的文章写成Markdown 的格式，放在我们用Hugo 创建的博客系统中，从而展示给他人。

## 动手实践
### 安装 {#foo}

[预构建的二进制包安装](https://gohugo.io/installation/windows/#prebuilt-binaries)：

预构建的二进制文件可用于各种操作系统和架构。访问[最新发布](https://github.com/gohugoio/hugo/releases/latest)页面，然后向下滚动到资产部分。

1. 下载所需[风格](https://gohugo.io/installation/windows/#flavors)、操作系统和架构的存档（Hugo 有两种：标准版和扩展版。扩展版支持 编码 WebP 图像 和  使用嵌入式 LibSass 转译器将 Sass 转译为 CSS。建议安装扩展版。

   > *[Hugo预编 - 全平台最新版本](https://github.com/gohugoio/hugo/releases)* 
   
   ```
   hugo_0.105.0_darwin-universal.tar.gz - 标准版：苹果Mac OS系统（适用M1和X86）  
   hugo_0.105.0_dragonfly-amd64.tar.gz - 标准版：*DragonFly* BSD（适用英特尔和AMD）  
   hugo_0.105.0_freebsd-amd64.tar.gz - 标准版：freebsd  BSD（适用英特尔和AMD）  
   hugo_0.105.0_Linux-64bit.tar.gz - 标准版：通用Linux（适用英特尔和AMD）  
   hugo_0.105.0_linux-amd64.deb - 标准版：Debian/Ubuntu（适用英特尔和AMD）  
   hugo_0.105.0_linux-amd64.tar.gz - 标准版：通用Linux（适用英特尔和AMD）  
   hugo_0.105.0_linux-arm.tar.gz - 标准版：通用Linux（ARM芯片）  
   hugo_0.105.0_linux-arm64.deb - 标准版：Debian/Ubuntu（ARM芯片）  
   hugo_0.105.0_linux-arm64.tar.gz - 标准版：通用Linux（ARM芯片）  
   hugo_0.105.0_netbsd-amd64.tar.gz - 标准版：netbsd（适用英特尔和AMD） 
   hugo_0.105.0_openbsd-amd64.tar.gz - 标准版：openbsd（适用英特尔和AMD）  
   hugo_0.105.0_windows-amd64.zip - 标准版：Windows（适用英特尔和AMD）  
   hugo_0.105.0_windows-arm64.zip - 标准版：Windows（ARM芯片）  
   hugo_extended_0.105.0_darwin-universal.tar.gz - 扩展版：苹果Mac OS系统（适用M1和英特尔）  
   hugo_extended_0.105.0_Linux-64bit.tar.gz - 扩展版：通用Linux（适用英特尔和AMD）  
   hugo_extended_0.105.0_linux-amd64.deb - 扩展版：Debian/Ubuntu（适用英特尔和AMD）  
   hugo_extended_0.105.0_linux-amd64.tar.gz - 扩展版：通用Linux（适用英特尔和AMD）  
   hugo_extended_0.105.0_linux-arm64.deb - 扩展版：Debian/Ubuntu（ARM）  
   hugo_extended_0.105.0_linux-arm64.tar.gz - 扩展版：通用Linux（ARM）  
   hugo_extended_0.105.0_windows-amd64.zip - 扩展版：Windows（适用英特尔和AMD）
   ```
2. 例如在Linux安装，安装相关依赖 :

   ```shell
   sudo apt install wget git
   ```
3. [下载软件包](https://github.com/gohugoio/hugo/releases/download/v0.105.0/hugo_extended_0.105.0_linux-amd64.tar.gz) :

   ```sh
   wget https://github.com/gohugoio/hugo/releases/download/v0.105.0/hugo_extended_0.105.0_linux-amd64.tar.gz
   ```

4. 解压软件包 ：

   ```sh
   tar -zxvf hugo_extended_0.105.0_linux-amd64.tar.gz
   ```

5. 配置env，把解压软件的目录添加到$PATH变量后面 ：

   ```shell
   sudo vi /etc/profile
   # 在文件末尾添加如下内容
   export PATH=$PATH:解压目录/bin
   
   # 添加完按ESC退出编辑，英文输入模式下，按住shift键输入:  打上x，最后回车就好了
   #最后让配置生效
   source /etc/profile
   ```

​			

[Windows](https://gohugo.io/installation/windows/) 安装：

1. [Chocolatey](https://chocolatey.org/) 包管理工具安装：

   ```powershell
   choco install hugo-extended
   ```

2. [Scoop](https://scoop.sh/) 包管理工具安装：

   ```powershell
   scoop install hugo-extended
   ```

   

[macOS](https://gohugo.io/installation/macos/) 安装：

1. [Homebrew](https://brew.sh/) 包管理器安装：
    {{< highlight Bash "linenos=inline" >}}
    brew install hugo
    {{< / highlight >}}
2. [MacPorts](https://www.macports.org/) 包管理器安装：
   
   ```shell
   sudo port install hugo
   ```

[Linux](https://gohugo.io/installation/linux/) 安装：
1. [Snap](https://snapcraft.io/) 包管理器安装：
   
   ```shell
   sudo snap install hugo
   ```
   
2. [Homebrew](https://brew.sh/) 包管理器安装：
   
   ```shell
   brew install hugo
   ```
   
3. [Arch Linux](https://archlinux.org/) 系统自带包管理安装：

   ```shell
   sudo pacman -S hugo
   ```

4. [Debian](https://www.debian.org/) 系统自带包管理安装：

   ```shell
   sudo apt install hugo
   ```

5. [Fedora](https://getfedora.org/) 系统自带包管理安装：

   ```shell
   sudo dnf install hugo
   ```

6.  [openSUSE](https://www.opensuse.org/) 系统自带包管理安装：

   ```shell
   sudo zypper install hugo
   ```

7. [Solus](https://getsol.us/home/) 系统自带包管理安装：

   ```shell
   sudo eopkg install hugo
   ```

[Docker images](https://hub.docker.com/r/klakegg/hugo) 容器安装： 

- docker 镜像运行：

  ```dockerfile
  docker pull klakegg/hugo
  ```

  


## 测试验证

如果还没安装好，请点击[安装教程]({{< relref "#foo" >}})

1. 上面安装告一段路，现在打开系统命令行工具，执行如下命令返回版本信息才算成功：

   ```sh
   % hugo -versoin
   
   Start building sites … 
   hugo v0.105.0+extended darwin/amd64 BuildDate=unknown
   INFO 2022/11/13 10:00:59 syncing static files to /
   WARN 2022/11/13 10:00:59 Search page not found. Create a page with layout: search.
   WARN 2022/11/13 10:00:59 Archives page not found. Create a page with layout: archives.
   WARN 2022/11/13 10:00:59 Search page not found. Create a page with layout: search.
   WARN 2022/11/13 10:00:59 Archives page not found. Create a page with layout: archives.
   ```

2. 创建第一个自己的博客站点：

   ```sh
   % hugo new site my-first-blog
   
   # 进入目录
   % cd my-first-blog
   
   # 查看目录结构（需要用到一个工具：sudo apt-get install tree 或者 苹果系统：brew install tree
   % tree -Ca
   
   ├── archetypes          原型，定制预先配置的前言设定 
   │   └── default.md
   ├── config.toml         站点配置文件
   ├── content             此目录用于包含网站的所有内容
   ├── data                此目录用于保存Hugo生成站点时所用的配置文件。
   ├── layouts             此目录存储.html文件作为布局模板，这些模板声明了内容视图在静态站点的呈现。
   ├── public              此目录存储每次发布之前，编译的站点静态文件。
   ├── static              此目录用于存放静态内容:图片、CSS、javascript等。 当构建站点时，这些静态目录内资源会被原封不动copy过去。
   └── themes              存在主题的目录
   ```

3. 配置第三方主题[hugo-theme-stack](https://github.com/nonomal/hugo-theme-stack)

   针对已经关联git的站点执行：~~git submodule add https://github.com/CaiJimmy/hugo-theme-stack/ themes/hugo-theme-stack~~

   ```sh
   % git clone https://github.com/CaiJimmy/hugo-theme-stack/ themes/hugo-theme-stack
   
   hugo-theme-stack/ themes/hugo-theme-stack
   Cloning into 'themes/hugo-theme-stack'...
   remote: Enumerating objects: 4272, done.
   remote: Counting objects: 100% (93/93), done.
   remote: Compressing objects: 100% (63/63), done.
   remote: Total 4272 (delta 43), reused 69 (delta 30), pack-reused 4179
   Receiving objects: 100% (4272/4272), 1.06 MiB | 2.57 MiB/s, done.
   Resolving deltas: 100% (2712/2712), done.
   
   # 复制安装的主题默认配置
   % cp -rf themes/hugo-theme-stack/exampleSite/* ./
   
   # 备份Hugo默认的站点配置文件
   % mv config.toml config.toml.back
   
   # 最后观察下项目目录变化（查看两层目录）tree -P *.pl
   % % tree -F -L 2
   ./
   ├── LICENSE
   ├── README.md
   ├── archetypes/
   │   └── default.md
   ├── config.toml.back
   ├── config.yaml
   ├── content/
   │   ├── _index.md
   │   ├── _index.zh-cn.md
   │   ├── categories/
   │   ├── page/
   │   └── post/
   ├── data/
   ├── layouts/
   ├── public/
   ├── static/
   └── themes/
       └── hugo-theme-stack/
   ```

4. 本地运行预览

   ```sh
   % hugo server
   
   Start building sites … 
   hugo v0.105.0+extended darwin/amd64 BuildDate=unknown
   ERROR 2022/11/13 10:57:11 Failed to get JSON resource "https://publish.twitter.com/oembed?dnt=false&omit_script=true&url=https%3A%2F%2Ftwitter.com%2FDesignReviewed%2Fstatus%2F1085870671291310081": Get "https://publish.twitter.com/oembed?dnt=false&omit_script=true&url=https%3A%2F%2Ftwitter.com%2FDesignReviewed%2Fstatus%2F1085870671291310081": dial tcp 104.244.43.136:443: i/o timeout
   If you feel that this should not be logged as an ERROR, you can ignore it by adding this to your site config:
   ignoreErrors = ["error-remote-getjson"]
   Error: Error building site: "/Users/xxx/workspace/blog/my-first-blog/content/post/rich-content/index.md:1:1": timed out initializing value. You may have a circular loop in a shortcode, or your site may have resources that take longer to build than the `timeout` limit in your Hugo config file.
   Built in 30094 ms
   
   # 发现有循环依赖的页面报错。直接删除报错的文件夹
   % rm -rf content/post/rich-content
   % hugo server
   
   Start building sites … 
   hugo v0.105.0+extended darwin/amd64 BuildDate=unknown
   WARN 2022/11/13 11:00:14 Search page not found. Create a page with layout: search.
   WARN 2022/11/13 11:00:14 Archives page not found. Create a page with layout: archives.
   WARN 2022/11/13 11:00:14 Search page not found. Create a page with layout: search.
   WARN 2022/11/13 11:00:14 Archives page not found. Create a page with layout: archives.
   
                      | EN | ZH-CN | AR  
   -------------------+----+-------+-----
     Pages            | 42 |    17 | 20  
     Paginator pages  |  1 |     0 |  0  
     Non-page files   |  5 |     4 |  1  
     Static files     |  0 |     0 |  0  
     Processed images | 14 |    13 |  3  
     Aliases          | 21 |     7 |  9  
     Sitemaps         |  2 |     1 |  1  
     Cleaned          |  0 |     0 |  0  
   
   Built in 430 ms
   Watching for changes in /Users/xiehaijun/workspace/blog/my-first-blog/{archetypes,content,data,layouts,static,themes}
   Watching for config changes in /Users/xiehaijun/workspace/blog/my-first-blog/config.yaml, /Users/xiehaijun/workspace/blog/my-first-blog/themes/hugo-theme-stack/config.yaml
   Environment: "development"
   Serving pages from memory
   Running in Fast Render Mode. For full rebuilds on change: hugo server --disableFastRender
   Web Server is available at http://localhost:1313/ (bind address 127.0.0.1)
   Press Ctrl+C to stop
   ```

5. 复制上面提示的内容：http://localhost:1313/ 这就是本地运行的blog![初次运行的本地Blog](https://images.ewancle.com/blog/imghugo-init-page.png)
