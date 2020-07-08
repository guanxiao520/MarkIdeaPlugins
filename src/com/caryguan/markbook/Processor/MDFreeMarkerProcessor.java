package com.caryguan.markbook.Processor;

import com.intellij.ide.fileTemplates.impl.UrlUtil;
import com.intellij.util.io.URLUtil;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.HashMap;

/**
 * @Author GuanCary
 * @Date 2020/7/8 18:58
 * @Version 1.0
 **/
public class MDFreeMarkerProcessor extends AbstractFreeMarkProcessor {
    @Override
    protected Object getModel(SourceNoteData sourceNoteData) {
        //获取数据
        HashMap model = new HashMap();
        model.put("topic", sourceNoteData.getTopic());
        model.put("noteList", sourceNoteData.getNoteList());
        return model;
    }

    @Override
    protected Template getTemplate() throws IOException {
        //指定版本2.3.28
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        String templateContent = UrlUtil.loadText(MDFreeMarkerProcessor.class.getResource("/template/md.ftl"));
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        stringTemplateLoader.putTemplate("MDTemplate", templateContent);
        configuration.setTemplateLoader(stringTemplateLoader);
        return configuration.getTemplate("MDTemplate");
    }

    @Override
    protected Writer getWriter(SourceNoteData sourceNoteData) throws FileNotFoundException,
            UnsupportedEncodingException {
        String fileName = sourceNoteData.fileName();
        File file = new File(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
        return bufferedWriter;
    }
}