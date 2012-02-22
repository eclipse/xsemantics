package it.xsemantics.example.expressions.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import it.xsemantics.example.expressions.services.ExpressionsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalExpressionsParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'*'", "'/'", "'<'", "'=='", "'||'", "'&&'", "'true'", "'false'", "'='", "'+'", "'-'", "'('", "')'", "'!'"
    };
    public static final int RULE_ID=4;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalExpressionsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalExpressionsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalExpressionsParser.tokenNames; }
    public String getGrammarFileName() { return "../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g"; }


     
     	private ExpressionsGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ExpressionsGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleModel"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:61:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:62:1: ( ruleModel EOF )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:63:1: ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelRule()); 
            }
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel67);
            ruleModel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel74); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:70:1: ruleModel : ( ( rule__Model__VariablesAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:74:2: ( ( ( rule__Model__VariablesAssignment )* ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:75:1: ( ( rule__Model__VariablesAssignment )* )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:75:1: ( ( rule__Model__VariablesAssignment )* )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:76:1: ( rule__Model__VariablesAssignment )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getVariablesAssignment()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:77:1: ( rule__Model__VariablesAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:77:2: rule__Model__VariablesAssignment
            	    {
            	    pushFollow(FOLLOW_rule__Model__VariablesAssignment_in_ruleModel100);
            	    rule__Model__VariablesAssignment();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getVariablesAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleVariable"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:89:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:90:1: ( ruleVariable EOF )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:91:1: ruleVariable EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableRule()); 
            }
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable128);
            ruleVariable();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable135); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:98:1: ruleVariable : ( ( rule__Variable__Group__0 ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:102:2: ( ( ( rule__Variable__Group__0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:103:1: ( ( rule__Variable__Group__0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:103:1: ( ( rule__Variable__Group__0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:104:1: ( rule__Variable__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableAccess().getGroup()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:105:1: ( rule__Variable__Group__0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:105:2: rule__Variable__Group__0
            {
            pushFollow(FOLLOW_rule__Variable__Group__0_in_ruleVariable161);
            rule__Variable__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleExpression"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:117:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:118:1: ( ruleExpression EOF )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:119:1: ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression188);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression195); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:126:1: ruleExpression : ( ruleAddition ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:130:2: ( ( ruleAddition ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:131:1: ( ruleAddition )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:131:1: ( ruleAddition )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:132:1: ruleAddition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getAdditionParserRuleCall()); 
            }
            pushFollow(FOLLOW_ruleAddition_in_ruleExpression221);
            ruleAddition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getAdditionParserRuleCall()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAddition"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:145:1: entryRuleAddition : ruleAddition EOF ;
    public final void entryRuleAddition() throws RecognitionException {
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:146:1: ( ruleAddition EOF )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:147:1: ruleAddition EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionRule()); 
            }
            pushFollow(FOLLOW_ruleAddition_in_entryRuleAddition247);
            ruleAddition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddition254); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAddition"


    // $ANTLR start "ruleAddition"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:154:1: ruleAddition : ( ( rule__Addition__Group__0 ) ) ;
    public final void ruleAddition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:158:2: ( ( ( rule__Addition__Group__0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:159:1: ( ( rule__Addition__Group__0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:159:1: ( ( rule__Addition__Group__0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:160:1: ( rule__Addition__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getGroup()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:161:1: ( rule__Addition__Group__0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:161:2: rule__Addition__Group__0
            {
            pushFollow(FOLLOW_rule__Addition__Group__0_in_ruleAddition280);
            rule__Addition__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleMultiplication"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:173:1: entryRuleMultiplication : ruleMultiplication EOF ;
    public final void entryRuleMultiplication() throws RecognitionException {
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:174:1: ( ruleMultiplication EOF )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:175:1: ruleMultiplication EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplication_in_entryRuleMultiplication307);
            ruleMultiplication();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicationRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplication314); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMultiplication"


    // $ANTLR start "ruleMultiplication"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:182:1: ruleMultiplication : ( ( rule__Multiplication__Group__0 ) ) ;
    public final void ruleMultiplication() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:186:2: ( ( ( rule__Multiplication__Group__0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:187:1: ( ( rule__Multiplication__Group__0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:187:1: ( ( rule__Multiplication__Group__0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:188:1: ( rule__Multiplication__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getGroup()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:189:1: ( rule__Multiplication__Group__0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:189:2: rule__Multiplication__Group__0
            {
            pushFollow(FOLLOW_rule__Multiplication__Group__0_in_ruleMultiplication340);
            rule__Multiplication__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicationAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRuleComparison"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:201:1: entryRuleComparison : ruleComparison EOF ;
    public final void entryRuleComparison() throws RecognitionException {
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:202:1: ( ruleComparison EOF )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:203:1: ruleComparison EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonRule()); 
            }
            pushFollow(FOLLOW_ruleComparison_in_entryRuleComparison367);
            ruleComparison();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleComparison374); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleComparison"


    // $ANTLR start "ruleComparison"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:210:1: ruleComparison : ( ( rule__Comparison__Group__0 ) ) ;
    public final void ruleComparison() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:214:2: ( ( ( rule__Comparison__Group__0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:215:1: ( ( rule__Comparison__Group__0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:215:1: ( ( rule__Comparison__Group__0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:216:1: ( rule__Comparison__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getGroup()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:217:1: ( rule__Comparison__Group__0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:217:2: rule__Comparison__Group__0
            {
            pushFollow(FOLLOW_rule__Comparison__Group__0_in_ruleComparison400);
            rule__Comparison__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRuleBooleanExpression"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:229:1: entryRuleBooleanExpression : ruleBooleanExpression EOF ;
    public final void entryRuleBooleanExpression() throws RecognitionException {
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:230:1: ( ruleBooleanExpression EOF )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:231:1: ruleBooleanExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression427);
            ruleBooleanExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanExpressionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanExpression434); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBooleanExpression"


    // $ANTLR start "ruleBooleanExpression"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:238:1: ruleBooleanExpression : ( ( rule__BooleanExpression__Group__0 ) ) ;
    public final void ruleBooleanExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:242:2: ( ( ( rule__BooleanExpression__Group__0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:243:1: ( ( rule__BooleanExpression__Group__0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:243:1: ( ( rule__BooleanExpression__Group__0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:244:1: ( rule__BooleanExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getGroup()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:245:1: ( rule__BooleanExpression__Group__0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:245:2: rule__BooleanExpression__Group__0
            {
            pushFollow(FOLLOW_rule__BooleanExpression__Group__0_in_ruleBooleanExpression460);
            rule__BooleanExpression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanExpressionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBooleanExpression"


    // $ANTLR start "entryRuleAtomic"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:257:1: entryRuleAtomic : ruleAtomic EOF ;
    public final void entryRuleAtomic() throws RecognitionException {
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:258:1: ( ruleAtomic EOF )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:259:1: ruleAtomic EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicRule()); 
            }
            pushFollow(FOLLOW_ruleAtomic_in_entryRuleAtomic487);
            ruleAtomic();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtomic494); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAtomic"


    // $ANTLR start "ruleAtomic"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:266:1: ruleAtomic : ( ( rule__Atomic__Alternatives ) ) ;
    public final void ruleAtomic() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:270:2: ( ( ( rule__Atomic__Alternatives ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:271:1: ( ( rule__Atomic__Alternatives ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:271:1: ( ( rule__Atomic__Alternatives ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:272:1: ( rule__Atomic__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getAlternatives()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:273:1: ( rule__Atomic__Alternatives )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:273:2: rule__Atomic__Alternatives
            {
            pushFollow(FOLLOW_rule__Atomic__Alternatives_in_ruleAtomic520);
            rule__Atomic__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAtomic"


    // $ANTLR start "rule__Addition__Alternatives_1_0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:287:1: rule__Addition__Alternatives_1_0 : ( ( ( rule__Addition__Group_1_0_0__0 ) ) | ( ( rule__Addition__Group_1_0_1__0 ) ) );
    public final void rule__Addition__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:291:1: ( ( ( rule__Addition__Group_1_0_0__0 ) ) | ( ( rule__Addition__Group_1_0_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==20) ) {
                alt2=1;
            }
            else if ( (LA2_0==21) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:292:1: ( ( rule__Addition__Group_1_0_0__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:292:1: ( ( rule__Addition__Group_1_0_0__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:293:1: ( rule__Addition__Group_1_0_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAdditionAccess().getGroup_1_0_0()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:294:1: ( rule__Addition__Group_1_0_0__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:294:2: rule__Addition__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_rule__Addition__Group_1_0_0__0_in_rule__Addition__Alternatives_1_0558);
                    rule__Addition__Group_1_0_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAdditionAccess().getGroup_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:298:6: ( ( rule__Addition__Group_1_0_1__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:298:6: ( ( rule__Addition__Group_1_0_1__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:299:1: ( rule__Addition__Group_1_0_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAdditionAccess().getGroup_1_0_1()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:300:1: ( rule__Addition__Group_1_0_1__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:300:2: rule__Addition__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Addition__Group_1_0_1__0_in_rule__Addition__Alternatives_1_0576);
                    rule__Addition__Group_1_0_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAdditionAccess().getGroup_1_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Alternatives_1_0"


    // $ANTLR start "rule__Multiplication__OpAlternatives_1_0_1_0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:309:1: rule__Multiplication__OpAlternatives_1_0_1_0 : ( ( '*' ) | ( '/' ) );
    public final void rule__Multiplication__OpAlternatives_1_0_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:313:1: ( ( '*' ) | ( '/' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            else if ( (LA3_0==12) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:314:1: ( '*' )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:314:1: ( '*' )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:315:1: '*'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicationAccess().getOpAsteriskKeyword_1_0_1_0_0()); 
                    }
                    match(input,11,FOLLOW_11_in_rule__Multiplication__OpAlternatives_1_0_1_0610); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicationAccess().getOpAsteriskKeyword_1_0_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:322:6: ( '/' )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:322:6: ( '/' )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:323:1: '/'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicationAccess().getOpSolidusKeyword_1_0_1_0_1()); 
                    }
                    match(input,12,FOLLOW_12_in_rule__Multiplication__OpAlternatives_1_0_1_0630); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicationAccess().getOpSolidusKeyword_1_0_1_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__OpAlternatives_1_0_1_0"


    // $ANTLR start "rule__Comparison__OpAlternatives_1_0_1_0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:335:1: rule__Comparison__OpAlternatives_1_0_1_0 : ( ( '<' ) | ( '==' ) );
    public final void rule__Comparison__OpAlternatives_1_0_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:339:1: ( ( '<' ) | ( '==' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            else if ( (LA4_0==14) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:340:1: ( '<' )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:340:1: ( '<' )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:341:1: '<'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonAccess().getOpLessThanSignKeyword_1_0_1_0_0()); 
                    }
                    match(input,13,FOLLOW_13_in_rule__Comparison__OpAlternatives_1_0_1_0665); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonAccess().getOpLessThanSignKeyword_1_0_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:348:6: ( '==' )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:348:6: ( '==' )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:349:1: '=='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonAccess().getOpEqualsSignEqualsSignKeyword_1_0_1_0_1()); 
                    }
                    match(input,14,FOLLOW_14_in_rule__Comparison__OpAlternatives_1_0_1_0685); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonAccess().getOpEqualsSignEqualsSignKeyword_1_0_1_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__OpAlternatives_1_0_1_0"


    // $ANTLR start "rule__BooleanExpression__OpAlternatives_1_0_1_0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:361:1: rule__BooleanExpression__OpAlternatives_1_0_1_0 : ( ( '||' ) | ( '&&' ) );
    public final void rule__BooleanExpression__OpAlternatives_1_0_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:365:1: ( ( '||' ) | ( '&&' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            else if ( (LA5_0==16) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:366:1: ( '||' )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:366:1: ( '||' )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:367:1: '||'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanExpressionAccess().getOpVerticalLineVerticalLineKeyword_1_0_1_0_0()); 
                    }
                    match(input,15,FOLLOW_15_in_rule__BooleanExpression__OpAlternatives_1_0_1_0720); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBooleanExpressionAccess().getOpVerticalLineVerticalLineKeyword_1_0_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:374:6: ( '&&' )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:374:6: ( '&&' )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:375:1: '&&'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanExpressionAccess().getOpAmpersandAmpersandKeyword_1_0_1_0_1()); 
                    }
                    match(input,16,FOLLOW_16_in_rule__BooleanExpression__OpAlternatives_1_0_1_0740); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBooleanExpressionAccess().getOpAmpersandAmpersandKeyword_1_0_1_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__OpAlternatives_1_0_1_0"


    // $ANTLR start "rule__Atomic__Alternatives"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:387:1: rule__Atomic__Alternatives : ( ( ( rule__Atomic__Group_0__0 ) ) | ( ( rule__Atomic__Group_1__0 ) ) | ( ( rule__Atomic__Group_2__0 ) ) | ( ( rule__Atomic__Group_3__0 ) ) | ( ( rule__Atomic__Group_4__0 ) ) | ( ( rule__Atomic__Group_5__0 ) ) | ( ( rule__Atomic__Group_6__0 ) ) );
    public final void rule__Atomic__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:391:1: ( ( ( rule__Atomic__Group_0__0 ) ) | ( ( rule__Atomic__Group_1__0 ) ) | ( ( rule__Atomic__Group_2__0 ) ) | ( ( rule__Atomic__Group_3__0 ) ) | ( ( rule__Atomic__Group_4__0 ) ) | ( ( rule__Atomic__Group_5__0 ) ) | ( ( rule__Atomic__Group_6__0 ) ) )
            int alt6=7;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt6=1;
                }
                break;
            case 24:
                {
                alt6=2;
                }
                break;
            case 21:
                {
                alt6=3;
                }
                break;
            case RULE_INT:
                {
                alt6=4;
                }
                break;
            case RULE_STRING:
                {
                alt6=5;
                }
                break;
            case 17:
            case 18:
                {
                alt6=6;
                }
                break;
            case RULE_ID:
                {
                alt6=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:392:1: ( ( rule__Atomic__Group_0__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:392:1: ( ( rule__Atomic__Group_0__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:393:1: ( rule__Atomic__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getGroup_0()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:394:1: ( rule__Atomic__Group_0__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:394:2: rule__Atomic__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Atomic__Group_0__0_in_rule__Atomic__Alternatives774);
                    rule__Atomic__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomicAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:398:6: ( ( rule__Atomic__Group_1__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:398:6: ( ( rule__Atomic__Group_1__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:399:1: ( rule__Atomic__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getGroup_1()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:400:1: ( rule__Atomic__Group_1__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:400:2: rule__Atomic__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Atomic__Group_1__0_in_rule__Atomic__Alternatives792);
                    rule__Atomic__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomicAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:404:6: ( ( rule__Atomic__Group_2__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:404:6: ( ( rule__Atomic__Group_2__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:405:1: ( rule__Atomic__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getGroup_2()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:406:1: ( rule__Atomic__Group_2__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:406:2: rule__Atomic__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Atomic__Group_2__0_in_rule__Atomic__Alternatives810);
                    rule__Atomic__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomicAccess().getGroup_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:410:6: ( ( rule__Atomic__Group_3__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:410:6: ( ( rule__Atomic__Group_3__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:411:1: ( rule__Atomic__Group_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getGroup_3()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:412:1: ( rule__Atomic__Group_3__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:412:2: rule__Atomic__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Atomic__Group_3__0_in_rule__Atomic__Alternatives828);
                    rule__Atomic__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomicAccess().getGroup_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:416:6: ( ( rule__Atomic__Group_4__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:416:6: ( ( rule__Atomic__Group_4__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:417:1: ( rule__Atomic__Group_4__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getGroup_4()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:418:1: ( rule__Atomic__Group_4__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:418:2: rule__Atomic__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Atomic__Group_4__0_in_rule__Atomic__Alternatives846);
                    rule__Atomic__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomicAccess().getGroup_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:422:6: ( ( rule__Atomic__Group_5__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:422:6: ( ( rule__Atomic__Group_5__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:423:1: ( rule__Atomic__Group_5__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getGroup_5()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:424:1: ( rule__Atomic__Group_5__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:424:2: rule__Atomic__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__Atomic__Group_5__0_in_rule__Atomic__Alternatives864);
                    rule__Atomic__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomicAccess().getGroup_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:428:6: ( ( rule__Atomic__Group_6__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:428:6: ( ( rule__Atomic__Group_6__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:429:1: ( rule__Atomic__Group_6__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getGroup_6()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:430:1: ( rule__Atomic__Group_6__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:430:2: rule__Atomic__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__Atomic__Group_6__0_in_rule__Atomic__Alternatives882);
                    rule__Atomic__Group_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomicAccess().getGroup_6()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Alternatives"


    // $ANTLR start "rule__Atomic__ValueAlternatives_5_1_0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:439:1: rule__Atomic__ValueAlternatives_5_1_0 : ( ( 'true' ) | ( 'false' ) );
    public final void rule__Atomic__ValueAlternatives_5_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:443:1: ( ( 'true' ) | ( 'false' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            else if ( (LA7_0==18) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:444:1: ( 'true' )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:444:1: ( 'true' )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:445:1: 'true'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getValueTrueKeyword_5_1_0_0()); 
                    }
                    match(input,17,FOLLOW_17_in_rule__Atomic__ValueAlternatives_5_1_0916); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomicAccess().getValueTrueKeyword_5_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:452:6: ( 'false' )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:452:6: ( 'false' )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:453:1: 'false'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getValueFalseKeyword_5_1_0_1()); 
                    }
                    match(input,18,FOLLOW_18_in_rule__Atomic__ValueAlternatives_5_1_0936); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomicAccess().getValueFalseKeyword_5_1_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__ValueAlternatives_5_1_0"


    // $ANTLR start "rule__Variable__Group__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:468:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:472:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:473:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
            {
            pushFollow(FOLLOW_rule__Variable__Group__0__Impl_in_rule__Variable__Group__0969);
            rule__Variable__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Variable__Group__1_in_rule__Variable__Group__0972);
            rule__Variable__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__0"


    // $ANTLR start "rule__Variable__Group__0__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:480:1: rule__Variable__Group__0__Impl : ( ( rule__Variable__NameAssignment_0 ) ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:484:1: ( ( ( rule__Variable__NameAssignment_0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:485:1: ( ( rule__Variable__NameAssignment_0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:485:1: ( ( rule__Variable__NameAssignment_0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:486:1: ( rule__Variable__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableAccess().getNameAssignment_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:487:1: ( rule__Variable__NameAssignment_0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:487:2: rule__Variable__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Variable__NameAssignment_0_in_rule__Variable__Group__0__Impl999);
            rule__Variable__NameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableAccess().getNameAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__0__Impl"


    // $ANTLR start "rule__Variable__Group__1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:497:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl rule__Variable__Group__2 ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:501:1: ( rule__Variable__Group__1__Impl rule__Variable__Group__2 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:502:2: rule__Variable__Group__1__Impl rule__Variable__Group__2
            {
            pushFollow(FOLLOW_rule__Variable__Group__1__Impl_in_rule__Variable__Group__11029);
            rule__Variable__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Variable__Group__2_in_rule__Variable__Group__11032);
            rule__Variable__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__1"


    // $ANTLR start "rule__Variable__Group__1__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:509:1: rule__Variable__Group__1__Impl : ( '=' ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:513:1: ( ( '=' ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:514:1: ( '=' )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:514:1: ( '=' )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:515:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableAccess().getEqualsSignKeyword_1()); 
            }
            match(input,19,FOLLOW_19_in_rule__Variable__Group__1__Impl1060); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableAccess().getEqualsSignKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__1__Impl"


    // $ANTLR start "rule__Variable__Group__2"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:528:1: rule__Variable__Group__2 : rule__Variable__Group__2__Impl ;
    public final void rule__Variable__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:532:1: ( rule__Variable__Group__2__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:533:2: rule__Variable__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Variable__Group__2__Impl_in_rule__Variable__Group__21091);
            rule__Variable__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__2"


    // $ANTLR start "rule__Variable__Group__2__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:539:1: rule__Variable__Group__2__Impl : ( ( rule__Variable__ExpressionAssignment_2 ) ) ;
    public final void rule__Variable__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:543:1: ( ( ( rule__Variable__ExpressionAssignment_2 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:544:1: ( ( rule__Variable__ExpressionAssignment_2 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:544:1: ( ( rule__Variable__ExpressionAssignment_2 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:545:1: ( rule__Variable__ExpressionAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableAccess().getExpressionAssignment_2()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:546:1: ( rule__Variable__ExpressionAssignment_2 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:546:2: rule__Variable__ExpressionAssignment_2
            {
            pushFollow(FOLLOW_rule__Variable__ExpressionAssignment_2_in_rule__Variable__Group__2__Impl1118);
            rule__Variable__ExpressionAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableAccess().getExpressionAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__2__Impl"


    // $ANTLR start "rule__Addition__Group__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:562:1: rule__Addition__Group__0 : rule__Addition__Group__0__Impl rule__Addition__Group__1 ;
    public final void rule__Addition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:566:1: ( rule__Addition__Group__0__Impl rule__Addition__Group__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:567:2: rule__Addition__Group__0__Impl rule__Addition__Group__1
            {
            pushFollow(FOLLOW_rule__Addition__Group__0__Impl_in_rule__Addition__Group__01154);
            rule__Addition__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Addition__Group__1_in_rule__Addition__Group__01157);
            rule__Addition__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group__0"


    // $ANTLR start "rule__Addition__Group__0__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:574:1: rule__Addition__Group__0__Impl : ( ruleMultiplication ) ;
    public final void rule__Addition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:578:1: ( ( ruleMultiplication ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:579:1: ( ruleMultiplication )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:579:1: ( ruleMultiplication )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:580:1: ruleMultiplication
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleMultiplication_in_rule__Addition__Group__0__Impl1184);
            ruleMultiplication();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group__0__Impl"


    // $ANTLR start "rule__Addition__Group__1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:591:1: rule__Addition__Group__1 : rule__Addition__Group__1__Impl ;
    public final void rule__Addition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:595:1: ( rule__Addition__Group__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:596:2: rule__Addition__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Addition__Group__1__Impl_in_rule__Addition__Group__11213);
            rule__Addition__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group__1"


    // $ANTLR start "rule__Addition__Group__1__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:602:1: rule__Addition__Group__1__Impl : ( ( rule__Addition__Group_1__0 )* ) ;
    public final void rule__Addition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:606:1: ( ( ( rule__Addition__Group_1__0 )* ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:607:1: ( ( rule__Addition__Group_1__0 )* )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:607:1: ( ( rule__Addition__Group_1__0 )* )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:608:1: ( rule__Addition__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getGroup_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:609:1: ( rule__Addition__Group_1__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=20 && LA8_0<=21)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:609:2: rule__Addition__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Addition__Group_1__0_in_rule__Addition__Group__1__Impl1240);
            	    rule__Addition__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group__1__Impl"


    // $ANTLR start "rule__Addition__Group_1__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:623:1: rule__Addition__Group_1__0 : rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1 ;
    public final void rule__Addition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:627:1: ( rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:628:2: rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1
            {
            pushFollow(FOLLOW_rule__Addition__Group_1__0__Impl_in_rule__Addition__Group_1__01275);
            rule__Addition__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Addition__Group_1__1_in_rule__Addition__Group_1__01278);
            rule__Addition__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1__0"


    // $ANTLR start "rule__Addition__Group_1__0__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:635:1: rule__Addition__Group_1__0__Impl : ( ( rule__Addition__Alternatives_1_0 ) ) ;
    public final void rule__Addition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:639:1: ( ( ( rule__Addition__Alternatives_1_0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:640:1: ( ( rule__Addition__Alternatives_1_0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:640:1: ( ( rule__Addition__Alternatives_1_0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:641:1: ( rule__Addition__Alternatives_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getAlternatives_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:642:1: ( rule__Addition__Alternatives_1_0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:642:2: rule__Addition__Alternatives_1_0
            {
            pushFollow(FOLLOW_rule__Addition__Alternatives_1_0_in_rule__Addition__Group_1__0__Impl1305);
            rule__Addition__Alternatives_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditionAccess().getAlternatives_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1__0__Impl"


    // $ANTLR start "rule__Addition__Group_1__1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:652:1: rule__Addition__Group_1__1 : rule__Addition__Group_1__1__Impl ;
    public final void rule__Addition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:656:1: ( rule__Addition__Group_1__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:657:2: rule__Addition__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Addition__Group_1__1__Impl_in_rule__Addition__Group_1__11335);
            rule__Addition__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1__1"


    // $ANTLR start "rule__Addition__Group_1__1__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:663:1: rule__Addition__Group_1__1__Impl : ( ( rule__Addition__RightAssignment_1_1 ) ) ;
    public final void rule__Addition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:667:1: ( ( ( rule__Addition__RightAssignment_1_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:668:1: ( ( rule__Addition__RightAssignment_1_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:668:1: ( ( rule__Addition__RightAssignment_1_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:669:1: ( rule__Addition__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getRightAssignment_1_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:670:1: ( rule__Addition__RightAssignment_1_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:670:2: rule__Addition__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Addition__RightAssignment_1_1_in_rule__Addition__Group_1__1__Impl1362);
            rule__Addition__RightAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditionAccess().getRightAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1__1__Impl"


    // $ANTLR start "rule__Addition__Group_1_0_0__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:684:1: rule__Addition__Group_1_0_0__0 : rule__Addition__Group_1_0_0__0__Impl rule__Addition__Group_1_0_0__1 ;
    public final void rule__Addition__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:688:1: ( rule__Addition__Group_1_0_0__0__Impl rule__Addition__Group_1_0_0__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:689:2: rule__Addition__Group_1_0_0__0__Impl rule__Addition__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__Addition__Group_1_0_0__0__Impl_in_rule__Addition__Group_1_0_0__01396);
            rule__Addition__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Addition__Group_1_0_0__1_in_rule__Addition__Group_1_0_0__01399);
            rule__Addition__Group_1_0_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1_0_0__0"


    // $ANTLR start "rule__Addition__Group_1_0_0__0__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:696:1: rule__Addition__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Addition__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:700:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:701:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:701:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:702:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:703:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:705:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__Addition__Group_1_0_0__1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:715:1: rule__Addition__Group_1_0_0__1 : rule__Addition__Group_1_0_0__1__Impl ;
    public final void rule__Addition__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:719:1: ( rule__Addition__Group_1_0_0__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:720:2: rule__Addition__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Addition__Group_1_0_0__1__Impl_in_rule__Addition__Group_1_0_0__11457);
            rule__Addition__Group_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1_0_0__1"


    // $ANTLR start "rule__Addition__Group_1_0_0__1__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:726:1: rule__Addition__Group_1_0_0__1__Impl : ( '+' ) ;
    public final void rule__Addition__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:730:1: ( ( '+' ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:731:1: ( '+' )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:731:1: ( '+' )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:732:1: '+'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1()); 
            }
            match(input,20,FOLLOW_20_in_rule__Addition__Group_1_0_0__1__Impl1485); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__Addition__Group_1_0_1__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:749:1: rule__Addition__Group_1_0_1__0 : rule__Addition__Group_1_0_1__0__Impl rule__Addition__Group_1_0_1__1 ;
    public final void rule__Addition__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:753:1: ( rule__Addition__Group_1_0_1__0__Impl rule__Addition__Group_1_0_1__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:754:2: rule__Addition__Group_1_0_1__0__Impl rule__Addition__Group_1_0_1__1
            {
            pushFollow(FOLLOW_rule__Addition__Group_1_0_1__0__Impl_in_rule__Addition__Group_1_0_1__01520);
            rule__Addition__Group_1_0_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Addition__Group_1_0_1__1_in_rule__Addition__Group_1_0_1__01523);
            rule__Addition__Group_1_0_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1_0_1__0"


    // $ANTLR start "rule__Addition__Group_1_0_1__0__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:761:1: rule__Addition__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Addition__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:765:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:766:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:766:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:767:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:768:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:770:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1_0_1__0__Impl"


    // $ANTLR start "rule__Addition__Group_1_0_1__1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:780:1: rule__Addition__Group_1_0_1__1 : rule__Addition__Group_1_0_1__1__Impl ;
    public final void rule__Addition__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:784:1: ( rule__Addition__Group_1_0_1__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:785:2: rule__Addition__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Addition__Group_1_0_1__1__Impl_in_rule__Addition__Group_1_0_1__11581);
            rule__Addition__Group_1_0_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1_0_1__1"


    // $ANTLR start "rule__Addition__Group_1_0_1__1__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:791:1: rule__Addition__Group_1_0_1__1__Impl : ( '-' ) ;
    public final void rule__Addition__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:795:1: ( ( '-' ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:796:1: ( '-' )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:796:1: ( '-' )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:797:1: '-'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1()); 
            }
            match(input,21,FOLLOW_21_in_rule__Addition__Group_1_0_1__1__Impl1609); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1_0_1__1__Impl"


    // $ANTLR start "rule__Multiplication__Group__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:814:1: rule__Multiplication__Group__0 : rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1 ;
    public final void rule__Multiplication__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:818:1: ( rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:819:2: rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1
            {
            pushFollow(FOLLOW_rule__Multiplication__Group__0__Impl_in_rule__Multiplication__Group__01644);
            rule__Multiplication__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Multiplication__Group__1_in_rule__Multiplication__Group__01647);
            rule__Multiplication__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group__0"


    // $ANTLR start "rule__Multiplication__Group__0__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:826:1: rule__Multiplication__Group__0__Impl : ( ruleComparison ) ;
    public final void rule__Multiplication__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:830:1: ( ( ruleComparison ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:831:1: ( ruleComparison )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:831:1: ( ruleComparison )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:832:1: ruleComparison
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getComparisonParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleComparison_in_rule__Multiplication__Group__0__Impl1674);
            ruleComparison();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicationAccess().getComparisonParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group__0__Impl"


    // $ANTLR start "rule__Multiplication__Group__1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:843:1: rule__Multiplication__Group__1 : rule__Multiplication__Group__1__Impl ;
    public final void rule__Multiplication__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:847:1: ( rule__Multiplication__Group__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:848:2: rule__Multiplication__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Multiplication__Group__1__Impl_in_rule__Multiplication__Group__11703);
            rule__Multiplication__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group__1"


    // $ANTLR start "rule__Multiplication__Group__1__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:854:1: rule__Multiplication__Group__1__Impl : ( ( rule__Multiplication__Group_1__0 )* ) ;
    public final void rule__Multiplication__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:858:1: ( ( ( rule__Multiplication__Group_1__0 )* ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:859:1: ( ( rule__Multiplication__Group_1__0 )* )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:859:1: ( ( rule__Multiplication__Group_1__0 )* )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:860:1: ( rule__Multiplication__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getGroup_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:861:1: ( rule__Multiplication__Group_1__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=11 && LA9_0<=12)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:861:2: rule__Multiplication__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Multiplication__Group_1__0_in_rule__Multiplication__Group__1__Impl1730);
            	    rule__Multiplication__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicationAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group__1__Impl"


    // $ANTLR start "rule__Multiplication__Group_1__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:875:1: rule__Multiplication__Group_1__0 : rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1 ;
    public final void rule__Multiplication__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:879:1: ( rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:880:2: rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1__0__Impl_in_rule__Multiplication__Group_1__01765);
            rule__Multiplication__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Multiplication__Group_1__1_in_rule__Multiplication__Group_1__01768);
            rule__Multiplication__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1__0"


    // $ANTLR start "rule__Multiplication__Group_1__0__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:887:1: rule__Multiplication__Group_1__0__Impl : ( ( rule__Multiplication__Group_1_0__0 ) ) ;
    public final void rule__Multiplication__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:891:1: ( ( ( rule__Multiplication__Group_1_0__0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:892:1: ( ( rule__Multiplication__Group_1_0__0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:892:1: ( ( rule__Multiplication__Group_1_0__0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:893:1: ( rule__Multiplication__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getGroup_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:894:1: ( rule__Multiplication__Group_1_0__0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:894:2: rule__Multiplication__Group_1_0__0
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0__0_in_rule__Multiplication__Group_1__0__Impl1795);
            rule__Multiplication__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicationAccess().getGroup_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1__0__Impl"


    // $ANTLR start "rule__Multiplication__Group_1__1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:904:1: rule__Multiplication__Group_1__1 : rule__Multiplication__Group_1__1__Impl ;
    public final void rule__Multiplication__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:908:1: ( rule__Multiplication__Group_1__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:909:2: rule__Multiplication__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1__1__Impl_in_rule__Multiplication__Group_1__11825);
            rule__Multiplication__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1__1"


    // $ANTLR start "rule__Multiplication__Group_1__1__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:915:1: rule__Multiplication__Group_1__1__Impl : ( ( rule__Multiplication__RightAssignment_1_1 ) ) ;
    public final void rule__Multiplication__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:919:1: ( ( ( rule__Multiplication__RightAssignment_1_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:920:1: ( ( rule__Multiplication__RightAssignment_1_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:920:1: ( ( rule__Multiplication__RightAssignment_1_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:921:1: ( rule__Multiplication__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getRightAssignment_1_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:922:1: ( rule__Multiplication__RightAssignment_1_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:922:2: rule__Multiplication__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Multiplication__RightAssignment_1_1_in_rule__Multiplication__Group_1__1__Impl1852);
            rule__Multiplication__RightAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicationAccess().getRightAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1__1__Impl"


    // $ANTLR start "rule__Multiplication__Group_1_0__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:936:1: rule__Multiplication__Group_1_0__0 : rule__Multiplication__Group_1_0__0__Impl rule__Multiplication__Group_1_0__1 ;
    public final void rule__Multiplication__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:940:1: ( rule__Multiplication__Group_1_0__0__Impl rule__Multiplication__Group_1_0__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:941:2: rule__Multiplication__Group_1_0__0__Impl rule__Multiplication__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0__0__Impl_in_rule__Multiplication__Group_1_0__01886);
            rule__Multiplication__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0__1_in_rule__Multiplication__Group_1_0__01889);
            rule__Multiplication__Group_1_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1_0__0"


    // $ANTLR start "rule__Multiplication__Group_1_0__0__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:948:1: rule__Multiplication__Group_1_0__0__Impl : ( () ) ;
    public final void rule__Multiplication__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:952:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:953:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:953:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:954:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getMultiOrDivLeftAction_1_0_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:955:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:957:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicationAccess().getMultiOrDivLeftAction_1_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1_0__0__Impl"


    // $ANTLR start "rule__Multiplication__Group_1_0__1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:967:1: rule__Multiplication__Group_1_0__1 : rule__Multiplication__Group_1_0__1__Impl ;
    public final void rule__Multiplication__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:971:1: ( rule__Multiplication__Group_1_0__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:972:2: rule__Multiplication__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0__1__Impl_in_rule__Multiplication__Group_1_0__11947);
            rule__Multiplication__Group_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1_0__1"


    // $ANTLR start "rule__Multiplication__Group_1_0__1__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:978:1: rule__Multiplication__Group_1_0__1__Impl : ( ( rule__Multiplication__OpAssignment_1_0_1 ) ) ;
    public final void rule__Multiplication__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:982:1: ( ( ( rule__Multiplication__OpAssignment_1_0_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:983:1: ( ( rule__Multiplication__OpAssignment_1_0_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:983:1: ( ( rule__Multiplication__OpAssignment_1_0_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:984:1: ( rule__Multiplication__OpAssignment_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getOpAssignment_1_0_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:985:1: ( rule__Multiplication__OpAssignment_1_0_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:985:2: rule__Multiplication__OpAssignment_1_0_1
            {
            pushFollow(FOLLOW_rule__Multiplication__OpAssignment_1_0_1_in_rule__Multiplication__Group_1_0__1__Impl1974);
            rule__Multiplication__OpAssignment_1_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicationAccess().getOpAssignment_1_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1_0__1__Impl"


    // $ANTLR start "rule__Comparison__Group__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:999:1: rule__Comparison__Group__0 : rule__Comparison__Group__0__Impl rule__Comparison__Group__1 ;
    public final void rule__Comparison__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1003:1: ( rule__Comparison__Group__0__Impl rule__Comparison__Group__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1004:2: rule__Comparison__Group__0__Impl rule__Comparison__Group__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group__0__Impl_in_rule__Comparison__Group__02008);
            rule__Comparison__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Comparison__Group__1_in_rule__Comparison__Group__02011);
            rule__Comparison__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__0"


    // $ANTLR start "rule__Comparison__Group__0__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1011:1: rule__Comparison__Group__0__Impl : ( ruleBooleanExpression ) ;
    public final void rule__Comparison__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1015:1: ( ( ruleBooleanExpression ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1016:1: ( ruleBooleanExpression )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1016:1: ( ruleBooleanExpression )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1017:1: ruleBooleanExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getBooleanExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleBooleanExpression_in_rule__Comparison__Group__0__Impl2038);
            ruleBooleanExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getBooleanExpressionParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__0__Impl"


    // $ANTLR start "rule__Comparison__Group__1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1028:1: rule__Comparison__Group__1 : rule__Comparison__Group__1__Impl ;
    public final void rule__Comparison__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1032:1: ( rule__Comparison__Group__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1033:2: rule__Comparison__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group__1__Impl_in_rule__Comparison__Group__12067);
            rule__Comparison__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__1"


    // $ANTLR start "rule__Comparison__Group__1__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1039:1: rule__Comparison__Group__1__Impl : ( ( rule__Comparison__Group_1__0 )* ) ;
    public final void rule__Comparison__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1043:1: ( ( ( rule__Comparison__Group_1__0 )* ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1044:1: ( ( rule__Comparison__Group_1__0 )* )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1044:1: ( ( rule__Comparison__Group_1__0 )* )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1045:1: ( rule__Comparison__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getGroup_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1046:1: ( rule__Comparison__Group_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=13 && LA10_0<=14)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1046:2: rule__Comparison__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Comparison__Group_1__0_in_rule__Comparison__Group__1__Impl2094);
            	    rule__Comparison__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__1__Impl"


    // $ANTLR start "rule__Comparison__Group_1__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1060:1: rule__Comparison__Group_1__0 : rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1 ;
    public final void rule__Comparison__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1064:1: ( rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1065:2: rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1__0__Impl_in_rule__Comparison__Group_1__02129);
            rule__Comparison__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Comparison__Group_1__1_in_rule__Comparison__Group_1__02132);
            rule__Comparison__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1__0"


    // $ANTLR start "rule__Comparison__Group_1__0__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1072:1: rule__Comparison__Group_1__0__Impl : ( ( rule__Comparison__Group_1_0__0 ) ) ;
    public final void rule__Comparison__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1076:1: ( ( ( rule__Comparison__Group_1_0__0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1077:1: ( ( rule__Comparison__Group_1_0__0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1077:1: ( ( rule__Comparison__Group_1_0__0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1078:1: ( rule__Comparison__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getGroup_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1079:1: ( rule__Comparison__Group_1_0__0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1079:2: rule__Comparison__Group_1_0__0
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0__0_in_rule__Comparison__Group_1__0__Impl2159);
            rule__Comparison__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getGroup_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1__0__Impl"


    // $ANTLR start "rule__Comparison__Group_1__1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1089:1: rule__Comparison__Group_1__1 : rule__Comparison__Group_1__1__Impl ;
    public final void rule__Comparison__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1093:1: ( rule__Comparison__Group_1__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1094:2: rule__Comparison__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1__1__Impl_in_rule__Comparison__Group_1__12189);
            rule__Comparison__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1__1"


    // $ANTLR start "rule__Comparison__Group_1__1__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1100:1: rule__Comparison__Group_1__1__Impl : ( ( rule__Comparison__RightAssignment_1_1 ) ) ;
    public final void rule__Comparison__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1104:1: ( ( ( rule__Comparison__RightAssignment_1_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1105:1: ( ( rule__Comparison__RightAssignment_1_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1105:1: ( ( rule__Comparison__RightAssignment_1_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1106:1: ( rule__Comparison__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getRightAssignment_1_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1107:1: ( rule__Comparison__RightAssignment_1_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1107:2: rule__Comparison__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Comparison__RightAssignment_1_1_in_rule__Comparison__Group_1__1__Impl2216);
            rule__Comparison__RightAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getRightAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1__1__Impl"


    // $ANTLR start "rule__Comparison__Group_1_0__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1121:1: rule__Comparison__Group_1_0__0 : rule__Comparison__Group_1_0__0__Impl rule__Comparison__Group_1_0__1 ;
    public final void rule__Comparison__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1125:1: ( rule__Comparison__Group_1_0__0__Impl rule__Comparison__Group_1_0__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1126:2: rule__Comparison__Group_1_0__0__Impl rule__Comparison__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0__0__Impl_in_rule__Comparison__Group_1_0__02250);
            rule__Comparison__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Comparison__Group_1_0__1_in_rule__Comparison__Group_1_0__02253);
            rule__Comparison__Group_1_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0__0"


    // $ANTLR start "rule__Comparison__Group_1_0__0__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1133:1: rule__Comparison__Group_1_0__0__Impl : ( () ) ;
    public final void rule__Comparison__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1137:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1138:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1138:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1139:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getComparisonLeftAction_1_0_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1140:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1142:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getComparisonLeftAction_1_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0__0__Impl"


    // $ANTLR start "rule__Comparison__Group_1_0__1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1152:1: rule__Comparison__Group_1_0__1 : rule__Comparison__Group_1_0__1__Impl ;
    public final void rule__Comparison__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1156:1: ( rule__Comparison__Group_1_0__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1157:2: rule__Comparison__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0__1__Impl_in_rule__Comparison__Group_1_0__12311);
            rule__Comparison__Group_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0__1"


    // $ANTLR start "rule__Comparison__Group_1_0__1__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1163:1: rule__Comparison__Group_1_0__1__Impl : ( ( rule__Comparison__OpAssignment_1_0_1 ) ) ;
    public final void rule__Comparison__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1167:1: ( ( ( rule__Comparison__OpAssignment_1_0_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1168:1: ( ( rule__Comparison__OpAssignment_1_0_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1168:1: ( ( rule__Comparison__OpAssignment_1_0_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1169:1: ( rule__Comparison__OpAssignment_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getOpAssignment_1_0_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1170:1: ( rule__Comparison__OpAssignment_1_0_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1170:2: rule__Comparison__OpAssignment_1_0_1
            {
            pushFollow(FOLLOW_rule__Comparison__OpAssignment_1_0_1_in_rule__Comparison__Group_1_0__1__Impl2338);
            rule__Comparison__OpAssignment_1_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getOpAssignment_1_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0__1__Impl"


    // $ANTLR start "rule__BooleanExpression__Group__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1184:1: rule__BooleanExpression__Group__0 : rule__BooleanExpression__Group__0__Impl rule__BooleanExpression__Group__1 ;
    public final void rule__BooleanExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1188:1: ( rule__BooleanExpression__Group__0__Impl rule__BooleanExpression__Group__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1189:2: rule__BooleanExpression__Group__0__Impl rule__BooleanExpression__Group__1
            {
            pushFollow(FOLLOW_rule__BooleanExpression__Group__0__Impl_in_rule__BooleanExpression__Group__02372);
            rule__BooleanExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BooleanExpression__Group__1_in_rule__BooleanExpression__Group__02375);
            rule__BooleanExpression__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group__0"


    // $ANTLR start "rule__BooleanExpression__Group__0__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1196:1: rule__BooleanExpression__Group__0__Impl : ( ruleAtomic ) ;
    public final void rule__BooleanExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1200:1: ( ( ruleAtomic ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1201:1: ( ruleAtomic )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1201:1: ( ruleAtomic )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1202:1: ruleAtomic
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getAtomicParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleAtomic_in_rule__BooleanExpression__Group__0__Impl2402);
            ruleAtomic();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanExpressionAccess().getAtomicParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group__0__Impl"


    // $ANTLR start "rule__BooleanExpression__Group__1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1213:1: rule__BooleanExpression__Group__1 : rule__BooleanExpression__Group__1__Impl ;
    public final void rule__BooleanExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1217:1: ( rule__BooleanExpression__Group__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1218:2: rule__BooleanExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__BooleanExpression__Group__1__Impl_in_rule__BooleanExpression__Group__12431);
            rule__BooleanExpression__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group__1"


    // $ANTLR start "rule__BooleanExpression__Group__1__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1224:1: rule__BooleanExpression__Group__1__Impl : ( ( rule__BooleanExpression__Group_1__0 )* ) ;
    public final void rule__BooleanExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1228:1: ( ( ( rule__BooleanExpression__Group_1__0 )* ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1229:1: ( ( rule__BooleanExpression__Group_1__0 )* )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1229:1: ( ( rule__BooleanExpression__Group_1__0 )* )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1230:1: ( rule__BooleanExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getGroup_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1231:1: ( rule__BooleanExpression__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=15 && LA11_0<=16)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1231:2: rule__BooleanExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__BooleanExpression__Group_1__0_in_rule__BooleanExpression__Group__1__Impl2458);
            	    rule__BooleanExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanExpressionAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group__1__Impl"


    // $ANTLR start "rule__BooleanExpression__Group_1__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1245:1: rule__BooleanExpression__Group_1__0 : rule__BooleanExpression__Group_1__0__Impl rule__BooleanExpression__Group_1__1 ;
    public final void rule__BooleanExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1249:1: ( rule__BooleanExpression__Group_1__0__Impl rule__BooleanExpression__Group_1__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1250:2: rule__BooleanExpression__Group_1__0__Impl rule__BooleanExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__BooleanExpression__Group_1__0__Impl_in_rule__BooleanExpression__Group_1__02493);
            rule__BooleanExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BooleanExpression__Group_1__1_in_rule__BooleanExpression__Group_1__02496);
            rule__BooleanExpression__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group_1__0"


    // $ANTLR start "rule__BooleanExpression__Group_1__0__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1257:1: rule__BooleanExpression__Group_1__0__Impl : ( ( rule__BooleanExpression__Group_1_0__0 ) ) ;
    public final void rule__BooleanExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1261:1: ( ( ( rule__BooleanExpression__Group_1_0__0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1262:1: ( ( rule__BooleanExpression__Group_1_0__0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1262:1: ( ( rule__BooleanExpression__Group_1_0__0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1263:1: ( rule__BooleanExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getGroup_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1264:1: ( rule__BooleanExpression__Group_1_0__0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1264:2: rule__BooleanExpression__Group_1_0__0
            {
            pushFollow(FOLLOW_rule__BooleanExpression__Group_1_0__0_in_rule__BooleanExpression__Group_1__0__Impl2523);
            rule__BooleanExpression__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanExpressionAccess().getGroup_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group_1__0__Impl"


    // $ANTLR start "rule__BooleanExpression__Group_1__1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1274:1: rule__BooleanExpression__Group_1__1 : rule__BooleanExpression__Group_1__1__Impl ;
    public final void rule__BooleanExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1278:1: ( rule__BooleanExpression__Group_1__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1279:2: rule__BooleanExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__BooleanExpression__Group_1__1__Impl_in_rule__BooleanExpression__Group_1__12553);
            rule__BooleanExpression__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group_1__1"


    // $ANTLR start "rule__BooleanExpression__Group_1__1__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1285:1: rule__BooleanExpression__Group_1__1__Impl : ( ( rule__BooleanExpression__RightAssignment_1_1 ) ) ;
    public final void rule__BooleanExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1289:1: ( ( ( rule__BooleanExpression__RightAssignment_1_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1290:1: ( ( rule__BooleanExpression__RightAssignment_1_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1290:1: ( ( rule__BooleanExpression__RightAssignment_1_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1291:1: ( rule__BooleanExpression__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getRightAssignment_1_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1292:1: ( rule__BooleanExpression__RightAssignment_1_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1292:2: rule__BooleanExpression__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__BooleanExpression__RightAssignment_1_1_in_rule__BooleanExpression__Group_1__1__Impl2580);
            rule__BooleanExpression__RightAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanExpressionAccess().getRightAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group_1__1__Impl"


    // $ANTLR start "rule__BooleanExpression__Group_1_0__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1306:1: rule__BooleanExpression__Group_1_0__0 : rule__BooleanExpression__Group_1_0__0__Impl rule__BooleanExpression__Group_1_0__1 ;
    public final void rule__BooleanExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1310:1: ( rule__BooleanExpression__Group_1_0__0__Impl rule__BooleanExpression__Group_1_0__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1311:2: rule__BooleanExpression__Group_1_0__0__Impl rule__BooleanExpression__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__BooleanExpression__Group_1_0__0__Impl_in_rule__BooleanExpression__Group_1_0__02614);
            rule__BooleanExpression__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BooleanExpression__Group_1_0__1_in_rule__BooleanExpression__Group_1_0__02617);
            rule__BooleanExpression__Group_1_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group_1_0__0"


    // $ANTLR start "rule__BooleanExpression__Group_1_0__0__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1318:1: rule__BooleanExpression__Group_1_0__0__Impl : ( () ) ;
    public final void rule__BooleanExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1322:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1323:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1323:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1324:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getAndOrExpressionLeftAction_1_0_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1325:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1327:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanExpressionAccess().getAndOrExpressionLeftAction_1_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group_1_0__0__Impl"


    // $ANTLR start "rule__BooleanExpression__Group_1_0__1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1337:1: rule__BooleanExpression__Group_1_0__1 : rule__BooleanExpression__Group_1_0__1__Impl ;
    public final void rule__BooleanExpression__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1341:1: ( rule__BooleanExpression__Group_1_0__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1342:2: rule__BooleanExpression__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__BooleanExpression__Group_1_0__1__Impl_in_rule__BooleanExpression__Group_1_0__12675);
            rule__BooleanExpression__Group_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group_1_0__1"


    // $ANTLR start "rule__BooleanExpression__Group_1_0__1__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1348:1: rule__BooleanExpression__Group_1_0__1__Impl : ( ( rule__BooleanExpression__OpAssignment_1_0_1 ) ) ;
    public final void rule__BooleanExpression__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1352:1: ( ( ( rule__BooleanExpression__OpAssignment_1_0_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1353:1: ( ( rule__BooleanExpression__OpAssignment_1_0_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1353:1: ( ( rule__BooleanExpression__OpAssignment_1_0_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1354:1: ( rule__BooleanExpression__OpAssignment_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getOpAssignment_1_0_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1355:1: ( rule__BooleanExpression__OpAssignment_1_0_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1355:2: rule__BooleanExpression__OpAssignment_1_0_1
            {
            pushFollow(FOLLOW_rule__BooleanExpression__OpAssignment_1_0_1_in_rule__BooleanExpression__Group_1_0__1__Impl2702);
            rule__BooleanExpression__OpAssignment_1_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanExpressionAccess().getOpAssignment_1_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group_1_0__1__Impl"


    // $ANTLR start "rule__Atomic__Group_0__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1369:1: rule__Atomic__Group_0__0 : rule__Atomic__Group_0__0__Impl rule__Atomic__Group_0__1 ;
    public final void rule__Atomic__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1373:1: ( rule__Atomic__Group_0__0__Impl rule__Atomic__Group_0__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1374:2: rule__Atomic__Group_0__0__Impl rule__Atomic__Group_0__1
            {
            pushFollow(FOLLOW_rule__Atomic__Group_0__0__Impl_in_rule__Atomic__Group_0__02736);
            rule__Atomic__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Atomic__Group_0__1_in_rule__Atomic__Group_0__02739);
            rule__Atomic__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_0__0"


    // $ANTLR start "rule__Atomic__Group_0__0__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1381:1: rule__Atomic__Group_0__0__Impl : ( '(' ) ;
    public final void rule__Atomic__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1385:1: ( ( '(' ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1386:1: ( '(' )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1386:1: ( '(' )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1387:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getLeftParenthesisKeyword_0_0()); 
            }
            match(input,22,FOLLOW_22_in_rule__Atomic__Group_0__0__Impl2767); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getLeftParenthesisKeyword_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_0__0__Impl"


    // $ANTLR start "rule__Atomic__Group_0__1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1400:1: rule__Atomic__Group_0__1 : rule__Atomic__Group_0__1__Impl rule__Atomic__Group_0__2 ;
    public final void rule__Atomic__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1404:1: ( rule__Atomic__Group_0__1__Impl rule__Atomic__Group_0__2 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1405:2: rule__Atomic__Group_0__1__Impl rule__Atomic__Group_0__2
            {
            pushFollow(FOLLOW_rule__Atomic__Group_0__1__Impl_in_rule__Atomic__Group_0__12798);
            rule__Atomic__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Atomic__Group_0__2_in_rule__Atomic__Group_0__12801);
            rule__Atomic__Group_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_0__1"


    // $ANTLR start "rule__Atomic__Group_0__1__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1412:1: rule__Atomic__Group_0__1__Impl : ( ruleExpression ) ;
    public final void rule__Atomic__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1416:1: ( ( ruleExpression ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1417:1: ( ruleExpression )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1417:1: ( ruleExpression )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1418:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getExpressionParserRuleCall_0_1()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_rule__Atomic__Group_0__1__Impl2828);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getExpressionParserRuleCall_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_0__1__Impl"


    // $ANTLR start "rule__Atomic__Group_0__2"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1429:1: rule__Atomic__Group_0__2 : rule__Atomic__Group_0__2__Impl ;
    public final void rule__Atomic__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1433:1: ( rule__Atomic__Group_0__2__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1434:2: rule__Atomic__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__Atomic__Group_0__2__Impl_in_rule__Atomic__Group_0__22857);
            rule__Atomic__Group_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_0__2"


    // $ANTLR start "rule__Atomic__Group_0__2__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1440:1: rule__Atomic__Group_0__2__Impl : ( ')' ) ;
    public final void rule__Atomic__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1444:1: ( ( ')' ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1445:1: ( ')' )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1445:1: ( ')' )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1446:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getRightParenthesisKeyword_0_2()); 
            }
            match(input,23,FOLLOW_23_in_rule__Atomic__Group_0__2__Impl2885); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getRightParenthesisKeyword_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_0__2__Impl"


    // $ANTLR start "rule__Atomic__Group_1__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1465:1: rule__Atomic__Group_1__0 : rule__Atomic__Group_1__0__Impl rule__Atomic__Group_1__1 ;
    public final void rule__Atomic__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1469:1: ( rule__Atomic__Group_1__0__Impl rule__Atomic__Group_1__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1470:2: rule__Atomic__Group_1__0__Impl rule__Atomic__Group_1__1
            {
            pushFollow(FOLLOW_rule__Atomic__Group_1__0__Impl_in_rule__Atomic__Group_1__02922);
            rule__Atomic__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Atomic__Group_1__1_in_rule__Atomic__Group_1__02925);
            rule__Atomic__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_1__0"


    // $ANTLR start "rule__Atomic__Group_1__0__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1477:1: rule__Atomic__Group_1__0__Impl : ( () ) ;
    public final void rule__Atomic__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1481:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1482:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1482:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1483:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getBooleanNegationAction_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1484:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1486:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getBooleanNegationAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_1__0__Impl"


    // $ANTLR start "rule__Atomic__Group_1__1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1496:1: rule__Atomic__Group_1__1 : rule__Atomic__Group_1__1__Impl rule__Atomic__Group_1__2 ;
    public final void rule__Atomic__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1500:1: ( rule__Atomic__Group_1__1__Impl rule__Atomic__Group_1__2 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1501:2: rule__Atomic__Group_1__1__Impl rule__Atomic__Group_1__2
            {
            pushFollow(FOLLOW_rule__Atomic__Group_1__1__Impl_in_rule__Atomic__Group_1__12983);
            rule__Atomic__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Atomic__Group_1__2_in_rule__Atomic__Group_1__12986);
            rule__Atomic__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_1__1"


    // $ANTLR start "rule__Atomic__Group_1__1__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1508:1: rule__Atomic__Group_1__1__Impl : ( ( '!' ) ) ;
    public final void rule__Atomic__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1512:1: ( ( ( '!' ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1513:1: ( ( '!' ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1513:1: ( ( '!' ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1514:1: ( '!' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getExclamationMarkKeyword_1_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1515:1: ( '!' )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1516:2: '!'
            {
            match(input,24,FOLLOW_24_in_rule__Atomic__Group_1__1__Impl3015); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getExclamationMarkKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_1__1__Impl"


    // $ANTLR start "rule__Atomic__Group_1__2"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1527:1: rule__Atomic__Group_1__2 : rule__Atomic__Group_1__2__Impl ;
    public final void rule__Atomic__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1531:1: ( rule__Atomic__Group_1__2__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1532:2: rule__Atomic__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Atomic__Group_1__2__Impl_in_rule__Atomic__Group_1__23047);
            rule__Atomic__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_1__2"


    // $ANTLR start "rule__Atomic__Group_1__2__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1538:1: rule__Atomic__Group_1__2__Impl : ( ( rule__Atomic__ExpressionAssignment_1_2 ) ) ;
    public final void rule__Atomic__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1542:1: ( ( ( rule__Atomic__ExpressionAssignment_1_2 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1543:1: ( ( rule__Atomic__ExpressionAssignment_1_2 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1543:1: ( ( rule__Atomic__ExpressionAssignment_1_2 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1544:1: ( rule__Atomic__ExpressionAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getExpressionAssignment_1_2()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1545:1: ( rule__Atomic__ExpressionAssignment_1_2 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1545:2: rule__Atomic__ExpressionAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Atomic__ExpressionAssignment_1_2_in_rule__Atomic__Group_1__2__Impl3074);
            rule__Atomic__ExpressionAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getExpressionAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_1__2__Impl"


    // $ANTLR start "rule__Atomic__Group_2__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1561:1: rule__Atomic__Group_2__0 : rule__Atomic__Group_2__0__Impl rule__Atomic__Group_2__1 ;
    public final void rule__Atomic__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1565:1: ( rule__Atomic__Group_2__0__Impl rule__Atomic__Group_2__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1566:2: rule__Atomic__Group_2__0__Impl rule__Atomic__Group_2__1
            {
            pushFollow(FOLLOW_rule__Atomic__Group_2__0__Impl_in_rule__Atomic__Group_2__03110);
            rule__Atomic__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Atomic__Group_2__1_in_rule__Atomic__Group_2__03113);
            rule__Atomic__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_2__0"


    // $ANTLR start "rule__Atomic__Group_2__0__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1573:1: rule__Atomic__Group_2__0__Impl : ( () ) ;
    public final void rule__Atomic__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1577:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1578:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1578:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1579:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getArithmeticSignedAction_2_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1580:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1582:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getArithmeticSignedAction_2_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_2__0__Impl"


    // $ANTLR start "rule__Atomic__Group_2__1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1592:1: rule__Atomic__Group_2__1 : rule__Atomic__Group_2__1__Impl rule__Atomic__Group_2__2 ;
    public final void rule__Atomic__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1596:1: ( rule__Atomic__Group_2__1__Impl rule__Atomic__Group_2__2 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1597:2: rule__Atomic__Group_2__1__Impl rule__Atomic__Group_2__2
            {
            pushFollow(FOLLOW_rule__Atomic__Group_2__1__Impl_in_rule__Atomic__Group_2__13171);
            rule__Atomic__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Atomic__Group_2__2_in_rule__Atomic__Group_2__13174);
            rule__Atomic__Group_2__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_2__1"


    // $ANTLR start "rule__Atomic__Group_2__1__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1604:1: rule__Atomic__Group_2__1__Impl : ( ( '-' ) ) ;
    public final void rule__Atomic__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1608:1: ( ( ( '-' ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1609:1: ( ( '-' ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1609:1: ( ( '-' ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1610:1: ( '-' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getHyphenMinusKeyword_2_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1611:1: ( '-' )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1612:2: '-'
            {
            match(input,21,FOLLOW_21_in_rule__Atomic__Group_2__1__Impl3203); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getHyphenMinusKeyword_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_2__1__Impl"


    // $ANTLR start "rule__Atomic__Group_2__2"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1623:1: rule__Atomic__Group_2__2 : rule__Atomic__Group_2__2__Impl ;
    public final void rule__Atomic__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1627:1: ( rule__Atomic__Group_2__2__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1628:2: rule__Atomic__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Atomic__Group_2__2__Impl_in_rule__Atomic__Group_2__23235);
            rule__Atomic__Group_2__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_2__2"


    // $ANTLR start "rule__Atomic__Group_2__2__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1634:1: rule__Atomic__Group_2__2__Impl : ( ( rule__Atomic__ExpressionAssignment_2_2 ) ) ;
    public final void rule__Atomic__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1638:1: ( ( ( rule__Atomic__ExpressionAssignment_2_2 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1639:1: ( ( rule__Atomic__ExpressionAssignment_2_2 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1639:1: ( ( rule__Atomic__ExpressionAssignment_2_2 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1640:1: ( rule__Atomic__ExpressionAssignment_2_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getExpressionAssignment_2_2()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1641:1: ( rule__Atomic__ExpressionAssignment_2_2 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1641:2: rule__Atomic__ExpressionAssignment_2_2
            {
            pushFollow(FOLLOW_rule__Atomic__ExpressionAssignment_2_2_in_rule__Atomic__Group_2__2__Impl3262);
            rule__Atomic__ExpressionAssignment_2_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getExpressionAssignment_2_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_2__2__Impl"


    // $ANTLR start "rule__Atomic__Group_3__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1657:1: rule__Atomic__Group_3__0 : rule__Atomic__Group_3__0__Impl rule__Atomic__Group_3__1 ;
    public final void rule__Atomic__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1661:1: ( rule__Atomic__Group_3__0__Impl rule__Atomic__Group_3__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1662:2: rule__Atomic__Group_3__0__Impl rule__Atomic__Group_3__1
            {
            pushFollow(FOLLOW_rule__Atomic__Group_3__0__Impl_in_rule__Atomic__Group_3__03298);
            rule__Atomic__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Atomic__Group_3__1_in_rule__Atomic__Group_3__03301);
            rule__Atomic__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_3__0"


    // $ANTLR start "rule__Atomic__Group_3__0__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1669:1: rule__Atomic__Group_3__0__Impl : ( () ) ;
    public final void rule__Atomic__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1673:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1674:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1674:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1675:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getNumberLiteralAction_3_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1676:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1678:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getNumberLiteralAction_3_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_3__0__Impl"


    // $ANTLR start "rule__Atomic__Group_3__1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1688:1: rule__Atomic__Group_3__1 : rule__Atomic__Group_3__1__Impl ;
    public final void rule__Atomic__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1692:1: ( rule__Atomic__Group_3__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1693:2: rule__Atomic__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Atomic__Group_3__1__Impl_in_rule__Atomic__Group_3__13359);
            rule__Atomic__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_3__1"


    // $ANTLR start "rule__Atomic__Group_3__1__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1699:1: rule__Atomic__Group_3__1__Impl : ( ( rule__Atomic__ValueAssignment_3_1 ) ) ;
    public final void rule__Atomic__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1703:1: ( ( ( rule__Atomic__ValueAssignment_3_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1704:1: ( ( rule__Atomic__ValueAssignment_3_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1704:1: ( ( rule__Atomic__ValueAssignment_3_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1705:1: ( rule__Atomic__ValueAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getValueAssignment_3_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1706:1: ( rule__Atomic__ValueAssignment_3_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1706:2: rule__Atomic__ValueAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Atomic__ValueAssignment_3_1_in_rule__Atomic__Group_3__1__Impl3386);
            rule__Atomic__ValueAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getValueAssignment_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_3__1__Impl"


    // $ANTLR start "rule__Atomic__Group_4__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1720:1: rule__Atomic__Group_4__0 : rule__Atomic__Group_4__0__Impl rule__Atomic__Group_4__1 ;
    public final void rule__Atomic__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1724:1: ( rule__Atomic__Group_4__0__Impl rule__Atomic__Group_4__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1725:2: rule__Atomic__Group_4__0__Impl rule__Atomic__Group_4__1
            {
            pushFollow(FOLLOW_rule__Atomic__Group_4__0__Impl_in_rule__Atomic__Group_4__03420);
            rule__Atomic__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Atomic__Group_4__1_in_rule__Atomic__Group_4__03423);
            rule__Atomic__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_4__0"


    // $ANTLR start "rule__Atomic__Group_4__0__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1732:1: rule__Atomic__Group_4__0__Impl : ( () ) ;
    public final void rule__Atomic__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1736:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1737:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1737:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1738:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getStringLiteralAction_4_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1739:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1741:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getStringLiteralAction_4_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_4__0__Impl"


    // $ANTLR start "rule__Atomic__Group_4__1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1751:1: rule__Atomic__Group_4__1 : rule__Atomic__Group_4__1__Impl ;
    public final void rule__Atomic__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1755:1: ( rule__Atomic__Group_4__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1756:2: rule__Atomic__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Atomic__Group_4__1__Impl_in_rule__Atomic__Group_4__13481);
            rule__Atomic__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_4__1"


    // $ANTLR start "rule__Atomic__Group_4__1__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1762:1: rule__Atomic__Group_4__1__Impl : ( ( rule__Atomic__ValueAssignment_4_1 ) ) ;
    public final void rule__Atomic__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1766:1: ( ( ( rule__Atomic__ValueAssignment_4_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1767:1: ( ( rule__Atomic__ValueAssignment_4_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1767:1: ( ( rule__Atomic__ValueAssignment_4_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1768:1: ( rule__Atomic__ValueAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getValueAssignment_4_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1769:1: ( rule__Atomic__ValueAssignment_4_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1769:2: rule__Atomic__ValueAssignment_4_1
            {
            pushFollow(FOLLOW_rule__Atomic__ValueAssignment_4_1_in_rule__Atomic__Group_4__1__Impl3508);
            rule__Atomic__ValueAssignment_4_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getValueAssignment_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_4__1__Impl"


    // $ANTLR start "rule__Atomic__Group_5__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1783:1: rule__Atomic__Group_5__0 : rule__Atomic__Group_5__0__Impl rule__Atomic__Group_5__1 ;
    public final void rule__Atomic__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1787:1: ( rule__Atomic__Group_5__0__Impl rule__Atomic__Group_5__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1788:2: rule__Atomic__Group_5__0__Impl rule__Atomic__Group_5__1
            {
            pushFollow(FOLLOW_rule__Atomic__Group_5__0__Impl_in_rule__Atomic__Group_5__03542);
            rule__Atomic__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Atomic__Group_5__1_in_rule__Atomic__Group_5__03545);
            rule__Atomic__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_5__0"


    // $ANTLR start "rule__Atomic__Group_5__0__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1795:1: rule__Atomic__Group_5__0__Impl : ( () ) ;
    public final void rule__Atomic__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1799:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1800:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1800:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1801:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getBooleanLiteralAction_5_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1802:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1804:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getBooleanLiteralAction_5_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_5__0__Impl"


    // $ANTLR start "rule__Atomic__Group_5__1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1814:1: rule__Atomic__Group_5__1 : rule__Atomic__Group_5__1__Impl ;
    public final void rule__Atomic__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1818:1: ( rule__Atomic__Group_5__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1819:2: rule__Atomic__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__Atomic__Group_5__1__Impl_in_rule__Atomic__Group_5__13603);
            rule__Atomic__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_5__1"


    // $ANTLR start "rule__Atomic__Group_5__1__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1825:1: rule__Atomic__Group_5__1__Impl : ( ( rule__Atomic__ValueAssignment_5_1 ) ) ;
    public final void rule__Atomic__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1829:1: ( ( ( rule__Atomic__ValueAssignment_5_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1830:1: ( ( rule__Atomic__ValueAssignment_5_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1830:1: ( ( rule__Atomic__ValueAssignment_5_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1831:1: ( rule__Atomic__ValueAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getValueAssignment_5_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1832:1: ( rule__Atomic__ValueAssignment_5_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1832:2: rule__Atomic__ValueAssignment_5_1
            {
            pushFollow(FOLLOW_rule__Atomic__ValueAssignment_5_1_in_rule__Atomic__Group_5__1__Impl3630);
            rule__Atomic__ValueAssignment_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getValueAssignment_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_5__1__Impl"


    // $ANTLR start "rule__Atomic__Group_6__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1846:1: rule__Atomic__Group_6__0 : rule__Atomic__Group_6__0__Impl rule__Atomic__Group_6__1 ;
    public final void rule__Atomic__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1850:1: ( rule__Atomic__Group_6__0__Impl rule__Atomic__Group_6__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1851:2: rule__Atomic__Group_6__0__Impl rule__Atomic__Group_6__1
            {
            pushFollow(FOLLOW_rule__Atomic__Group_6__0__Impl_in_rule__Atomic__Group_6__03664);
            rule__Atomic__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Atomic__Group_6__1_in_rule__Atomic__Group_6__03667);
            rule__Atomic__Group_6__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_6__0"


    // $ANTLR start "rule__Atomic__Group_6__0__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1858:1: rule__Atomic__Group_6__0__Impl : ( () ) ;
    public final void rule__Atomic__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1862:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1863:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1863:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1864:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getVariableReferenceAction_6_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1865:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1867:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getVariableReferenceAction_6_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_6__0__Impl"


    // $ANTLR start "rule__Atomic__Group_6__1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1877:1: rule__Atomic__Group_6__1 : rule__Atomic__Group_6__1__Impl ;
    public final void rule__Atomic__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1881:1: ( rule__Atomic__Group_6__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1882:2: rule__Atomic__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__Atomic__Group_6__1__Impl_in_rule__Atomic__Group_6__13725);
            rule__Atomic__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_6__1"


    // $ANTLR start "rule__Atomic__Group_6__1__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1888:1: rule__Atomic__Group_6__1__Impl : ( ( rule__Atomic__RefAssignment_6_1 ) ) ;
    public final void rule__Atomic__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1892:1: ( ( ( rule__Atomic__RefAssignment_6_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1893:1: ( ( rule__Atomic__RefAssignment_6_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1893:1: ( ( rule__Atomic__RefAssignment_6_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1894:1: ( rule__Atomic__RefAssignment_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getRefAssignment_6_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1895:1: ( rule__Atomic__RefAssignment_6_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1895:2: rule__Atomic__RefAssignment_6_1
            {
            pushFollow(FOLLOW_rule__Atomic__RefAssignment_6_1_in_rule__Atomic__Group_6__1__Impl3752);
            rule__Atomic__RefAssignment_6_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getRefAssignment_6_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__Group_6__1__Impl"


    // $ANTLR start "rule__Model__VariablesAssignment"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1913:1: rule__Model__VariablesAssignment : ( ruleVariable ) ;
    public final void rule__Model__VariablesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1917:1: ( ( ruleVariable ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1918:1: ( ruleVariable )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1918:1: ( ruleVariable )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1919:1: ruleVariable
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getVariablesVariableParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleVariable_in_rule__Model__VariablesAssignment3794);
            ruleVariable();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getVariablesVariableParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__VariablesAssignment"


    // $ANTLR start "rule__Variable__NameAssignment_0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1928:1: rule__Variable__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Variable__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1932:1: ( ( RULE_ID ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1933:1: ( RULE_ID )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1933:1: ( RULE_ID )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1934:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Variable__NameAssignment_03825); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__NameAssignment_0"


    // $ANTLR start "rule__Variable__ExpressionAssignment_2"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1943:1: rule__Variable__ExpressionAssignment_2 : ( ruleExpression ) ;
    public final void rule__Variable__ExpressionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1947:1: ( ( ruleExpression ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1948:1: ( ruleExpression )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1948:1: ( ruleExpression )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1949:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableAccess().getExpressionExpressionParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_rule__Variable__ExpressionAssignment_23856);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableAccess().getExpressionExpressionParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__ExpressionAssignment_2"


    // $ANTLR start "rule__Addition__RightAssignment_1_1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1958:1: rule__Addition__RightAssignment_1_1 : ( ruleMultiplication ) ;
    public final void rule__Addition__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1962:1: ( ( ruleMultiplication ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1963:1: ( ruleMultiplication )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1963:1: ( ruleMultiplication )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1964:1: ruleMultiplication
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleMultiplication_in_rule__Addition__RightAssignment_1_13887);
            ruleMultiplication();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__RightAssignment_1_1"


    // $ANTLR start "rule__Multiplication__OpAssignment_1_0_1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1973:1: rule__Multiplication__OpAssignment_1_0_1 : ( ( rule__Multiplication__OpAlternatives_1_0_1_0 ) ) ;
    public final void rule__Multiplication__OpAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1977:1: ( ( ( rule__Multiplication__OpAlternatives_1_0_1_0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1978:1: ( ( rule__Multiplication__OpAlternatives_1_0_1_0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1978:1: ( ( rule__Multiplication__OpAlternatives_1_0_1_0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1979:1: ( rule__Multiplication__OpAlternatives_1_0_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getOpAlternatives_1_0_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1980:1: ( rule__Multiplication__OpAlternatives_1_0_1_0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1980:2: rule__Multiplication__OpAlternatives_1_0_1_0
            {
            pushFollow(FOLLOW_rule__Multiplication__OpAlternatives_1_0_1_0_in_rule__Multiplication__OpAssignment_1_0_13918);
            rule__Multiplication__OpAlternatives_1_0_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicationAccess().getOpAlternatives_1_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__OpAssignment_1_0_1"


    // $ANTLR start "rule__Multiplication__RightAssignment_1_1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1989:1: rule__Multiplication__RightAssignment_1_1 : ( ruleComparison ) ;
    public final void rule__Multiplication__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1993:1: ( ( ruleComparison ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1994:1: ( ruleComparison )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1994:1: ( ruleComparison )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1995:1: ruleComparison
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getRightComparisonParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleComparison_in_rule__Multiplication__RightAssignment_1_13951);
            ruleComparison();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicationAccess().getRightComparisonParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__RightAssignment_1_1"


    // $ANTLR start "rule__Comparison__OpAssignment_1_0_1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2004:1: rule__Comparison__OpAssignment_1_0_1 : ( ( rule__Comparison__OpAlternatives_1_0_1_0 ) ) ;
    public final void rule__Comparison__OpAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2008:1: ( ( ( rule__Comparison__OpAlternatives_1_0_1_0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2009:1: ( ( rule__Comparison__OpAlternatives_1_0_1_0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2009:1: ( ( rule__Comparison__OpAlternatives_1_0_1_0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2010:1: ( rule__Comparison__OpAlternatives_1_0_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getOpAlternatives_1_0_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2011:1: ( rule__Comparison__OpAlternatives_1_0_1_0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2011:2: rule__Comparison__OpAlternatives_1_0_1_0
            {
            pushFollow(FOLLOW_rule__Comparison__OpAlternatives_1_0_1_0_in_rule__Comparison__OpAssignment_1_0_13982);
            rule__Comparison__OpAlternatives_1_0_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getOpAlternatives_1_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__OpAssignment_1_0_1"


    // $ANTLR start "rule__Comparison__RightAssignment_1_1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2020:1: rule__Comparison__RightAssignment_1_1 : ( ruleBooleanExpression ) ;
    public final void rule__Comparison__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2024:1: ( ( ruleBooleanExpression ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2025:1: ( ruleBooleanExpression )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2025:1: ( ruleBooleanExpression )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2026:1: ruleBooleanExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getRightBooleanExpressionParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleBooleanExpression_in_rule__Comparison__RightAssignment_1_14015);
            ruleBooleanExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getRightBooleanExpressionParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__RightAssignment_1_1"


    // $ANTLR start "rule__BooleanExpression__OpAssignment_1_0_1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2035:1: rule__BooleanExpression__OpAssignment_1_0_1 : ( ( rule__BooleanExpression__OpAlternatives_1_0_1_0 ) ) ;
    public final void rule__BooleanExpression__OpAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2039:1: ( ( ( rule__BooleanExpression__OpAlternatives_1_0_1_0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2040:1: ( ( rule__BooleanExpression__OpAlternatives_1_0_1_0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2040:1: ( ( rule__BooleanExpression__OpAlternatives_1_0_1_0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2041:1: ( rule__BooleanExpression__OpAlternatives_1_0_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getOpAlternatives_1_0_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2042:1: ( rule__BooleanExpression__OpAlternatives_1_0_1_0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2042:2: rule__BooleanExpression__OpAlternatives_1_0_1_0
            {
            pushFollow(FOLLOW_rule__BooleanExpression__OpAlternatives_1_0_1_0_in_rule__BooleanExpression__OpAssignment_1_0_14046);
            rule__BooleanExpression__OpAlternatives_1_0_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanExpressionAccess().getOpAlternatives_1_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__OpAssignment_1_0_1"


    // $ANTLR start "rule__BooleanExpression__RightAssignment_1_1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2051:1: rule__BooleanExpression__RightAssignment_1_1 : ( ruleAtomic ) ;
    public final void rule__BooleanExpression__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2055:1: ( ( ruleAtomic ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2056:1: ( ruleAtomic )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2056:1: ( ruleAtomic )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2057:1: ruleAtomic
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getRightAtomicParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleAtomic_in_rule__BooleanExpression__RightAssignment_1_14079);
            ruleAtomic();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanExpressionAccess().getRightAtomicParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__RightAssignment_1_1"


    // $ANTLR start "rule__Atomic__ExpressionAssignment_1_2"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2066:1: rule__Atomic__ExpressionAssignment_1_2 : ( ruleAtomic ) ;
    public final void rule__Atomic__ExpressionAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2070:1: ( ( ruleAtomic ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2071:1: ( ruleAtomic )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2071:1: ( ruleAtomic )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2072:1: ruleAtomic
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getExpressionAtomicParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleAtomic_in_rule__Atomic__ExpressionAssignment_1_24110);
            ruleAtomic();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getExpressionAtomicParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__ExpressionAssignment_1_2"


    // $ANTLR start "rule__Atomic__ExpressionAssignment_2_2"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2081:1: rule__Atomic__ExpressionAssignment_2_2 : ( ruleAtomic ) ;
    public final void rule__Atomic__ExpressionAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2085:1: ( ( ruleAtomic ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2086:1: ( ruleAtomic )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2086:1: ( ruleAtomic )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2087:1: ruleAtomic
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getExpressionAtomicParserRuleCall_2_2_0()); 
            }
            pushFollow(FOLLOW_ruleAtomic_in_rule__Atomic__ExpressionAssignment_2_24141);
            ruleAtomic();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getExpressionAtomicParserRuleCall_2_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__ExpressionAssignment_2_2"


    // $ANTLR start "rule__Atomic__ValueAssignment_3_1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2096:1: rule__Atomic__ValueAssignment_3_1 : ( RULE_INT ) ;
    public final void rule__Atomic__ValueAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2100:1: ( ( RULE_INT ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2101:1: ( RULE_INT )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2101:1: ( RULE_INT )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2102:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getValueINTTerminalRuleCall_3_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Atomic__ValueAssignment_3_14172); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getValueINTTerminalRuleCall_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__ValueAssignment_3_1"


    // $ANTLR start "rule__Atomic__ValueAssignment_4_1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2111:1: rule__Atomic__ValueAssignment_4_1 : ( RULE_STRING ) ;
    public final void rule__Atomic__ValueAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2115:1: ( ( RULE_STRING ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2116:1: ( RULE_STRING )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2116:1: ( RULE_STRING )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2117:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getValueSTRINGTerminalRuleCall_4_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Atomic__ValueAssignment_4_14203); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getValueSTRINGTerminalRuleCall_4_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__ValueAssignment_4_1"


    // $ANTLR start "rule__Atomic__ValueAssignment_5_1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2126:1: rule__Atomic__ValueAssignment_5_1 : ( ( rule__Atomic__ValueAlternatives_5_1_0 ) ) ;
    public final void rule__Atomic__ValueAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2130:1: ( ( ( rule__Atomic__ValueAlternatives_5_1_0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2131:1: ( ( rule__Atomic__ValueAlternatives_5_1_0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2131:1: ( ( rule__Atomic__ValueAlternatives_5_1_0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2132:1: ( rule__Atomic__ValueAlternatives_5_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getValueAlternatives_5_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2133:1: ( rule__Atomic__ValueAlternatives_5_1_0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2133:2: rule__Atomic__ValueAlternatives_5_1_0
            {
            pushFollow(FOLLOW_rule__Atomic__ValueAlternatives_5_1_0_in_rule__Atomic__ValueAssignment_5_14234);
            rule__Atomic__ValueAlternatives_5_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getValueAlternatives_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__ValueAssignment_5_1"


    // $ANTLR start "rule__Atomic__RefAssignment_6_1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2142:1: rule__Atomic__RefAssignment_6_1 : ( ( RULE_ID ) ) ;
    public final void rule__Atomic__RefAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2146:1: ( ( ( RULE_ID ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2147:1: ( ( RULE_ID ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2147:1: ( ( RULE_ID ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2148:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getRefVariableCrossReference_6_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2149:1: ( RULE_ID )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2150:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getRefVariableIDTerminalRuleCall_6_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Atomic__RefAssignment_6_14271); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getRefVariableIDTerminalRuleCall_6_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getRefVariableCrossReference_6_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atomic__RefAssignment_6_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__VariablesAssignment_in_ruleModel100 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable128 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group__0_in_ruleVariable161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression188 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleExpression221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_entryRuleAddition247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddition254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group__0_in_ruleAddition280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_entryRuleMultiplication307 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group__0_in_ruleMultiplication340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparison_in_entryRuleComparison367 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComparison374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group__0_in_ruleComparison400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression427 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanExpression434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group__0_in_ruleBooleanExpression460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomic_in_entryRuleAtomic487 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtomic494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Alternatives_in_ruleAtomic520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_0__0_in_rule__Addition__Alternatives_1_0558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_1__0_in_rule__Addition__Alternatives_1_0576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Multiplication__OpAlternatives_1_0_1_0610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Multiplication__OpAlternatives_1_0_1_0630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Comparison__OpAlternatives_1_0_1_0665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Comparison__OpAlternatives_1_0_1_0685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__BooleanExpression__OpAlternatives_1_0_1_0720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__BooleanExpression__OpAlternatives_1_0_1_0740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_0__0_in_rule__Atomic__Alternatives774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_1__0_in_rule__Atomic__Alternatives792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_2__0_in_rule__Atomic__Alternatives810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_3__0_in_rule__Atomic__Alternatives828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_4__0_in_rule__Atomic__Alternatives846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_5__0_in_rule__Atomic__Alternatives864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_6__0_in_rule__Atomic__Alternatives882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Atomic__ValueAlternatives_5_1_0916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Atomic__ValueAlternatives_5_1_0936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group__0__Impl_in_rule__Variable__Group__0969 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Variable__Group__1_in_rule__Variable__Group__0972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__NameAssignment_0_in_rule__Variable__Group__0__Impl999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group__1__Impl_in_rule__Variable__Group__11029 = new BitSet(new long[]{0x0000000001660070L});
    public static final BitSet FOLLOW_rule__Variable__Group__2_in_rule__Variable__Group__11032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Variable__Group__1__Impl1060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group__2__Impl_in_rule__Variable__Group__21091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__ExpressionAssignment_2_in_rule__Variable__Group__2__Impl1118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group__0__Impl_in_rule__Addition__Group__01154 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_rule__Addition__Group__1_in_rule__Addition__Group__01157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_rule__Addition__Group__0__Impl1184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group__1__Impl_in_rule__Addition__Group__11213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1__0_in_rule__Addition__Group__1__Impl1240 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1__0__Impl_in_rule__Addition__Group_1__01275 = new BitSet(new long[]{0x0000000001660070L});
    public static final BitSet FOLLOW_rule__Addition__Group_1__1_in_rule__Addition__Group_1__01278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Alternatives_1_0_in_rule__Addition__Group_1__0__Impl1305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1__1__Impl_in_rule__Addition__Group_1__11335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__RightAssignment_1_1_in_rule__Addition__Group_1__1__Impl1362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_0__0__Impl_in_rule__Addition__Group_1_0_0__01396 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_0__1_in_rule__Addition__Group_1_0_0__01399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_0__1__Impl_in_rule__Addition__Group_1_0_0__11457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Addition__Group_1_0_0__1__Impl1485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_1__0__Impl_in_rule__Addition__Group_1_0_1__01520 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_1__1_in_rule__Addition__Group_1_0_1__01523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_1__1__Impl_in_rule__Addition__Group_1_0_1__11581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Addition__Group_1_0_1__1__Impl1609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group__0__Impl_in_rule__Multiplication__Group__01644 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_rule__Multiplication__Group__1_in_rule__Multiplication__Group__01647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparison_in_rule__Multiplication__Group__0__Impl1674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group__1__Impl_in_rule__Multiplication__Group__11703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1__0_in_rule__Multiplication__Group__1__Impl1730 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1__0__Impl_in_rule__Multiplication__Group_1__01765 = new BitSet(new long[]{0x0000000001660070L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1__1_in_rule__Multiplication__Group_1__01768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0__0_in_rule__Multiplication__Group_1__0__Impl1795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1__1__Impl_in_rule__Multiplication__Group_1__11825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__RightAssignment_1_1_in_rule__Multiplication__Group_1__1__Impl1852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0__0__Impl_in_rule__Multiplication__Group_1_0__01886 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0__1_in_rule__Multiplication__Group_1_0__01889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0__1__Impl_in_rule__Multiplication__Group_1_0__11947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__OpAssignment_1_0_1_in_rule__Multiplication__Group_1_0__1__Impl1974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group__0__Impl_in_rule__Comparison__Group__02008 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_rule__Comparison__Group__1_in_rule__Comparison__Group__02011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanExpression_in_rule__Comparison__Group__0__Impl2038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group__1__Impl_in_rule__Comparison__Group__12067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1__0_in_rule__Comparison__Group__1__Impl2094 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1__0__Impl_in_rule__Comparison__Group_1__02129 = new BitSet(new long[]{0x0000000001660070L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1__1_in_rule__Comparison__Group_1__02132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0__0_in_rule__Comparison__Group_1__0__Impl2159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1__1__Impl_in_rule__Comparison__Group_1__12189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__RightAssignment_1_1_in_rule__Comparison__Group_1__1__Impl2216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0__0__Impl_in_rule__Comparison__Group_1_0__02250 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0__1_in_rule__Comparison__Group_1_0__02253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0__1__Impl_in_rule__Comparison__Group_1_0__12311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__OpAssignment_1_0_1_in_rule__Comparison__Group_1_0__1__Impl2338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group__0__Impl_in_rule__BooleanExpression__Group__02372 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group__1_in_rule__BooleanExpression__Group__02375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomic_in_rule__BooleanExpression__Group__0__Impl2402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group__1__Impl_in_rule__BooleanExpression__Group__12431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group_1__0_in_rule__BooleanExpression__Group__1__Impl2458 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group_1__0__Impl_in_rule__BooleanExpression__Group_1__02493 = new BitSet(new long[]{0x0000000001660070L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group_1__1_in_rule__BooleanExpression__Group_1__02496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group_1_0__0_in_rule__BooleanExpression__Group_1__0__Impl2523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group_1__1__Impl_in_rule__BooleanExpression__Group_1__12553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__RightAssignment_1_1_in_rule__BooleanExpression__Group_1__1__Impl2580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group_1_0__0__Impl_in_rule__BooleanExpression__Group_1_0__02614 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group_1_0__1_in_rule__BooleanExpression__Group_1_0__02617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group_1_0__1__Impl_in_rule__BooleanExpression__Group_1_0__12675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__OpAssignment_1_0_1_in_rule__BooleanExpression__Group_1_0__1__Impl2702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_0__0__Impl_in_rule__Atomic__Group_0__02736 = new BitSet(new long[]{0x0000000001660070L});
    public static final BitSet FOLLOW_rule__Atomic__Group_0__1_in_rule__Atomic__Group_0__02739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Atomic__Group_0__0__Impl2767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_0__1__Impl_in_rule__Atomic__Group_0__12798 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__Atomic__Group_0__2_in_rule__Atomic__Group_0__12801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__Atomic__Group_0__1__Impl2828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_0__2__Impl_in_rule__Atomic__Group_0__22857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Atomic__Group_0__2__Impl2885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_1__0__Impl_in_rule__Atomic__Group_1__02922 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__Atomic__Group_1__1_in_rule__Atomic__Group_1__02925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_1__1__Impl_in_rule__Atomic__Group_1__12983 = new BitSet(new long[]{0x0000000001660070L});
    public static final BitSet FOLLOW_rule__Atomic__Group_1__2_in_rule__Atomic__Group_1__12986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Atomic__Group_1__1__Impl3015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_1__2__Impl_in_rule__Atomic__Group_1__23047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__ExpressionAssignment_1_2_in_rule__Atomic__Group_1__2__Impl3074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_2__0__Impl_in_rule__Atomic__Group_2__03110 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__Atomic__Group_2__1_in_rule__Atomic__Group_2__03113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_2__1__Impl_in_rule__Atomic__Group_2__13171 = new BitSet(new long[]{0x0000000001660070L});
    public static final BitSet FOLLOW_rule__Atomic__Group_2__2_in_rule__Atomic__Group_2__13174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Atomic__Group_2__1__Impl3203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_2__2__Impl_in_rule__Atomic__Group_2__23235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__ExpressionAssignment_2_2_in_rule__Atomic__Group_2__2__Impl3262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_3__0__Impl_in_rule__Atomic__Group_3__03298 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Atomic__Group_3__1_in_rule__Atomic__Group_3__03301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_3__1__Impl_in_rule__Atomic__Group_3__13359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__ValueAssignment_3_1_in_rule__Atomic__Group_3__1__Impl3386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_4__0__Impl_in_rule__Atomic__Group_4__03420 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Atomic__Group_4__1_in_rule__Atomic__Group_4__03423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_4__1__Impl_in_rule__Atomic__Group_4__13481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__ValueAssignment_4_1_in_rule__Atomic__Group_4__1__Impl3508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_5__0__Impl_in_rule__Atomic__Group_5__03542 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__Atomic__Group_5__1_in_rule__Atomic__Group_5__03545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_5__1__Impl_in_rule__Atomic__Group_5__13603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__ValueAssignment_5_1_in_rule__Atomic__Group_5__1__Impl3630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_6__0__Impl_in_rule__Atomic__Group_6__03664 = new BitSet(new long[]{0x0000000001660070L});
    public static final BitSet FOLLOW_rule__Atomic__Group_6__1_in_rule__Atomic__Group_6__03667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_6__1__Impl_in_rule__Atomic__Group_6__13725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__RefAssignment_6_1_in_rule__Atomic__Group_6__1__Impl3752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__Model__VariablesAssignment3794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Variable__NameAssignment_03825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__Variable__ExpressionAssignment_23856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_rule__Addition__RightAssignment_1_13887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__OpAlternatives_1_0_1_0_in_rule__Multiplication__OpAssignment_1_0_13918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparison_in_rule__Multiplication__RightAssignment_1_13951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__OpAlternatives_1_0_1_0_in_rule__Comparison__OpAssignment_1_0_13982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanExpression_in_rule__Comparison__RightAssignment_1_14015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__OpAlternatives_1_0_1_0_in_rule__BooleanExpression__OpAssignment_1_0_14046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomic_in_rule__BooleanExpression__RightAssignment_1_14079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomic_in_rule__Atomic__ExpressionAssignment_1_24110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomic_in_rule__Atomic__ExpressionAssignment_2_24141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Atomic__ValueAssignment_3_14172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Atomic__ValueAssignment_4_14203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__ValueAlternatives_5_1_0_in_rule__Atomic__ValueAssignment_5_14234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Atomic__RefAssignment_6_14271 = new BitSet(new long[]{0x0000000000000002L});

}