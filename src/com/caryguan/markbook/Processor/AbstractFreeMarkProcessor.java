package com.caryguan.markbook.Processor;

import freemarker.template.Template;

import java.io.IOException;
import java.io.Writer;

/**
 * @Author GuanCary
 * @Date 2020/7/8 18:43
 * @Version 1.0
 **/
public abstract class AbstractFreeMarkProcessor implements Processor {
    /**
     * 三个抽象方法,运用freemark,第一个数据,第二个模板,第三个写出路径
     *
     * @return
     */
    protected abstract Object getModel(SourceNoteData sourceNoteData);

    protected abstract Template getTemplate() throws IOException;

    protected abstract Writer getWriter(SourceNoteData sourceNoteData);
    //标准确定定义为final不能被复写
    @Override
    public final void process(SourceNoteData sourceNoteData) throws Exception {
        Template template = getTemplate();
        Object model = getModel(sourceNoteData);
        Writer writer = getWriter(sourceNoteData);
        template.process(model, writer);
    }
}