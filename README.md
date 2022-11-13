Example site modified from https://github.com/gohugoio/hugoBasicExample
## 整个流程运行的提交说明： git commit -m '发布博客-->同步代码-->[python清除缓存 , java清除缓存]-->发布release'

### 替换构建时间：sed -e "s/#BUILD_TIME/$(TZ=Asia/Shanghai date '+%Y-%m-%dT%H:%M:%S+08:00')/g" -i.bak  content/**/*.md  参考：https://mirrors.tuna.tsinghua.edu.cn/help/centos/ 和 https://www.cnblogs.com/gejuncheng/p/16425822.html


# VSCode 代码格式化 快捷键 (安装插件：https://marketplace.visualstudio.com/items?itemName=redhat.vscode-yaml)
### On Windows：Shift + Alt + F
### On Mac：Shift + Option + F
### On Ubuntu：Ctrl + Shift + I

## 开发github action ： https://juejin.cn/post/6870372475188969479

### 判断git最近两次是否有差异，有就返回1，没有返回0 ： git diff --quiet HEAD^ HEAD -- ./generated.txt（参考：https://nickjanetakis.com/blog/git-diff-has-a-quiet-flag-to-halt-a-script-if-a-file-was-updated）
### https://vercel.com/ 部署的api有100次的api限制。 【Ignored Build Step】 可以添加上面来忽略构建
### 通过消息内容控制 https://vercel.com/mpv945/xiehaijun-blog-source/deployments 的忽略条件
### 参考grep结合git show使用： https://www.cnblogs.com/jkin/p/11356510.html  : 使用 git show | grep -q '发布博客' 然后使用echo $? 查看是否匹配到，0表示匹配到，1表示没有匹配到。

### 获取actions徽章：https://blog.mafeifan.com/DevOps/GithubActions/GitHub-Actions%E7%9A%84%E5%BE%BD%E7%AB%A0%E5%9B%BE%E6%A0%87.html
### https://github.com/mpv945/xiehaijun-blog-source/workflows/deploy-auto-xie/badge.svg?branch=master

## 比较最近两次差异 git diff @~..@ | grep generated.txt 或 git diff HEAD^ HEAD generated.txt[指定文件]
### github创建分支，点开项目分钟，输入框可以搜索和新增分支，[view all branches]能跳到分支管理：https://github.com/mpv945/xiehaijun-blog-source/branches
### git代理
#### 使用http代理 
#### git config --global http.proxy http://127.0.0.1:8889
#### git config --global https.proxy https://127.0.0.1:8889
#### 使用socks5代理
#### git config --global http.proxy socks5://127.0.0.1:1089
#### git config --global https.proxy socks5://127.0.0.1:1089
#### 取消代理：git config --global --unset http.proxy git config --global --unset https.proxy

### git判读某个目录，两次提交是否有差异：git diff HEAD^ HEAD ./content/
### 本地分支：git branch 查看本地分支；git status 查看本地分支状态
### 新建空分支：git checkout --orphan empty-branch ； 清除内容 git rm -rf . ； 初始化空分支 echo "空分支" > README.md ; 添加暂存：git add . ； 提交说明：git commit -m "Initial commit" ；最后推送：git push empty-branch:success-notifications 
### 新建本地分支：git checkout -b localbranch ；星号(*)表示当前所在分支。现在的状态是成功创建的新的分支并且已经切换到新分支上。
### 删除本地分支 ： git branch -d success-notifications （如果在删除的分支上，要切换到其他分支：git checkout master）

### 推送，新建远程分支：git push origin localbranch:localbranch 使用git branch -a查看所有分支，会看到remotes/origin/localbranch这个远程分支，说明新建远程分支成功。
### 删除远程分支 ： git push origin --delete localbranch 或者 git push origin :localbranch推送一个空分支到远程分支，其实就相当于删除远程分支

### 合并分支：在其他开发分支提交完修改，然后切换到主分支 git checkout master：执行 git merge issue1
### 合并：https://backlog.com/git-tutorial/cn/stepup/stepup2_7.html
### 同步分支列表 ：git fetch -p

### 标签
### 列显已有的标签：git tag ；如果只对 1.4.2 系列的版本感兴趣，可以运行 git tag -l 'v1.4.2.*'
### 创建标签：git tag -a v1.4 -m 'my version 1.4' -a (译注：取 annotated 的首字母)指定标签名字  -m 选项则指定了对应的标签说明
### 查看相应标签的版本信息 git show v1.4
### 删除标签 git tag -d v1.0
### 轻量级标签 git tag v1.4-lw  轻量级标签实际上就是一个保存着对应提交对象的校验和信息的文件。要创建这样的标签，一个 -a，-s 或 -m 选项都不用，直接给出标签名字即可
### 分享标签 git push origin v1.5 默认情况下，git push 并不会把标签传送到远端服务器上，只有通过显式命令才能分享标签到远端仓库。其命令格式如同推送分支
### git push origin --tags  如果要一次推送所有本地新增的标签上去，可以使用 --tags 选项


