/*
 * generated by Xtext 2.34.0
 */
package org.nadeeshaan.d3dsl.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.nadeeshaan.d3dsl.d3Dsl.D3DslPackage;
import org.nadeeshaan.d3dsl.d3Dsl.Greeting;
import org.nadeeshaan.d3dsl.d3Dsl.Model;
import org.nadeeshaan.d3dsl.services.D3DslGrammarAccess;

@SuppressWarnings("all")
public class D3DslSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private D3DslGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == D3DslPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case D3DslPackage.GREETING:
				sequence_Greeting(context, (Greeting) semanticObject); 
				return; 
			case D3DslPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Greeting returns Greeting
	 *
	 * Constraint:
	 *     name=ID
	 * </pre>
	 */
	protected void sequence_Greeting(ISerializationContext context, Greeting semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, D3DslPackage.Literals.GREETING__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, D3DslPackage.Literals.GREETING__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getGreetingAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     greetings+=Greeting+
	 * </pre>
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
