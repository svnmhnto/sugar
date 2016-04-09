package com.orm.record;

import com.orm.app.ClientApp;
import com.orm.SugarRecord;
import com.orm.dsl.BuildConfig;
import com.orm.model.StringFieldAnnotatedModel;
import com.orm.model.StringFieldExtendedModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static com.orm.SugarRecord.save;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = 18, constants = BuildConfig.class, application = ClientApp.class, packageName = "com.orm.model", manifest = Config.NONE)
public final class StringFieldTests {

    @Test
    public void nullStringExtendedTest() {
        save(new StringFieldExtendedModel());
        StringFieldExtendedModel model = SugarRecord.findById(StringFieldExtendedModel.class, 1);
        assertNull(model.getString());
    }

    @Test
    public void nullStringAnnotatedTest() {
        save(new StringFieldAnnotatedModel());
        StringFieldAnnotatedModel model = SugarRecord.findById(StringFieldAnnotatedModel.class, 1);
        assertNull(model.getString());
    }

    @Test
    public void stringExtendedTest() {
        String string = "Test String";
        save(new StringFieldExtendedModel(string));
        StringFieldExtendedModel model = SugarRecord.findById(StringFieldExtendedModel.class, 1);
        assertEquals(string, model.getString());
    }

    @Test
    public void stringAnnotatedTest() {
        String string = "Test String";
        save(new StringFieldAnnotatedModel(string));
        StringFieldAnnotatedModel model = SugarRecord.findById(StringFieldAnnotatedModel.class, 1);
        assertEquals(string, model.getString());
    }
}
