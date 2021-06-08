package com.coinker.lombok.mylombok;


import com.sun.source.tree.Tree;
import com.sun.tools.javac.api.JavacTrees;
import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.tree.TreeTranslator;
import com.sun.tools.javac.util.*;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;


/**
 * @author Cui Shenpeng
 * @Classname GetterProcessor
 * @Description TODO
 * @Date 2021/6/8 17:19
 */
@SupportedAnnotationTypes("com.coinker.lombok.mylombok.Getter.java")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class GetterProcessor extends AbstractProcessor {
    // 打印log
    private Messager messager;
    // 抽象语法树
    private JavacTrees trees;
    // 封装了创建AST节点的一些方法
    private TreeMaker treeMaker;
    // 提供了创建标识符的一些方法
    private Names names;

    // 初始化方法
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.messager = processingEnv.getMessager();
        this.trees = JavacTrees.instance(processingEnv);
        Context context = ((JavacProcessingEnvironment) processingEnv).getContext();
        this.treeMaker = TreeMaker.instance(context);
        this.names = Names.instance(context);
    }

    // 真正处理注解的方法
    @Override
    public synchronized boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
// 获取所有包含Getter注解的类
        try {
            Set<? extends Element> set = roundEnv.getElementsAnnotatedWith(Getter.class);
            set.forEach(element -> {
                JCTree jcTree = trees.getTree(element);
                jcTree.accept(new TreeTranslator() {
                    @Override
                    public void visitClassDef(JCTree.JCClassDecl jcClassDecl) {
                        List<JCTree.JCVariableDecl> jcVariableDeclList = List.nil();
                        // 获取所有属性
                        for (JCTree tree : jcClassDecl.defs) {
                            if (tree.getKind().equals(Tree.Kind.VARIABLE)) {
                                JCTree.JCVariableDecl jcVariableDecl = (JCTree.JCVariableDecl) tree;
                                jcVariableDeclList = jcVariableDeclList.append(jcVariableDecl);
                            }
                        }
                        // 为每一个属性创建get方法
                        jcVariableDeclList.forEach(jcVariableDecl -> {
                            messager.printMessage(Diagnostic.Kind.NOTE, jcVariableDecl.getName() + " has been processed");
                            jcClassDecl.defs = jcClassDecl.defs.prepend(makeGetterMethodDecl(jcVariableDecl));
                        });
                        super.visitClassDef(jcClassDecl);
                    }

                });
            });

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    // 创建getter方法
    private JCTree.JCMethodDecl makeGetterMethodDecl(JCTree.JCVariableDecl jcVariableDecl) {

        ListBuffer<JCTree.JCStatement> statements = new ListBuffer<>();
        statements.append(treeMaker.Return(treeMaker.Select(treeMaker.Ident(names.fromString("this")), jcVariableDecl.getName())));
        JCTree.JCBlock body = treeMaker.Block(0, statements.toList());
        return treeMaker.MethodDef(treeMaker.Modifiers(Flags.PUBLIC), getNewMethodName(jcVariableDecl.getName()), jcVariableDecl.vartype, List.nil(), List.nil(), List.nil(), body, null);
    }

    // 获取方法名
    private Name getNewMethodName(Name name) {
        String s = name.toString();
        return names.fromString("get" + s.substring(0, 1).toUpperCase() + s.substring(1, name.length()));
    }
}

