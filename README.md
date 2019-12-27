# P-Maven
Project Maven (for Android Studio)

# 简介
对优秀的项目代码进行管理
类似官方Browse Samples 不同点以module方式提供，方便开发者，而且都是更实际价值的项目


# 记录
window界面可以考虑左面是listview，同时右面是detailview的样式





task makeJar(type:Jar){
    archivesBaseName = 'xxx.jar'
    destinationDir = file('build/libs')
    from('build/intermediates/javac/debug/classes')
    manifest {
        attributes (
                'M-name':'xxx',
                'class':'cccc'
        )
    }
    ///home/karl/work/android/android-studio/jre
    //export PATH=/home/karl/work/android/android-studio/jre/bin:$PATH
    //java -Dorg.gradle.appname=gradlew -classpath /home/karl/桌面/app/gradle/wrapper/gradle-wrapper.jar org.gradle.wrapper.GradleWrapperMain
}
makeJar.dependsOn(app:build)


java -Dorg.gradle.appname=gradlew -classpath /home/karl/桌面/app/gradle/wrapper/gradle-wrapper.jar org.gradle.wrapper.GradleWrapperMain app:makeJar


