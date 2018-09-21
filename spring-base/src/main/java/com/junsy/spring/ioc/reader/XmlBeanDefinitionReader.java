package com.junsy.spring.ioc.reader;

import com.junsy.spring.ioc.BeanDefinition;
import com.junsy.spring.ioc.BeanReference;
import com.junsy.spring.ioc.PropertyValue;
import com.junsy.spring.ioc.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * 功能描述:
 *
 * @author: YinShiJun
 * @date: 2018/9/20
 * @version:1.0.0
 * @Copyright (c) 深圳市爱桔iorange科技有限公司-版权所有
 */
public class XmlBeanDefinitionReader  extends  AbstractBeanDefinitionReader{

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }


    @Override
    public void loadBeanDefinitions(String location) throws Exception {
        // 获取资源流
        InputStream inputStream = getResourceLoader().getResource(location).getInoutStream();
        // 解析资源流
        doLoanBeanDefinition(inputStream);


    }

    protected void doLoanBeanDefinition(InputStream inputStream) throws Exception  {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputStream);

        // 注册beanDefinition
        registerBeanDefinitions(document);
        // 关闭输入流
        if (inputStream != null) {
            inputStream.close();
        }

    }

    /**
     *
     * @param document
     */
    public void registerBeanDefinitions(Document document) {
        Element root = document.getDocumentElement();
        parseBeanDefinitions(root);

    }

    /**
     * 完成了 xml  To BeanDefinition的转换
     * @param root
     */
    protected void parseBeanDefinitions(Element root) {
        // 获取所有节点
        NodeList nodeList = root.getChildNodes();
        for(int i=0; i< nodeList.getLength();i++) {
            Node node = nodeList.item(i);
            if (node  instanceof Element) {
                processBeanDefinition((Element) node);
            }
        }

    }

    /**
     * 解析对应结点
     * @param element
     */
    protected void processBeanDefinition(Element element) {

        String name = element.getAttribute("id");
        String className = element.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        // 解析bean属性
        processProperty(element,beanDefinition);
        beanDefinition.setBeanClassName(className);
        getRegistry().put(name, beanDefinition);
    }


    /**
     * 解析属性
     * @param element
     * @param beanDefinition
     */
    protected void processProperty(Element element, BeanDefinition beanDefinition) {

        NodeList nodeList = element.getElementsByTagName("property");
        for (int i=0;i<nodeList.getLength();i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                // 属性赋值
                Element ele = (Element) node;
                String name = ele.getAttribute("name");
                // 加载属性相关 value 对应
                String value = ele.getAttribute("value");
                if (value != null && value.length() > 0) {
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,value));
                }
                // 加载 ref 关联对象,转换成 BeanReference 对象
                String ref = ele.getAttribute("ref");
                if (ref != null && ref.length() > 0) {
                    BeanReference reference = new BeanReference(ref);
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,reference));
                }
            }
        }

    }


}
