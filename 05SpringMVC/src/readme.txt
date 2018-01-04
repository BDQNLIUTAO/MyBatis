
-----------------配置式开发----------
默认视图解析器

urlPattern问题

无法访问静态资源的解决方式

配置式开发
        BeanNameUrlHandlerMapping

        SimpleHandlermapping

AbstractController改变请求方式
三种方法名称解析器
      默认方法名称解析器
      属性方法名称解析器
      参数名称方法解析器

视图解析器和视图对象
    RedirectView：定义外部资源视图对象
        JstlView：定义内部资源视图对象

xml视图解析器


web.xml
 <!--前端控制器-->
  <servlet>
    <servlet-name>springmvc</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <!--解析：读取哪个Spring配置文件 -->
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:springmvc.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>springmvc</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
1.urlPattern问题：
        最好配成*.do
        不能配成/*      无法访问*.jsp等动态资源
        最好也不要配成/   无法访问静态资源
        不得不配成/

2.解决静态页面无法访问的问题 三种方式：
        方式一:在web.xml中
          <servlet-mapping>
            <servlet-name>default</servlet-name>
            <url-pattern>*.jpg</url-pattern>
          </servlet-mapping>
          <servlet-mapping>
            <servlet-name>default</servlet-name>
            <url-pattern>*.js</url-pattern>
          </servlet-mapping>
        方式二、springmvc.xml中配置节点
        <mvc:default-servlet-handler></mvc:default-servlet-handler>
        方式三 springmvc.xml中配置节点
        <mvc:resources mapping="/image/**" location="/image/"></mvc:resources>


3.配置式开发----BeanNameUrlHandlerMapping
        <!--处理器 映射器-->
        <bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"></bean>
  配置式开发----SimpleUrlHandlerMapping
         <!--处理器映射器-->
            <bean class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping"></bean>
4.视图解析器
        <!--默认视图解析器的名称-->
            <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
                <property name="prefix" value="/"></property>
                <property name="suffix" value=".jsp"></property>
            </bean>
         问题：为什么不需要标识id?
         因为默认视图解析器是系统组件，我们标识上id只不过把系统的覆盖掉

5.-方法名称解析器
    默认值InternalPathMethodNameResolver,该解析器将方法名作为资源名称进行解析，那就意味着，我们提交请求时，要将方法名作为资源名称出现。

    1.默认方法名称解析器  InternalPathMethodNameResolver
      <!--处理器映射器-->
          <bean class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping">
              <property name="urlMap">
                 <map>
                     <entry key="/*.do" value="multiActionController"></entry>
                 </map>
              </property>
          </bean>

          <!--默认视图解析器的名称-->
              <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
                  <property name="prefix" value="/"></property>
                  <property name="suffix" value=".jsp"></property>
              </bean>
              <!--处理器-->  <!--默认方法名称解析器  InternalPathMethodNameResolver
                              访问地址中指定方法名称
                               -->
              <bean id="multiActionController" class="cn.happy.day03.MyMultiActionController">
              </bean>

2. 属性方法名称解析器   PropertiesMethodNameResolver
         <!--处理器映射器-->
            <bean class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping">
                <property name="urlMap">
                   <map>
                       <entry key="/hello.do" value="multiActionController"></entry>
                   </map>
                </property>
            </bean>
            <!--属性方法名称解析器  PropertiesMethodNameResolver
            访问格式：first.do   /   second.do
            -->
            <bean id="propertyNameResolver" class="org.springframework.web.servlet.mvc.multiaction.PropertiesMethodNameResolver">
                <property name="mappings">
                    <props>
                        <prop key="/first.do">doFirst</prop>
                        <prop key="/second.do">doSecond</prop>
                    </props>
                </property>
            </bean>

           <!--默认视图解析器的名称-->
               <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
                   <property name="prefix" value="/"></property>
                   <property name="suffix" value=".jsp"></property>
               </bean>
               <!--处理器-->  <!--默认方法名称解析器  InternalPathMethodNameResolver
                               访问地址中指定方法名称
                                -->
               <bean id="multiActionController" class="cn.happy.day03.MyMultiActionController">
                   <property name="methodNameResolver" ref="propertyNameResolver" ></property>
               </bean>


3.参数方法名称解析器   ParameterMethodNameResolver
    <!--处理器映射器-->
        <bean class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping">
            <property name="urlMap">
               <map>
                   <entry key="/hello.do" value="multiActionController"></entry>
               </map>
            </property>
        </bean>

        <!--参数方法名称解析器  ParameterMethodNameResolver
             访问格式: /hello.do?actionName=doFirst/doSecond
             -->
            <bean id="parameterNameResolver" class="org.springframework.web.servlet.mvc.multiaction.ParameterMethodNameResolver">
                <property name="paramName" value="actionName"></property>   <!--value值不写默认为action-->
            </bean>
            <!--默认视图解析器的名称-->
            <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
                <property name="prefix" value="/"></property>
                <property name="suffix" value=".jsp"></property>
            </bean>
            <!--处理器-->  <!--默认方法名称解析器  InternalPathMethodNameResolver
                            访问地址中指定方法名称
                             -->
            <bean id="multiActionController" class="cn.happy.day03.MyMultiActionController">
                <property name="methodNameResolver" ref="parameterNameResolver" ></property>
            </bean>

BeanName视图解析器
    RedirectView：定义外部资源视图对象
    JstlView：定义内部资源视图对象

    <!--内部视图对象-->
        <bean id="innerView" class="org.springframework.web.servlet.view.JstlView">
            <property name="url" value="/index.jsp"></property>
        </bean>
        <!--外部视图对象-->
        <bean id="jd" class="org.springframework.web.servlet.view.RedirectView">
            <property name="url" value="https://www.jd.com/"></property>
        </bean>
        <!--BeanName视图解析器-->
        <bean class="org.springframework.web.servlet.view.BeanNameViewResolver"/>

xml视图解析器
<!--xml视图解析器-->
    <bean class="org.springframework.web.servlet.view.XmlViewResolver">
        <property name="location" value="classpath:myview.xml"></property>
    </bean>
-------------注解式开发--------------

注解方式实现欢迎界面案例

命名空间

通配符
解释：不是精确匹配，用来代替一批内容的符号  ，匹配作用

请求中方式的定义
   对于@RequestMapping，有一个属性method,用于对被注解方法所处理请求的提交方式进行限制，只有满足该method属性指定的提交方式，才会执行被注解方法。
 method属性的取值为RequestMethod，是一个枚举常量。常用值为
 RequestMethod.GET 与 RequestMethod.POST.

 参数自动装配
           零散参数
           对象参数

 校正请求参数名

 域属性自动装配
      什么叫域属性？
         public class Usrrinfo{
            private Book book;  //域属性
         }


集合属性自动装配

过滤器
  过滤器是向web应用程序中请求和响应添加功能的web服务  过滤器可以集中处理请求和响应

处理器返回值
转发和重定向
  跳转有两种方式：
       转发和重定向
  资源有两种类型：
       页面和处理器
异常
        系统异常
        自定义异常
        异常注解方式

转换器

数据校验

文件上传
   多文件上传

拦截器