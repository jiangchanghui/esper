/*
 * *************************************************************************************
 *  Copyright (C) 2006-2015 EsperTech, Inc. All rights reserved.                       *
 *  http://www.espertech.com/esper                                                     *
 *  http://www.espertech.com                                                           *
 *  ---------------------------------------------------------------------------------- *
 *  The software in this package is published under the terms of the GPL license       *
 *  a copy of which has been included with this distribution in the license.txt file.  *
 * *************************************************************************************
 */

package com.espertech.esper.epl.expression.dot.inner;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.EventType;
import com.espertech.esper.epl.expression.core.ExprEvaluatorContext;
import com.espertech.esper.epl.expression.core.ExprEvaluatorEnumeration;
import com.espertech.esper.epl.expression.dot.ExprDotEvalRootChildInnerEval;
import com.espertech.esper.epl.rettype.EPType;
import com.espertech.esper.epl.rettype.EPTypeHelper;

import java.util.Collection;

public class InnerEvaluatorEnumerableEventBean implements ExprDotEvalRootChildInnerEval {

    private final ExprEvaluatorEnumeration rootLambdaEvaluator;
    private final EventType eventType;

    public InnerEvaluatorEnumerableEventBean(ExprEvaluatorEnumeration rootLambdaEvaluator, EventType eventType) {
        this.rootLambdaEvaluator = rootLambdaEvaluator;
        this.eventType = eventType;
    }

    public Object evaluate(EventBean[] eventsPerStream, boolean isNewData, ExprEvaluatorContext context) {
        return rootLambdaEvaluator.evaluateGetEventBean(eventsPerStream, isNewData, context);
    }

    public Collection<EventBean> evaluateGetROCollectionEvents(EventBean[] eventsPerStream, boolean isNewData, ExprEvaluatorContext context) {
        return rootLambdaEvaluator.evaluateGetROCollectionEvents(eventsPerStream, isNewData, context);
    }

    public Collection evaluateGetROCollectionScalar(EventBean[] eventsPerStream, boolean isNewData, ExprEvaluatorContext context) {
        return rootLambdaEvaluator.evaluateGetROCollectionScalar(eventsPerStream, isNewData, context);
    }

    public EventType getEventTypeCollection() {
        return null;
    }

    public Class getComponentTypeCollection() {
        return null;
    }

    public EventBean evaluateGetEventBean(EventBean[] eventsPerStream, boolean isNewData, ExprEvaluatorContext context) {
        return rootLambdaEvaluator.evaluateGetEventBean(eventsPerStream, isNewData, context);
    }

    public EventType getEventTypeSingle() {
        return eventType;
    }

    public EPType getTypeInfo() {
        return EPTypeHelper.singleEvent(eventType);
    }
}
