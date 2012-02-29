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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'||'", "'&&'", "'*'", "'/'", "'true'", "'false'", "'='", "'+'", "'-'", "'!'", "'('", "')'", "'<'", "'=='"
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:126:1: ruleExpression : ( ruleBooleanExpression ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:130:2: ( ( ruleBooleanExpression ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:131:1: ( ruleBooleanExpression )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:131:1: ( ruleBooleanExpression )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:132:1: ruleBooleanExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getBooleanExpressionParserRuleCall()); 
            }
            pushFollow(FOLLOW_ruleBooleanExpression_in_ruleExpression221);
            ruleBooleanExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getBooleanExpressionParserRuleCall()); 
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


    // $ANTLR start "entryRuleBooleanExpression"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:145:1: entryRuleBooleanExpression : ruleBooleanExpression EOF ;
    public final void entryRuleBooleanExpression() throws RecognitionException {
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:146:1: ( ruleBooleanExpression EOF )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:147:1: ruleBooleanExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression247);
            ruleBooleanExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanExpressionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanExpression254); if (state.failed) return ;

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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:154:1: ruleBooleanExpression : ( ( rule__BooleanExpression__Group__0 ) ) ;
    public final void ruleBooleanExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:158:2: ( ( ( rule__BooleanExpression__Group__0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:159:1: ( ( rule__BooleanExpression__Group__0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:159:1: ( ( rule__BooleanExpression__Group__0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:160:1: ( rule__BooleanExpression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getGroup()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:161:1: ( rule__BooleanExpression__Group__0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:161:2: rule__BooleanExpression__Group__0
            {
            pushFollow(FOLLOW_rule__BooleanExpression__Group__0_in_ruleBooleanExpression280);
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


    // $ANTLR start "entryRuleComparison"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:173:1: entryRuleComparison : ruleComparison EOF ;
    public final void entryRuleComparison() throws RecognitionException {
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:174:1: ( ruleComparison EOF )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:175:1: ruleComparison EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonRule()); 
            }
            pushFollow(FOLLOW_ruleComparison_in_entryRuleComparison307);
            ruleComparison();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleComparison314); if (state.failed) return ;

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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:182:1: ruleComparison : ( ( rule__Comparison__Group__0 ) ) ;
    public final void ruleComparison() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:186:2: ( ( ( rule__Comparison__Group__0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:187:1: ( ( rule__Comparison__Group__0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:187:1: ( ( rule__Comparison__Group__0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:188:1: ( rule__Comparison__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getGroup()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:189:1: ( rule__Comparison__Group__0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:189:2: rule__Comparison__Group__0
            {
            pushFollow(FOLLOW_rule__Comparison__Group__0_in_ruleComparison340);
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


    // $ANTLR start "entryRuleEquals"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:201:1: entryRuleEquals : ruleEquals EOF ;
    public final void entryRuleEquals() throws RecognitionException {
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:202:1: ( ruleEquals EOF )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:203:1: ruleEquals EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualsRule()); 
            }
            pushFollow(FOLLOW_ruleEquals_in_entryRuleEquals367);
            ruleEquals();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualsRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEquals374); if (state.failed) return ;

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
    // $ANTLR end "entryRuleEquals"


    // $ANTLR start "ruleEquals"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:210:1: ruleEquals : ( ( rule__Equals__Group__0 ) ) ;
    public final void ruleEquals() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:214:2: ( ( ( rule__Equals__Group__0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:215:1: ( ( rule__Equals__Group__0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:215:1: ( ( rule__Equals__Group__0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:216:1: ( rule__Equals__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualsAccess().getGroup()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:217:1: ( rule__Equals__Group__0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:217:2: rule__Equals__Group__0
            {
            pushFollow(FOLLOW_rule__Equals__Group__0_in_ruleEquals400);
            rule__Equals__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualsAccess().getGroup()); 
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
    // $ANTLR end "ruleEquals"


    // $ANTLR start "entryRuleAddition"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:229:1: entryRuleAddition : ruleAddition EOF ;
    public final void entryRuleAddition() throws RecognitionException {
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:230:1: ( ruleAddition EOF )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:231:1: ruleAddition EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionRule()); 
            }
            pushFollow(FOLLOW_ruleAddition_in_entryRuleAddition427);
            ruleAddition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddition434); if (state.failed) return ;

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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:238:1: ruleAddition : ( ( rule__Addition__Group__0 ) ) ;
    public final void ruleAddition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:242:2: ( ( ( rule__Addition__Group__0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:243:1: ( ( rule__Addition__Group__0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:243:1: ( ( rule__Addition__Group__0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:244:1: ( rule__Addition__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getGroup()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:245:1: ( rule__Addition__Group__0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:245:2: rule__Addition__Group__0
            {
            pushFollow(FOLLOW_rule__Addition__Group__0_in_ruleAddition460);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:257:1: entryRuleMultiplication : ruleMultiplication EOF ;
    public final void entryRuleMultiplication() throws RecognitionException {
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:258:1: ( ruleMultiplication EOF )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:259:1: ruleMultiplication EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplication_in_entryRuleMultiplication487);
            ruleMultiplication();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicationRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplication494); if (state.failed) return ;

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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:266:1: ruleMultiplication : ( ( rule__Multiplication__Group__0 ) ) ;
    public final void ruleMultiplication() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:270:2: ( ( ( rule__Multiplication__Group__0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:271:1: ( ( rule__Multiplication__Group__0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:271:1: ( ( rule__Multiplication__Group__0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:272:1: ( rule__Multiplication__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getGroup()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:273:1: ( rule__Multiplication__Group__0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:273:2: rule__Multiplication__Group__0
            {
            pushFollow(FOLLOW_rule__Multiplication__Group__0_in_ruleMultiplication520);
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


    // $ANTLR start "entryRulePrefixed"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:285:1: entryRulePrefixed : rulePrefixed EOF ;
    public final void entryRulePrefixed() throws RecognitionException {
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:286:1: ( rulePrefixed EOF )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:287:1: rulePrefixed EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedRule()); 
            }
            pushFollow(FOLLOW_rulePrefixed_in_entryRulePrefixed547);
            rulePrefixed();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixedRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrefixed554); if (state.failed) return ;

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
    // $ANTLR end "entryRulePrefixed"


    // $ANTLR start "rulePrefixed"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:294:1: rulePrefixed : ( ( rule__Prefixed__Alternatives ) ) ;
    public final void rulePrefixed() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:298:2: ( ( ( rule__Prefixed__Alternatives ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:299:1: ( ( rule__Prefixed__Alternatives ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:299:1: ( ( rule__Prefixed__Alternatives ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:300:1: ( rule__Prefixed__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getAlternatives()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:301:1: ( rule__Prefixed__Alternatives )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:301:2: rule__Prefixed__Alternatives
            {
            pushFollow(FOLLOW_rule__Prefixed__Alternatives_in_rulePrefixed580);
            rule__Prefixed__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixedAccess().getAlternatives()); 
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
    // $ANTLR end "rulePrefixed"


    // $ANTLR start "entryRuleAtomic"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:313:1: entryRuleAtomic : ruleAtomic EOF ;
    public final void entryRuleAtomic() throws RecognitionException {
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:314:1: ( ruleAtomic EOF )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:315:1: ruleAtomic EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicRule()); 
            }
            pushFollow(FOLLOW_ruleAtomic_in_entryRuleAtomic607);
            ruleAtomic();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtomic614); if (state.failed) return ;

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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:322:1: ruleAtomic : ( ( rule__Atomic__Alternatives ) ) ;
    public final void ruleAtomic() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:326:2: ( ( ( rule__Atomic__Alternatives ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:327:1: ( ( rule__Atomic__Alternatives ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:327:1: ( ( rule__Atomic__Alternatives ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:328:1: ( rule__Atomic__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getAlternatives()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:329:1: ( rule__Atomic__Alternatives )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:329:2: rule__Atomic__Alternatives
            {
            pushFollow(FOLLOW_rule__Atomic__Alternatives_in_ruleAtomic640);
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


    // $ANTLR start "rule__BooleanExpression__OpAlternatives_1_0_1_0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:343:1: rule__BooleanExpression__OpAlternatives_1_0_1_0 : ( ( '||' ) | ( '&&' ) );
    public final void rule__BooleanExpression__OpAlternatives_1_0_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:347:1: ( ( '||' ) | ( '&&' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
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
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:348:1: ( '||' )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:348:1: ( '||' )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:349:1: '||'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanExpressionAccess().getOpVerticalLineVerticalLineKeyword_1_0_1_0_0()); 
                    }
                    match(input,11,FOLLOW_11_in_rule__BooleanExpression__OpAlternatives_1_0_1_0679); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBooleanExpressionAccess().getOpVerticalLineVerticalLineKeyword_1_0_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:356:6: ( '&&' )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:356:6: ( '&&' )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:357:1: '&&'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanExpressionAccess().getOpAmpersandAmpersandKeyword_1_0_1_0_1()); 
                    }
                    match(input,12,FOLLOW_12_in_rule__BooleanExpression__OpAlternatives_1_0_1_0699); if (state.failed) return ;
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


    // $ANTLR start "rule__Addition__Alternatives_1_0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:369:1: rule__Addition__Alternatives_1_0 : ( ( ( rule__Addition__Group_1_0_0__0 ) ) | ( ( rule__Addition__Group_1_0_1__0 ) ) );
    public final void rule__Addition__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:373:1: ( ( ( rule__Addition__Group_1_0_0__0 ) ) | ( ( rule__Addition__Group_1_0_1__0 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==18) ) {
                alt3=1;
            }
            else if ( (LA3_0==19) ) {
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
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:374:1: ( ( rule__Addition__Group_1_0_0__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:374:1: ( ( rule__Addition__Group_1_0_0__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:375:1: ( rule__Addition__Group_1_0_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAdditionAccess().getGroup_1_0_0()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:376:1: ( rule__Addition__Group_1_0_0__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:376:2: rule__Addition__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_rule__Addition__Group_1_0_0__0_in_rule__Addition__Alternatives_1_0733);
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
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:380:6: ( ( rule__Addition__Group_1_0_1__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:380:6: ( ( rule__Addition__Group_1_0_1__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:381:1: ( rule__Addition__Group_1_0_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAdditionAccess().getGroup_1_0_1()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:382:1: ( rule__Addition__Group_1_0_1__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:382:2: rule__Addition__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Addition__Group_1_0_1__0_in_rule__Addition__Alternatives_1_0751);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:391:1: rule__Multiplication__OpAlternatives_1_0_1_0 : ( ( '*' ) | ( '/' ) );
    public final void rule__Multiplication__OpAlternatives_1_0_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:395:1: ( ( '*' ) | ( '/' ) )
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
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:396:1: ( '*' )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:396:1: ( '*' )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:397:1: '*'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicationAccess().getOpAsteriskKeyword_1_0_1_0_0()); 
                    }
                    match(input,13,FOLLOW_13_in_rule__Multiplication__OpAlternatives_1_0_1_0785); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicationAccess().getOpAsteriskKeyword_1_0_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:404:6: ( '/' )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:404:6: ( '/' )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:405:1: '/'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicationAccess().getOpSolidusKeyword_1_0_1_0_1()); 
                    }
                    match(input,14,FOLLOW_14_in_rule__Multiplication__OpAlternatives_1_0_1_0805); if (state.failed) return ;
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


    // $ANTLR start "rule__Prefixed__Alternatives"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:417:1: rule__Prefixed__Alternatives : ( ( ( rule__Prefixed__Group_0__0 ) ) | ( ( rule__Prefixed__Group_1__0 ) ) | ( ruleAtomic ) );
    public final void rule__Prefixed__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:421:1: ( ( ( rule__Prefixed__Group_0__0 ) ) | ( ( rule__Prefixed__Group_1__0 ) ) | ( ruleAtomic ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt5=1;
                }
                break;
            case 19:
                {
                alt5=2;
                }
                break;
            case RULE_ID:
            case RULE_INT:
            case RULE_STRING:
            case 15:
            case 16:
            case 21:
                {
                alt5=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:422:1: ( ( rule__Prefixed__Group_0__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:422:1: ( ( rule__Prefixed__Group_0__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:423:1: ( rule__Prefixed__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrefixedAccess().getGroup_0()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:424:1: ( rule__Prefixed__Group_0__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:424:2: rule__Prefixed__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Prefixed__Group_0__0_in_rule__Prefixed__Alternatives839);
                    rule__Prefixed__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrefixedAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:428:6: ( ( rule__Prefixed__Group_1__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:428:6: ( ( rule__Prefixed__Group_1__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:429:1: ( rule__Prefixed__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrefixedAccess().getGroup_1()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:430:1: ( rule__Prefixed__Group_1__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:430:2: rule__Prefixed__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Prefixed__Group_1__0_in_rule__Prefixed__Alternatives857);
                    rule__Prefixed__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrefixedAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:434:6: ( ruleAtomic )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:434:6: ( ruleAtomic )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:435:1: ruleAtomic
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrefixedAccess().getAtomicParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_ruleAtomic_in_rule__Prefixed__Alternatives875);
                    ruleAtomic();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrefixedAccess().getAtomicParserRuleCall_2()); 
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
    // $ANTLR end "rule__Prefixed__Alternatives"


    // $ANTLR start "rule__Atomic__Alternatives"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:445:1: rule__Atomic__Alternatives : ( ( ( rule__Atomic__Group_0__0 ) ) | ( ( rule__Atomic__Group_1__0 ) ) | ( ( rule__Atomic__Group_2__0 ) ) | ( ( rule__Atomic__Group_3__0 ) ) | ( ( rule__Atomic__Group_4__0 ) ) );
    public final void rule__Atomic__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:449:1: ( ( ( rule__Atomic__Group_0__0 ) ) | ( ( rule__Atomic__Group_1__0 ) ) | ( ( rule__Atomic__Group_2__0 ) ) | ( ( rule__Atomic__Group_3__0 ) ) | ( ( rule__Atomic__Group_4__0 ) ) )
            int alt6=5;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt6=1;
                }
                break;
            case RULE_INT:
                {
                alt6=2;
                }
                break;
            case RULE_STRING:
                {
                alt6=3;
                }
                break;
            case 15:
            case 16:
                {
                alt6=4;
                }
                break;
            case RULE_ID:
                {
                alt6=5;
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
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:450:1: ( ( rule__Atomic__Group_0__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:450:1: ( ( rule__Atomic__Group_0__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:451:1: ( rule__Atomic__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getGroup_0()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:452:1: ( rule__Atomic__Group_0__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:452:2: rule__Atomic__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Atomic__Group_0__0_in_rule__Atomic__Alternatives907);
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
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:456:6: ( ( rule__Atomic__Group_1__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:456:6: ( ( rule__Atomic__Group_1__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:457:1: ( rule__Atomic__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getGroup_1()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:458:1: ( rule__Atomic__Group_1__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:458:2: rule__Atomic__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Atomic__Group_1__0_in_rule__Atomic__Alternatives925);
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
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:462:6: ( ( rule__Atomic__Group_2__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:462:6: ( ( rule__Atomic__Group_2__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:463:1: ( rule__Atomic__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getGroup_2()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:464:1: ( rule__Atomic__Group_2__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:464:2: rule__Atomic__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Atomic__Group_2__0_in_rule__Atomic__Alternatives943);
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
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:468:6: ( ( rule__Atomic__Group_3__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:468:6: ( ( rule__Atomic__Group_3__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:469:1: ( rule__Atomic__Group_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getGroup_3()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:470:1: ( rule__Atomic__Group_3__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:470:2: rule__Atomic__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Atomic__Group_3__0_in_rule__Atomic__Alternatives961);
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
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:474:6: ( ( rule__Atomic__Group_4__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:474:6: ( ( rule__Atomic__Group_4__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:475:1: ( rule__Atomic__Group_4__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getGroup_4()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:476:1: ( rule__Atomic__Group_4__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:476:2: rule__Atomic__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Atomic__Group_4__0_in_rule__Atomic__Alternatives979);
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


    // $ANTLR start "rule__Atomic__ValueAlternatives_3_1_0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:485:1: rule__Atomic__ValueAlternatives_3_1_0 : ( ( 'true' ) | ( 'false' ) );
    public final void rule__Atomic__ValueAlternatives_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:489:1: ( ( 'true' ) | ( 'false' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                alt7=1;
            }
            else if ( (LA7_0==16) ) {
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
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:490:1: ( 'true' )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:490:1: ( 'true' )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:491:1: 'true'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getValueTrueKeyword_3_1_0_0()); 
                    }
                    match(input,15,FOLLOW_15_in_rule__Atomic__ValueAlternatives_3_1_01013); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomicAccess().getValueTrueKeyword_3_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:498:6: ( 'false' )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:498:6: ( 'false' )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:499:1: 'false'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getValueFalseKeyword_3_1_0_1()); 
                    }
                    match(input,16,FOLLOW_16_in_rule__Atomic__ValueAlternatives_3_1_01033); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomicAccess().getValueFalseKeyword_3_1_0_1()); 
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
    // $ANTLR end "rule__Atomic__ValueAlternatives_3_1_0"


    // $ANTLR start "rule__Variable__Group__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:514:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:518:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:519:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
            {
            pushFollow(FOLLOW_rule__Variable__Group__0__Impl_in_rule__Variable__Group__01066);
            rule__Variable__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Variable__Group__1_in_rule__Variable__Group__01069);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:526:1: rule__Variable__Group__0__Impl : ( ( rule__Variable__NameAssignment_0 ) ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:530:1: ( ( ( rule__Variable__NameAssignment_0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:531:1: ( ( rule__Variable__NameAssignment_0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:531:1: ( ( rule__Variable__NameAssignment_0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:532:1: ( rule__Variable__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableAccess().getNameAssignment_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:533:1: ( rule__Variable__NameAssignment_0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:533:2: rule__Variable__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Variable__NameAssignment_0_in_rule__Variable__Group__0__Impl1096);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:543:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl rule__Variable__Group__2 ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:547:1: ( rule__Variable__Group__1__Impl rule__Variable__Group__2 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:548:2: rule__Variable__Group__1__Impl rule__Variable__Group__2
            {
            pushFollow(FOLLOW_rule__Variable__Group__1__Impl_in_rule__Variable__Group__11126);
            rule__Variable__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Variable__Group__2_in_rule__Variable__Group__11129);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:555:1: rule__Variable__Group__1__Impl : ( '=' ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:559:1: ( ( '=' ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:560:1: ( '=' )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:560:1: ( '=' )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:561:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableAccess().getEqualsSignKeyword_1()); 
            }
            match(input,17,FOLLOW_17_in_rule__Variable__Group__1__Impl1157); if (state.failed) return ;
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:574:1: rule__Variable__Group__2 : rule__Variable__Group__2__Impl ;
    public final void rule__Variable__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:578:1: ( rule__Variable__Group__2__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:579:2: rule__Variable__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Variable__Group__2__Impl_in_rule__Variable__Group__21188);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:585:1: rule__Variable__Group__2__Impl : ( ( rule__Variable__ExpressionAssignment_2 ) ) ;
    public final void rule__Variable__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:589:1: ( ( ( rule__Variable__ExpressionAssignment_2 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:590:1: ( ( rule__Variable__ExpressionAssignment_2 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:590:1: ( ( rule__Variable__ExpressionAssignment_2 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:591:1: ( rule__Variable__ExpressionAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableAccess().getExpressionAssignment_2()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:592:1: ( rule__Variable__ExpressionAssignment_2 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:592:2: rule__Variable__ExpressionAssignment_2
            {
            pushFollow(FOLLOW_rule__Variable__ExpressionAssignment_2_in_rule__Variable__Group__2__Impl1215);
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


    // $ANTLR start "rule__BooleanExpression__Group__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:608:1: rule__BooleanExpression__Group__0 : rule__BooleanExpression__Group__0__Impl rule__BooleanExpression__Group__1 ;
    public final void rule__BooleanExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:612:1: ( rule__BooleanExpression__Group__0__Impl rule__BooleanExpression__Group__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:613:2: rule__BooleanExpression__Group__0__Impl rule__BooleanExpression__Group__1
            {
            pushFollow(FOLLOW_rule__BooleanExpression__Group__0__Impl_in_rule__BooleanExpression__Group__01251);
            rule__BooleanExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BooleanExpression__Group__1_in_rule__BooleanExpression__Group__01254);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:620:1: rule__BooleanExpression__Group__0__Impl : ( ruleComparison ) ;
    public final void rule__BooleanExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:624:1: ( ( ruleComparison ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:625:1: ( ruleComparison )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:625:1: ( ruleComparison )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:626:1: ruleComparison
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getComparisonParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleComparison_in_rule__BooleanExpression__Group__0__Impl1281);
            ruleComparison();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanExpressionAccess().getComparisonParserRuleCall_0()); 
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:637:1: rule__BooleanExpression__Group__1 : rule__BooleanExpression__Group__1__Impl ;
    public final void rule__BooleanExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:641:1: ( rule__BooleanExpression__Group__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:642:2: rule__BooleanExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__BooleanExpression__Group__1__Impl_in_rule__BooleanExpression__Group__11310);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:648:1: rule__BooleanExpression__Group__1__Impl : ( ( rule__BooleanExpression__Group_1__0 )* ) ;
    public final void rule__BooleanExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:652:1: ( ( ( rule__BooleanExpression__Group_1__0 )* ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:653:1: ( ( rule__BooleanExpression__Group_1__0 )* )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:653:1: ( ( rule__BooleanExpression__Group_1__0 )* )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:654:1: ( rule__BooleanExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getGroup_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:655:1: ( rule__BooleanExpression__Group_1__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=11 && LA8_0<=12)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:655:2: rule__BooleanExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__BooleanExpression__Group_1__0_in_rule__BooleanExpression__Group__1__Impl1337);
            	    rule__BooleanExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop8;
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:669:1: rule__BooleanExpression__Group_1__0 : rule__BooleanExpression__Group_1__0__Impl rule__BooleanExpression__Group_1__1 ;
    public final void rule__BooleanExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:673:1: ( rule__BooleanExpression__Group_1__0__Impl rule__BooleanExpression__Group_1__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:674:2: rule__BooleanExpression__Group_1__0__Impl rule__BooleanExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__BooleanExpression__Group_1__0__Impl_in_rule__BooleanExpression__Group_1__01372);
            rule__BooleanExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BooleanExpression__Group_1__1_in_rule__BooleanExpression__Group_1__01375);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:681:1: rule__BooleanExpression__Group_1__0__Impl : ( ( rule__BooleanExpression__Group_1_0__0 ) ) ;
    public final void rule__BooleanExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:685:1: ( ( ( rule__BooleanExpression__Group_1_0__0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:686:1: ( ( rule__BooleanExpression__Group_1_0__0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:686:1: ( ( rule__BooleanExpression__Group_1_0__0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:687:1: ( rule__BooleanExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getGroup_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:688:1: ( rule__BooleanExpression__Group_1_0__0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:688:2: rule__BooleanExpression__Group_1_0__0
            {
            pushFollow(FOLLOW_rule__BooleanExpression__Group_1_0__0_in_rule__BooleanExpression__Group_1__0__Impl1402);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:698:1: rule__BooleanExpression__Group_1__1 : rule__BooleanExpression__Group_1__1__Impl ;
    public final void rule__BooleanExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:702:1: ( rule__BooleanExpression__Group_1__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:703:2: rule__BooleanExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__BooleanExpression__Group_1__1__Impl_in_rule__BooleanExpression__Group_1__11432);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:709:1: rule__BooleanExpression__Group_1__1__Impl : ( ( rule__BooleanExpression__RightAssignment_1_1 ) ) ;
    public final void rule__BooleanExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:713:1: ( ( ( rule__BooleanExpression__RightAssignment_1_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:714:1: ( ( rule__BooleanExpression__RightAssignment_1_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:714:1: ( ( rule__BooleanExpression__RightAssignment_1_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:715:1: ( rule__BooleanExpression__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getRightAssignment_1_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:716:1: ( rule__BooleanExpression__RightAssignment_1_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:716:2: rule__BooleanExpression__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__BooleanExpression__RightAssignment_1_1_in_rule__BooleanExpression__Group_1__1__Impl1459);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:730:1: rule__BooleanExpression__Group_1_0__0 : rule__BooleanExpression__Group_1_0__0__Impl rule__BooleanExpression__Group_1_0__1 ;
    public final void rule__BooleanExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:734:1: ( rule__BooleanExpression__Group_1_0__0__Impl rule__BooleanExpression__Group_1_0__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:735:2: rule__BooleanExpression__Group_1_0__0__Impl rule__BooleanExpression__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__BooleanExpression__Group_1_0__0__Impl_in_rule__BooleanExpression__Group_1_0__01493);
            rule__BooleanExpression__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BooleanExpression__Group_1_0__1_in_rule__BooleanExpression__Group_1_0__01496);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:742:1: rule__BooleanExpression__Group_1_0__0__Impl : ( () ) ;
    public final void rule__BooleanExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:746:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:747:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:747:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:748:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getAndOrExpressionLeftAction_1_0_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:749:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:751:1: 
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:761:1: rule__BooleanExpression__Group_1_0__1 : rule__BooleanExpression__Group_1_0__1__Impl ;
    public final void rule__BooleanExpression__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:765:1: ( rule__BooleanExpression__Group_1_0__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:766:2: rule__BooleanExpression__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__BooleanExpression__Group_1_0__1__Impl_in_rule__BooleanExpression__Group_1_0__11554);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:772:1: rule__BooleanExpression__Group_1_0__1__Impl : ( ( rule__BooleanExpression__OpAssignment_1_0_1 ) ) ;
    public final void rule__BooleanExpression__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:776:1: ( ( ( rule__BooleanExpression__OpAssignment_1_0_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:777:1: ( ( rule__BooleanExpression__OpAssignment_1_0_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:777:1: ( ( rule__BooleanExpression__OpAssignment_1_0_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:778:1: ( rule__BooleanExpression__OpAssignment_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getOpAssignment_1_0_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:779:1: ( rule__BooleanExpression__OpAssignment_1_0_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:779:2: rule__BooleanExpression__OpAssignment_1_0_1
            {
            pushFollow(FOLLOW_rule__BooleanExpression__OpAssignment_1_0_1_in_rule__BooleanExpression__Group_1_0__1__Impl1581);
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


    // $ANTLR start "rule__Comparison__Group__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:793:1: rule__Comparison__Group__0 : rule__Comparison__Group__0__Impl rule__Comparison__Group__1 ;
    public final void rule__Comparison__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:797:1: ( rule__Comparison__Group__0__Impl rule__Comparison__Group__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:798:2: rule__Comparison__Group__0__Impl rule__Comparison__Group__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group__0__Impl_in_rule__Comparison__Group__01615);
            rule__Comparison__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Comparison__Group__1_in_rule__Comparison__Group__01618);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:805:1: rule__Comparison__Group__0__Impl : ( ruleEquals ) ;
    public final void rule__Comparison__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:809:1: ( ( ruleEquals ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:810:1: ( ruleEquals )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:810:1: ( ruleEquals )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:811:1: ruleEquals
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getEqualsParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleEquals_in_rule__Comparison__Group__0__Impl1645);
            ruleEquals();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getEqualsParserRuleCall_0()); 
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:822:1: rule__Comparison__Group__1 : rule__Comparison__Group__1__Impl ;
    public final void rule__Comparison__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:826:1: ( rule__Comparison__Group__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:827:2: rule__Comparison__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group__1__Impl_in_rule__Comparison__Group__11674);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:833:1: rule__Comparison__Group__1__Impl : ( ( rule__Comparison__Group_1__0 )* ) ;
    public final void rule__Comparison__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:837:1: ( ( ( rule__Comparison__Group_1__0 )* ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:838:1: ( ( rule__Comparison__Group_1__0 )* )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:838:1: ( ( rule__Comparison__Group_1__0 )* )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:839:1: ( rule__Comparison__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getGroup_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:840:1: ( rule__Comparison__Group_1__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==23) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:840:2: rule__Comparison__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Comparison__Group_1__0_in_rule__Comparison__Group__1__Impl1701);
            	    rule__Comparison__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop9;
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:854:1: rule__Comparison__Group_1__0 : rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1 ;
    public final void rule__Comparison__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:858:1: ( rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:859:2: rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1__0__Impl_in_rule__Comparison__Group_1__01736);
            rule__Comparison__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Comparison__Group_1__1_in_rule__Comparison__Group_1__01739);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:866:1: rule__Comparison__Group_1__0__Impl : ( ( rule__Comparison__Group_1_0__0 ) ) ;
    public final void rule__Comparison__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:870:1: ( ( ( rule__Comparison__Group_1_0__0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:871:1: ( ( rule__Comparison__Group_1_0__0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:871:1: ( ( rule__Comparison__Group_1_0__0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:872:1: ( rule__Comparison__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getGroup_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:873:1: ( rule__Comparison__Group_1_0__0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:873:2: rule__Comparison__Group_1_0__0
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0__0_in_rule__Comparison__Group_1__0__Impl1766);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:883:1: rule__Comparison__Group_1__1 : rule__Comparison__Group_1__1__Impl ;
    public final void rule__Comparison__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:887:1: ( rule__Comparison__Group_1__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:888:2: rule__Comparison__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1__1__Impl_in_rule__Comparison__Group_1__11796);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:894:1: rule__Comparison__Group_1__1__Impl : ( ( rule__Comparison__RightAssignment_1_1 ) ) ;
    public final void rule__Comparison__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:898:1: ( ( ( rule__Comparison__RightAssignment_1_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:899:1: ( ( rule__Comparison__RightAssignment_1_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:899:1: ( ( rule__Comparison__RightAssignment_1_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:900:1: ( rule__Comparison__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getRightAssignment_1_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:901:1: ( rule__Comparison__RightAssignment_1_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:901:2: rule__Comparison__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Comparison__RightAssignment_1_1_in_rule__Comparison__Group_1__1__Impl1823);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:915:1: rule__Comparison__Group_1_0__0 : rule__Comparison__Group_1_0__0__Impl rule__Comparison__Group_1_0__1 ;
    public final void rule__Comparison__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:919:1: ( rule__Comparison__Group_1_0__0__Impl rule__Comparison__Group_1_0__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:920:2: rule__Comparison__Group_1_0__0__Impl rule__Comparison__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0__0__Impl_in_rule__Comparison__Group_1_0__01857);
            rule__Comparison__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Comparison__Group_1_0__1_in_rule__Comparison__Group_1_0__01860);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:927:1: rule__Comparison__Group_1_0__0__Impl : ( () ) ;
    public final void rule__Comparison__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:931:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:932:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:932:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:933:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getComparisonLeftAction_1_0_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:934:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:936:1: 
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:946:1: rule__Comparison__Group_1_0__1 : rule__Comparison__Group_1_0__1__Impl ;
    public final void rule__Comparison__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:950:1: ( rule__Comparison__Group_1_0__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:951:2: rule__Comparison__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0__1__Impl_in_rule__Comparison__Group_1_0__11918);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:957:1: rule__Comparison__Group_1_0__1__Impl : ( ( rule__Comparison__OpAssignment_1_0_1 ) ) ;
    public final void rule__Comparison__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:961:1: ( ( ( rule__Comparison__OpAssignment_1_0_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:962:1: ( ( rule__Comparison__OpAssignment_1_0_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:962:1: ( ( rule__Comparison__OpAssignment_1_0_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:963:1: ( rule__Comparison__OpAssignment_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getOpAssignment_1_0_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:964:1: ( rule__Comparison__OpAssignment_1_0_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:964:2: rule__Comparison__OpAssignment_1_0_1
            {
            pushFollow(FOLLOW_rule__Comparison__OpAssignment_1_0_1_in_rule__Comparison__Group_1_0__1__Impl1945);
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


    // $ANTLR start "rule__Equals__Group__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:978:1: rule__Equals__Group__0 : rule__Equals__Group__0__Impl rule__Equals__Group__1 ;
    public final void rule__Equals__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:982:1: ( rule__Equals__Group__0__Impl rule__Equals__Group__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:983:2: rule__Equals__Group__0__Impl rule__Equals__Group__1
            {
            pushFollow(FOLLOW_rule__Equals__Group__0__Impl_in_rule__Equals__Group__01979);
            rule__Equals__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Equals__Group__1_in_rule__Equals__Group__01982);
            rule__Equals__Group__1();

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
    // $ANTLR end "rule__Equals__Group__0"


    // $ANTLR start "rule__Equals__Group__0__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:990:1: rule__Equals__Group__0__Impl : ( ruleAddition ) ;
    public final void rule__Equals__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:994:1: ( ( ruleAddition ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:995:1: ( ruleAddition )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:995:1: ( ruleAddition )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:996:1: ruleAddition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualsAccess().getAdditionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleAddition_in_rule__Equals__Group__0__Impl2009);
            ruleAddition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualsAccess().getAdditionParserRuleCall_0()); 
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
    // $ANTLR end "rule__Equals__Group__0__Impl"


    // $ANTLR start "rule__Equals__Group__1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1007:1: rule__Equals__Group__1 : rule__Equals__Group__1__Impl ;
    public final void rule__Equals__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1011:1: ( rule__Equals__Group__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1012:2: rule__Equals__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Equals__Group__1__Impl_in_rule__Equals__Group__12038);
            rule__Equals__Group__1__Impl();

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
    // $ANTLR end "rule__Equals__Group__1"


    // $ANTLR start "rule__Equals__Group__1__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1018:1: rule__Equals__Group__1__Impl : ( ( rule__Equals__Group_1__0 )* ) ;
    public final void rule__Equals__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1022:1: ( ( ( rule__Equals__Group_1__0 )* ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1023:1: ( ( rule__Equals__Group_1__0 )* )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1023:1: ( ( rule__Equals__Group_1__0 )* )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1024:1: ( rule__Equals__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualsAccess().getGroup_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1025:1: ( rule__Equals__Group_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==24) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1025:2: rule__Equals__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Equals__Group_1__0_in_rule__Equals__Group__1__Impl2065);
            	    rule__Equals__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualsAccess().getGroup_1()); 
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
    // $ANTLR end "rule__Equals__Group__1__Impl"


    // $ANTLR start "rule__Equals__Group_1__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1039:1: rule__Equals__Group_1__0 : rule__Equals__Group_1__0__Impl rule__Equals__Group_1__1 ;
    public final void rule__Equals__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1043:1: ( rule__Equals__Group_1__0__Impl rule__Equals__Group_1__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1044:2: rule__Equals__Group_1__0__Impl rule__Equals__Group_1__1
            {
            pushFollow(FOLLOW_rule__Equals__Group_1__0__Impl_in_rule__Equals__Group_1__02100);
            rule__Equals__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Equals__Group_1__1_in_rule__Equals__Group_1__02103);
            rule__Equals__Group_1__1();

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
    // $ANTLR end "rule__Equals__Group_1__0"


    // $ANTLR start "rule__Equals__Group_1__0__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1051:1: rule__Equals__Group_1__0__Impl : ( ( rule__Equals__Group_1_0__0 ) ) ;
    public final void rule__Equals__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1055:1: ( ( ( rule__Equals__Group_1_0__0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1056:1: ( ( rule__Equals__Group_1_0__0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1056:1: ( ( rule__Equals__Group_1_0__0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1057:1: ( rule__Equals__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualsAccess().getGroup_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1058:1: ( rule__Equals__Group_1_0__0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1058:2: rule__Equals__Group_1_0__0
            {
            pushFollow(FOLLOW_rule__Equals__Group_1_0__0_in_rule__Equals__Group_1__0__Impl2130);
            rule__Equals__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualsAccess().getGroup_1_0()); 
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
    // $ANTLR end "rule__Equals__Group_1__0__Impl"


    // $ANTLR start "rule__Equals__Group_1__1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1068:1: rule__Equals__Group_1__1 : rule__Equals__Group_1__1__Impl ;
    public final void rule__Equals__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1072:1: ( rule__Equals__Group_1__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1073:2: rule__Equals__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Equals__Group_1__1__Impl_in_rule__Equals__Group_1__12160);
            rule__Equals__Group_1__1__Impl();

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
    // $ANTLR end "rule__Equals__Group_1__1"


    // $ANTLR start "rule__Equals__Group_1__1__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1079:1: rule__Equals__Group_1__1__Impl : ( ( rule__Equals__RightAssignment_1_1 ) ) ;
    public final void rule__Equals__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1083:1: ( ( ( rule__Equals__RightAssignment_1_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1084:1: ( ( rule__Equals__RightAssignment_1_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1084:1: ( ( rule__Equals__RightAssignment_1_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1085:1: ( rule__Equals__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualsAccess().getRightAssignment_1_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1086:1: ( rule__Equals__RightAssignment_1_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1086:2: rule__Equals__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Equals__RightAssignment_1_1_in_rule__Equals__Group_1__1__Impl2187);
            rule__Equals__RightAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualsAccess().getRightAssignment_1_1()); 
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
    // $ANTLR end "rule__Equals__Group_1__1__Impl"


    // $ANTLR start "rule__Equals__Group_1_0__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1100:1: rule__Equals__Group_1_0__0 : rule__Equals__Group_1_0__0__Impl rule__Equals__Group_1_0__1 ;
    public final void rule__Equals__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1104:1: ( rule__Equals__Group_1_0__0__Impl rule__Equals__Group_1_0__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1105:2: rule__Equals__Group_1_0__0__Impl rule__Equals__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__Equals__Group_1_0__0__Impl_in_rule__Equals__Group_1_0__02221);
            rule__Equals__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Equals__Group_1_0__1_in_rule__Equals__Group_1_0__02224);
            rule__Equals__Group_1_0__1();

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
    // $ANTLR end "rule__Equals__Group_1_0__0"


    // $ANTLR start "rule__Equals__Group_1_0__0__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1112:1: rule__Equals__Group_1_0__0__Impl : ( () ) ;
    public final void rule__Equals__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1116:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1117:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1117:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1118:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualsAccess().getEqualsLeftAction_1_0_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1119:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1121:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualsAccess().getEqualsLeftAction_1_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equals__Group_1_0__0__Impl"


    // $ANTLR start "rule__Equals__Group_1_0__1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1131:1: rule__Equals__Group_1_0__1 : rule__Equals__Group_1_0__1__Impl ;
    public final void rule__Equals__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1135:1: ( rule__Equals__Group_1_0__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1136:2: rule__Equals__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Equals__Group_1_0__1__Impl_in_rule__Equals__Group_1_0__12282);
            rule__Equals__Group_1_0__1__Impl();

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
    // $ANTLR end "rule__Equals__Group_1_0__1"


    // $ANTLR start "rule__Equals__Group_1_0__1__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1142:1: rule__Equals__Group_1_0__1__Impl : ( ( rule__Equals__OpAssignment_1_0_1 ) ) ;
    public final void rule__Equals__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1146:1: ( ( ( rule__Equals__OpAssignment_1_0_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1147:1: ( ( rule__Equals__OpAssignment_1_0_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1147:1: ( ( rule__Equals__OpAssignment_1_0_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1148:1: ( rule__Equals__OpAssignment_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualsAccess().getOpAssignment_1_0_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1149:1: ( rule__Equals__OpAssignment_1_0_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1149:2: rule__Equals__OpAssignment_1_0_1
            {
            pushFollow(FOLLOW_rule__Equals__OpAssignment_1_0_1_in_rule__Equals__Group_1_0__1__Impl2309);
            rule__Equals__OpAssignment_1_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualsAccess().getOpAssignment_1_0_1()); 
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
    // $ANTLR end "rule__Equals__Group_1_0__1__Impl"


    // $ANTLR start "rule__Addition__Group__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1163:1: rule__Addition__Group__0 : rule__Addition__Group__0__Impl rule__Addition__Group__1 ;
    public final void rule__Addition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1167:1: ( rule__Addition__Group__0__Impl rule__Addition__Group__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1168:2: rule__Addition__Group__0__Impl rule__Addition__Group__1
            {
            pushFollow(FOLLOW_rule__Addition__Group__0__Impl_in_rule__Addition__Group__02343);
            rule__Addition__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Addition__Group__1_in_rule__Addition__Group__02346);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1175:1: rule__Addition__Group__0__Impl : ( ruleMultiplication ) ;
    public final void rule__Addition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1179:1: ( ( ruleMultiplication ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1180:1: ( ruleMultiplication )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1180:1: ( ruleMultiplication )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1181:1: ruleMultiplication
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleMultiplication_in_rule__Addition__Group__0__Impl2373);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1192:1: rule__Addition__Group__1 : rule__Addition__Group__1__Impl ;
    public final void rule__Addition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1196:1: ( rule__Addition__Group__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1197:2: rule__Addition__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Addition__Group__1__Impl_in_rule__Addition__Group__12402);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1203:1: rule__Addition__Group__1__Impl : ( ( rule__Addition__Group_1__0 )* ) ;
    public final void rule__Addition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1207:1: ( ( ( rule__Addition__Group_1__0 )* ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1208:1: ( ( rule__Addition__Group_1__0 )* )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1208:1: ( ( rule__Addition__Group_1__0 )* )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1209:1: ( rule__Addition__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getGroup_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1210:1: ( rule__Addition__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=18 && LA11_0<=19)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1210:2: rule__Addition__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Addition__Group_1__0_in_rule__Addition__Group__1__Impl2429);
            	    rule__Addition__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop11;
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1224:1: rule__Addition__Group_1__0 : rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1 ;
    public final void rule__Addition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1228:1: ( rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1229:2: rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1
            {
            pushFollow(FOLLOW_rule__Addition__Group_1__0__Impl_in_rule__Addition__Group_1__02464);
            rule__Addition__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Addition__Group_1__1_in_rule__Addition__Group_1__02467);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1236:1: rule__Addition__Group_1__0__Impl : ( ( rule__Addition__Alternatives_1_0 ) ) ;
    public final void rule__Addition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1240:1: ( ( ( rule__Addition__Alternatives_1_0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1241:1: ( ( rule__Addition__Alternatives_1_0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1241:1: ( ( rule__Addition__Alternatives_1_0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1242:1: ( rule__Addition__Alternatives_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getAlternatives_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1243:1: ( rule__Addition__Alternatives_1_0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1243:2: rule__Addition__Alternatives_1_0
            {
            pushFollow(FOLLOW_rule__Addition__Alternatives_1_0_in_rule__Addition__Group_1__0__Impl2494);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1253:1: rule__Addition__Group_1__1 : rule__Addition__Group_1__1__Impl ;
    public final void rule__Addition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1257:1: ( rule__Addition__Group_1__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1258:2: rule__Addition__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Addition__Group_1__1__Impl_in_rule__Addition__Group_1__12524);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1264:1: rule__Addition__Group_1__1__Impl : ( ( rule__Addition__RightAssignment_1_1 ) ) ;
    public final void rule__Addition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1268:1: ( ( ( rule__Addition__RightAssignment_1_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1269:1: ( ( rule__Addition__RightAssignment_1_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1269:1: ( ( rule__Addition__RightAssignment_1_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1270:1: ( rule__Addition__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getRightAssignment_1_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1271:1: ( rule__Addition__RightAssignment_1_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1271:2: rule__Addition__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Addition__RightAssignment_1_1_in_rule__Addition__Group_1__1__Impl2551);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1285:1: rule__Addition__Group_1_0_0__0 : rule__Addition__Group_1_0_0__0__Impl rule__Addition__Group_1_0_0__1 ;
    public final void rule__Addition__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1289:1: ( rule__Addition__Group_1_0_0__0__Impl rule__Addition__Group_1_0_0__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1290:2: rule__Addition__Group_1_0_0__0__Impl rule__Addition__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__Addition__Group_1_0_0__0__Impl_in_rule__Addition__Group_1_0_0__02585);
            rule__Addition__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Addition__Group_1_0_0__1_in_rule__Addition__Group_1_0_0__02588);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1297:1: rule__Addition__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Addition__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1301:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1302:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1302:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1303:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1304:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1306:1: 
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1316:1: rule__Addition__Group_1_0_0__1 : rule__Addition__Group_1_0_0__1__Impl ;
    public final void rule__Addition__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1320:1: ( rule__Addition__Group_1_0_0__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1321:2: rule__Addition__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Addition__Group_1_0_0__1__Impl_in_rule__Addition__Group_1_0_0__12646);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1327:1: rule__Addition__Group_1_0_0__1__Impl : ( '+' ) ;
    public final void rule__Addition__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1331:1: ( ( '+' ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1332:1: ( '+' )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1332:1: ( '+' )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1333:1: '+'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1()); 
            }
            match(input,18,FOLLOW_18_in_rule__Addition__Group_1_0_0__1__Impl2674); if (state.failed) return ;
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1350:1: rule__Addition__Group_1_0_1__0 : rule__Addition__Group_1_0_1__0__Impl rule__Addition__Group_1_0_1__1 ;
    public final void rule__Addition__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1354:1: ( rule__Addition__Group_1_0_1__0__Impl rule__Addition__Group_1_0_1__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1355:2: rule__Addition__Group_1_0_1__0__Impl rule__Addition__Group_1_0_1__1
            {
            pushFollow(FOLLOW_rule__Addition__Group_1_0_1__0__Impl_in_rule__Addition__Group_1_0_1__02709);
            rule__Addition__Group_1_0_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Addition__Group_1_0_1__1_in_rule__Addition__Group_1_0_1__02712);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1362:1: rule__Addition__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Addition__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1366:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1367:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1367:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1368:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1369:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1371:1: 
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1381:1: rule__Addition__Group_1_0_1__1 : rule__Addition__Group_1_0_1__1__Impl ;
    public final void rule__Addition__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1385:1: ( rule__Addition__Group_1_0_1__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1386:2: rule__Addition__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Addition__Group_1_0_1__1__Impl_in_rule__Addition__Group_1_0_1__12770);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1392:1: rule__Addition__Group_1_0_1__1__Impl : ( '-' ) ;
    public final void rule__Addition__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1396:1: ( ( '-' ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1397:1: ( '-' )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1397:1: ( '-' )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1398:1: '-'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1()); 
            }
            match(input,19,FOLLOW_19_in_rule__Addition__Group_1_0_1__1__Impl2798); if (state.failed) return ;
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1415:1: rule__Multiplication__Group__0 : rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1 ;
    public final void rule__Multiplication__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1419:1: ( rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1420:2: rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1
            {
            pushFollow(FOLLOW_rule__Multiplication__Group__0__Impl_in_rule__Multiplication__Group__02833);
            rule__Multiplication__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Multiplication__Group__1_in_rule__Multiplication__Group__02836);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1427:1: rule__Multiplication__Group__0__Impl : ( rulePrefixed ) ;
    public final void rule__Multiplication__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1431:1: ( ( rulePrefixed ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1432:1: ( rulePrefixed )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1432:1: ( rulePrefixed )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1433:1: rulePrefixed
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getPrefixedParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_rulePrefixed_in_rule__Multiplication__Group__0__Impl2863);
            rulePrefixed();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicationAccess().getPrefixedParserRuleCall_0()); 
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1444:1: rule__Multiplication__Group__1 : rule__Multiplication__Group__1__Impl ;
    public final void rule__Multiplication__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1448:1: ( rule__Multiplication__Group__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1449:2: rule__Multiplication__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Multiplication__Group__1__Impl_in_rule__Multiplication__Group__12892);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1455:1: rule__Multiplication__Group__1__Impl : ( ( rule__Multiplication__Group_1__0 )* ) ;
    public final void rule__Multiplication__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1459:1: ( ( ( rule__Multiplication__Group_1__0 )* ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1460:1: ( ( rule__Multiplication__Group_1__0 )* )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1460:1: ( ( rule__Multiplication__Group_1__0 )* )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1461:1: ( rule__Multiplication__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getGroup_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1462:1: ( rule__Multiplication__Group_1__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=13 && LA12_0<=14)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1462:2: rule__Multiplication__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Multiplication__Group_1__0_in_rule__Multiplication__Group__1__Impl2919);
            	    rule__Multiplication__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop12;
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1476:1: rule__Multiplication__Group_1__0 : rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1 ;
    public final void rule__Multiplication__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1480:1: ( rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1481:2: rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1__0__Impl_in_rule__Multiplication__Group_1__02954);
            rule__Multiplication__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Multiplication__Group_1__1_in_rule__Multiplication__Group_1__02957);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1488:1: rule__Multiplication__Group_1__0__Impl : ( ( rule__Multiplication__Group_1_0__0 ) ) ;
    public final void rule__Multiplication__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1492:1: ( ( ( rule__Multiplication__Group_1_0__0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1493:1: ( ( rule__Multiplication__Group_1_0__0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1493:1: ( ( rule__Multiplication__Group_1_0__0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1494:1: ( rule__Multiplication__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getGroup_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1495:1: ( rule__Multiplication__Group_1_0__0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1495:2: rule__Multiplication__Group_1_0__0
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0__0_in_rule__Multiplication__Group_1__0__Impl2984);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1505:1: rule__Multiplication__Group_1__1 : rule__Multiplication__Group_1__1__Impl ;
    public final void rule__Multiplication__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1509:1: ( rule__Multiplication__Group_1__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1510:2: rule__Multiplication__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1__1__Impl_in_rule__Multiplication__Group_1__13014);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1516:1: rule__Multiplication__Group_1__1__Impl : ( ( rule__Multiplication__RightAssignment_1_1 ) ) ;
    public final void rule__Multiplication__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1520:1: ( ( ( rule__Multiplication__RightAssignment_1_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1521:1: ( ( rule__Multiplication__RightAssignment_1_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1521:1: ( ( rule__Multiplication__RightAssignment_1_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1522:1: ( rule__Multiplication__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getRightAssignment_1_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1523:1: ( rule__Multiplication__RightAssignment_1_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1523:2: rule__Multiplication__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Multiplication__RightAssignment_1_1_in_rule__Multiplication__Group_1__1__Impl3041);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1537:1: rule__Multiplication__Group_1_0__0 : rule__Multiplication__Group_1_0__0__Impl rule__Multiplication__Group_1_0__1 ;
    public final void rule__Multiplication__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1541:1: ( rule__Multiplication__Group_1_0__0__Impl rule__Multiplication__Group_1_0__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1542:2: rule__Multiplication__Group_1_0__0__Impl rule__Multiplication__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0__0__Impl_in_rule__Multiplication__Group_1_0__03075);
            rule__Multiplication__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0__1_in_rule__Multiplication__Group_1_0__03078);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1549:1: rule__Multiplication__Group_1_0__0__Impl : ( () ) ;
    public final void rule__Multiplication__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1553:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1554:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1554:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1555:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getMultiOrDivLeftAction_1_0_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1556:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1558:1: 
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1568:1: rule__Multiplication__Group_1_0__1 : rule__Multiplication__Group_1_0__1__Impl ;
    public final void rule__Multiplication__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1572:1: ( rule__Multiplication__Group_1_0__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1573:2: rule__Multiplication__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0__1__Impl_in_rule__Multiplication__Group_1_0__13136);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1579:1: rule__Multiplication__Group_1_0__1__Impl : ( ( rule__Multiplication__OpAssignment_1_0_1 ) ) ;
    public final void rule__Multiplication__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1583:1: ( ( ( rule__Multiplication__OpAssignment_1_0_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1584:1: ( ( rule__Multiplication__OpAssignment_1_0_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1584:1: ( ( rule__Multiplication__OpAssignment_1_0_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1585:1: ( rule__Multiplication__OpAssignment_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getOpAssignment_1_0_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1586:1: ( rule__Multiplication__OpAssignment_1_0_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1586:2: rule__Multiplication__OpAssignment_1_0_1
            {
            pushFollow(FOLLOW_rule__Multiplication__OpAssignment_1_0_1_in_rule__Multiplication__Group_1_0__1__Impl3163);
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


    // $ANTLR start "rule__Prefixed__Group_0__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1600:1: rule__Prefixed__Group_0__0 : rule__Prefixed__Group_0__0__Impl rule__Prefixed__Group_0__1 ;
    public final void rule__Prefixed__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1604:1: ( rule__Prefixed__Group_0__0__Impl rule__Prefixed__Group_0__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1605:2: rule__Prefixed__Group_0__0__Impl rule__Prefixed__Group_0__1
            {
            pushFollow(FOLLOW_rule__Prefixed__Group_0__0__Impl_in_rule__Prefixed__Group_0__03197);
            rule__Prefixed__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Prefixed__Group_0__1_in_rule__Prefixed__Group_0__03200);
            rule__Prefixed__Group_0__1();

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
    // $ANTLR end "rule__Prefixed__Group_0__0"


    // $ANTLR start "rule__Prefixed__Group_0__0__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1612:1: rule__Prefixed__Group_0__0__Impl : ( () ) ;
    public final void rule__Prefixed__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1616:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1617:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1617:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1618:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getBooleanNegationAction_0_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1619:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1621:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixedAccess().getBooleanNegationAction_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Prefixed__Group_0__0__Impl"


    // $ANTLR start "rule__Prefixed__Group_0__1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1631:1: rule__Prefixed__Group_0__1 : rule__Prefixed__Group_0__1__Impl rule__Prefixed__Group_0__2 ;
    public final void rule__Prefixed__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1635:1: ( rule__Prefixed__Group_0__1__Impl rule__Prefixed__Group_0__2 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1636:2: rule__Prefixed__Group_0__1__Impl rule__Prefixed__Group_0__2
            {
            pushFollow(FOLLOW_rule__Prefixed__Group_0__1__Impl_in_rule__Prefixed__Group_0__13258);
            rule__Prefixed__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Prefixed__Group_0__2_in_rule__Prefixed__Group_0__13261);
            rule__Prefixed__Group_0__2();

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
    // $ANTLR end "rule__Prefixed__Group_0__1"


    // $ANTLR start "rule__Prefixed__Group_0__1__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1643:1: rule__Prefixed__Group_0__1__Impl : ( ( '!' ) ) ;
    public final void rule__Prefixed__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1647:1: ( ( ( '!' ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1648:1: ( ( '!' ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1648:1: ( ( '!' ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1649:1: ( '!' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getExclamationMarkKeyword_0_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1650:1: ( '!' )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1651:2: '!'
            {
            match(input,20,FOLLOW_20_in_rule__Prefixed__Group_0__1__Impl3290); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixedAccess().getExclamationMarkKeyword_0_1()); 
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
    // $ANTLR end "rule__Prefixed__Group_0__1__Impl"


    // $ANTLR start "rule__Prefixed__Group_0__2"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1662:1: rule__Prefixed__Group_0__2 : rule__Prefixed__Group_0__2__Impl ;
    public final void rule__Prefixed__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1666:1: ( rule__Prefixed__Group_0__2__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1667:2: rule__Prefixed__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__Prefixed__Group_0__2__Impl_in_rule__Prefixed__Group_0__23322);
            rule__Prefixed__Group_0__2__Impl();

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
    // $ANTLR end "rule__Prefixed__Group_0__2"


    // $ANTLR start "rule__Prefixed__Group_0__2__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1673:1: rule__Prefixed__Group_0__2__Impl : ( ( rule__Prefixed__ExpressionAssignment_0_2 ) ) ;
    public final void rule__Prefixed__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1677:1: ( ( ( rule__Prefixed__ExpressionAssignment_0_2 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1678:1: ( ( rule__Prefixed__ExpressionAssignment_0_2 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1678:1: ( ( rule__Prefixed__ExpressionAssignment_0_2 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1679:1: ( rule__Prefixed__ExpressionAssignment_0_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getExpressionAssignment_0_2()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1680:1: ( rule__Prefixed__ExpressionAssignment_0_2 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1680:2: rule__Prefixed__ExpressionAssignment_0_2
            {
            pushFollow(FOLLOW_rule__Prefixed__ExpressionAssignment_0_2_in_rule__Prefixed__Group_0__2__Impl3349);
            rule__Prefixed__ExpressionAssignment_0_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixedAccess().getExpressionAssignment_0_2()); 
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
    // $ANTLR end "rule__Prefixed__Group_0__2__Impl"


    // $ANTLR start "rule__Prefixed__Group_1__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1696:1: rule__Prefixed__Group_1__0 : rule__Prefixed__Group_1__0__Impl rule__Prefixed__Group_1__1 ;
    public final void rule__Prefixed__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1700:1: ( rule__Prefixed__Group_1__0__Impl rule__Prefixed__Group_1__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1701:2: rule__Prefixed__Group_1__0__Impl rule__Prefixed__Group_1__1
            {
            pushFollow(FOLLOW_rule__Prefixed__Group_1__0__Impl_in_rule__Prefixed__Group_1__03385);
            rule__Prefixed__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Prefixed__Group_1__1_in_rule__Prefixed__Group_1__03388);
            rule__Prefixed__Group_1__1();

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
    // $ANTLR end "rule__Prefixed__Group_1__0"


    // $ANTLR start "rule__Prefixed__Group_1__0__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1708:1: rule__Prefixed__Group_1__0__Impl : ( () ) ;
    public final void rule__Prefixed__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1712:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1713:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1713:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1714:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getArithmeticSignedAction_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1715:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1717:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixedAccess().getArithmeticSignedAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Prefixed__Group_1__0__Impl"


    // $ANTLR start "rule__Prefixed__Group_1__1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1727:1: rule__Prefixed__Group_1__1 : rule__Prefixed__Group_1__1__Impl rule__Prefixed__Group_1__2 ;
    public final void rule__Prefixed__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1731:1: ( rule__Prefixed__Group_1__1__Impl rule__Prefixed__Group_1__2 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1732:2: rule__Prefixed__Group_1__1__Impl rule__Prefixed__Group_1__2
            {
            pushFollow(FOLLOW_rule__Prefixed__Group_1__1__Impl_in_rule__Prefixed__Group_1__13446);
            rule__Prefixed__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Prefixed__Group_1__2_in_rule__Prefixed__Group_1__13449);
            rule__Prefixed__Group_1__2();

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
    // $ANTLR end "rule__Prefixed__Group_1__1"


    // $ANTLR start "rule__Prefixed__Group_1__1__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1739:1: rule__Prefixed__Group_1__1__Impl : ( ( '-' ) ) ;
    public final void rule__Prefixed__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1743:1: ( ( ( '-' ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1744:1: ( ( '-' ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1744:1: ( ( '-' ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1745:1: ( '-' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getHyphenMinusKeyword_1_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1746:1: ( '-' )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1747:2: '-'
            {
            match(input,19,FOLLOW_19_in_rule__Prefixed__Group_1__1__Impl3478); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixedAccess().getHyphenMinusKeyword_1_1()); 
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
    // $ANTLR end "rule__Prefixed__Group_1__1__Impl"


    // $ANTLR start "rule__Prefixed__Group_1__2"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1758:1: rule__Prefixed__Group_1__2 : rule__Prefixed__Group_1__2__Impl ;
    public final void rule__Prefixed__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1762:1: ( rule__Prefixed__Group_1__2__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1763:2: rule__Prefixed__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Prefixed__Group_1__2__Impl_in_rule__Prefixed__Group_1__23510);
            rule__Prefixed__Group_1__2__Impl();

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
    // $ANTLR end "rule__Prefixed__Group_1__2"


    // $ANTLR start "rule__Prefixed__Group_1__2__Impl"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1769:1: rule__Prefixed__Group_1__2__Impl : ( ( rule__Prefixed__ExpressionAssignment_1_2 ) ) ;
    public final void rule__Prefixed__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1773:1: ( ( ( rule__Prefixed__ExpressionAssignment_1_2 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1774:1: ( ( rule__Prefixed__ExpressionAssignment_1_2 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1774:1: ( ( rule__Prefixed__ExpressionAssignment_1_2 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1775:1: ( rule__Prefixed__ExpressionAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getExpressionAssignment_1_2()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1776:1: ( rule__Prefixed__ExpressionAssignment_1_2 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1776:2: rule__Prefixed__ExpressionAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Prefixed__ExpressionAssignment_1_2_in_rule__Prefixed__Group_1__2__Impl3537);
            rule__Prefixed__ExpressionAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixedAccess().getExpressionAssignment_1_2()); 
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
    // $ANTLR end "rule__Prefixed__Group_1__2__Impl"


    // $ANTLR start "rule__Atomic__Group_0__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1792:1: rule__Atomic__Group_0__0 : rule__Atomic__Group_0__0__Impl rule__Atomic__Group_0__1 ;
    public final void rule__Atomic__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1796:1: ( rule__Atomic__Group_0__0__Impl rule__Atomic__Group_0__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1797:2: rule__Atomic__Group_0__0__Impl rule__Atomic__Group_0__1
            {
            pushFollow(FOLLOW_rule__Atomic__Group_0__0__Impl_in_rule__Atomic__Group_0__03573);
            rule__Atomic__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Atomic__Group_0__1_in_rule__Atomic__Group_0__03576);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1804:1: rule__Atomic__Group_0__0__Impl : ( '(' ) ;
    public final void rule__Atomic__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1808:1: ( ( '(' ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1809:1: ( '(' )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1809:1: ( '(' )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1810:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getLeftParenthesisKeyword_0_0()); 
            }
            match(input,21,FOLLOW_21_in_rule__Atomic__Group_0__0__Impl3604); if (state.failed) return ;
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1823:1: rule__Atomic__Group_0__1 : rule__Atomic__Group_0__1__Impl rule__Atomic__Group_0__2 ;
    public final void rule__Atomic__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1827:1: ( rule__Atomic__Group_0__1__Impl rule__Atomic__Group_0__2 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1828:2: rule__Atomic__Group_0__1__Impl rule__Atomic__Group_0__2
            {
            pushFollow(FOLLOW_rule__Atomic__Group_0__1__Impl_in_rule__Atomic__Group_0__13635);
            rule__Atomic__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Atomic__Group_0__2_in_rule__Atomic__Group_0__13638);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1835:1: rule__Atomic__Group_0__1__Impl : ( ruleExpression ) ;
    public final void rule__Atomic__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1839:1: ( ( ruleExpression ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1840:1: ( ruleExpression )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1840:1: ( ruleExpression )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1841:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getExpressionParserRuleCall_0_1()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_rule__Atomic__Group_0__1__Impl3665);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1852:1: rule__Atomic__Group_0__2 : rule__Atomic__Group_0__2__Impl ;
    public final void rule__Atomic__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1856:1: ( rule__Atomic__Group_0__2__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1857:2: rule__Atomic__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__Atomic__Group_0__2__Impl_in_rule__Atomic__Group_0__23694);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1863:1: rule__Atomic__Group_0__2__Impl : ( ')' ) ;
    public final void rule__Atomic__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1867:1: ( ( ')' ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1868:1: ( ')' )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1868:1: ( ')' )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1869:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getRightParenthesisKeyword_0_2()); 
            }
            match(input,22,FOLLOW_22_in_rule__Atomic__Group_0__2__Impl3722); if (state.failed) return ;
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1888:1: rule__Atomic__Group_1__0 : rule__Atomic__Group_1__0__Impl rule__Atomic__Group_1__1 ;
    public final void rule__Atomic__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1892:1: ( rule__Atomic__Group_1__0__Impl rule__Atomic__Group_1__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1893:2: rule__Atomic__Group_1__0__Impl rule__Atomic__Group_1__1
            {
            pushFollow(FOLLOW_rule__Atomic__Group_1__0__Impl_in_rule__Atomic__Group_1__03759);
            rule__Atomic__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Atomic__Group_1__1_in_rule__Atomic__Group_1__03762);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1900:1: rule__Atomic__Group_1__0__Impl : ( () ) ;
    public final void rule__Atomic__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1904:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1905:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1905:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1906:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getNumberLiteralAction_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1907:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1909:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getNumberLiteralAction_1_0()); 
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1919:1: rule__Atomic__Group_1__1 : rule__Atomic__Group_1__1__Impl ;
    public final void rule__Atomic__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1923:1: ( rule__Atomic__Group_1__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1924:2: rule__Atomic__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Atomic__Group_1__1__Impl_in_rule__Atomic__Group_1__13820);
            rule__Atomic__Group_1__1__Impl();

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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1930:1: rule__Atomic__Group_1__1__Impl : ( ( rule__Atomic__ValueAssignment_1_1 ) ) ;
    public final void rule__Atomic__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1934:1: ( ( ( rule__Atomic__ValueAssignment_1_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1935:1: ( ( rule__Atomic__ValueAssignment_1_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1935:1: ( ( rule__Atomic__ValueAssignment_1_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1936:1: ( rule__Atomic__ValueAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getValueAssignment_1_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1937:1: ( rule__Atomic__ValueAssignment_1_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1937:2: rule__Atomic__ValueAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Atomic__ValueAssignment_1_1_in_rule__Atomic__Group_1__1__Impl3847);
            rule__Atomic__ValueAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getValueAssignment_1_1()); 
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


    // $ANTLR start "rule__Atomic__Group_2__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1951:1: rule__Atomic__Group_2__0 : rule__Atomic__Group_2__0__Impl rule__Atomic__Group_2__1 ;
    public final void rule__Atomic__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1955:1: ( rule__Atomic__Group_2__0__Impl rule__Atomic__Group_2__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1956:2: rule__Atomic__Group_2__0__Impl rule__Atomic__Group_2__1
            {
            pushFollow(FOLLOW_rule__Atomic__Group_2__0__Impl_in_rule__Atomic__Group_2__03881);
            rule__Atomic__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Atomic__Group_2__1_in_rule__Atomic__Group_2__03884);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1963:1: rule__Atomic__Group_2__0__Impl : ( () ) ;
    public final void rule__Atomic__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1967:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1968:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1968:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1969:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getStringLiteralAction_2_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1970:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1972:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getStringLiteralAction_2_0()); 
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1982:1: rule__Atomic__Group_2__1 : rule__Atomic__Group_2__1__Impl ;
    public final void rule__Atomic__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1986:1: ( rule__Atomic__Group_2__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1987:2: rule__Atomic__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Atomic__Group_2__1__Impl_in_rule__Atomic__Group_2__13942);
            rule__Atomic__Group_2__1__Impl();

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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1993:1: rule__Atomic__Group_2__1__Impl : ( ( rule__Atomic__ValueAssignment_2_1 ) ) ;
    public final void rule__Atomic__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1997:1: ( ( ( rule__Atomic__ValueAssignment_2_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1998:1: ( ( rule__Atomic__ValueAssignment_2_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1998:1: ( ( rule__Atomic__ValueAssignment_2_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1999:1: ( rule__Atomic__ValueAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getValueAssignment_2_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2000:1: ( rule__Atomic__ValueAssignment_2_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2000:2: rule__Atomic__ValueAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Atomic__ValueAssignment_2_1_in_rule__Atomic__Group_2__1__Impl3969);
            rule__Atomic__ValueAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getValueAssignment_2_1()); 
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


    // $ANTLR start "rule__Atomic__Group_3__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2014:1: rule__Atomic__Group_3__0 : rule__Atomic__Group_3__0__Impl rule__Atomic__Group_3__1 ;
    public final void rule__Atomic__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2018:1: ( rule__Atomic__Group_3__0__Impl rule__Atomic__Group_3__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2019:2: rule__Atomic__Group_3__0__Impl rule__Atomic__Group_3__1
            {
            pushFollow(FOLLOW_rule__Atomic__Group_3__0__Impl_in_rule__Atomic__Group_3__04003);
            rule__Atomic__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Atomic__Group_3__1_in_rule__Atomic__Group_3__04006);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2026:1: rule__Atomic__Group_3__0__Impl : ( () ) ;
    public final void rule__Atomic__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2030:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2031:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2031:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2032:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getBooleanLiteralAction_3_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2033:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2035:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getBooleanLiteralAction_3_0()); 
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2045:1: rule__Atomic__Group_3__1 : rule__Atomic__Group_3__1__Impl ;
    public final void rule__Atomic__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2049:1: ( rule__Atomic__Group_3__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2050:2: rule__Atomic__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Atomic__Group_3__1__Impl_in_rule__Atomic__Group_3__14064);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2056:1: rule__Atomic__Group_3__1__Impl : ( ( rule__Atomic__ValueAssignment_3_1 ) ) ;
    public final void rule__Atomic__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2060:1: ( ( ( rule__Atomic__ValueAssignment_3_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2061:1: ( ( rule__Atomic__ValueAssignment_3_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2061:1: ( ( rule__Atomic__ValueAssignment_3_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2062:1: ( rule__Atomic__ValueAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getValueAssignment_3_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2063:1: ( rule__Atomic__ValueAssignment_3_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2063:2: rule__Atomic__ValueAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Atomic__ValueAssignment_3_1_in_rule__Atomic__Group_3__1__Impl4091);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2077:1: rule__Atomic__Group_4__0 : rule__Atomic__Group_4__0__Impl rule__Atomic__Group_4__1 ;
    public final void rule__Atomic__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2081:1: ( rule__Atomic__Group_4__0__Impl rule__Atomic__Group_4__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2082:2: rule__Atomic__Group_4__0__Impl rule__Atomic__Group_4__1
            {
            pushFollow(FOLLOW_rule__Atomic__Group_4__0__Impl_in_rule__Atomic__Group_4__04125);
            rule__Atomic__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Atomic__Group_4__1_in_rule__Atomic__Group_4__04128);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2089:1: rule__Atomic__Group_4__0__Impl : ( () ) ;
    public final void rule__Atomic__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2093:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2094:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2094:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2095:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getVariableReferenceAction_4_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2096:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2098:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getVariableReferenceAction_4_0()); 
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2108:1: rule__Atomic__Group_4__1 : rule__Atomic__Group_4__1__Impl ;
    public final void rule__Atomic__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2112:1: ( rule__Atomic__Group_4__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2113:2: rule__Atomic__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Atomic__Group_4__1__Impl_in_rule__Atomic__Group_4__14186);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2119:1: rule__Atomic__Group_4__1__Impl : ( ( rule__Atomic__RefAssignment_4_1 ) ) ;
    public final void rule__Atomic__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2123:1: ( ( ( rule__Atomic__RefAssignment_4_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2124:1: ( ( rule__Atomic__RefAssignment_4_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2124:1: ( ( rule__Atomic__RefAssignment_4_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2125:1: ( rule__Atomic__RefAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getRefAssignment_4_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2126:1: ( rule__Atomic__RefAssignment_4_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2126:2: rule__Atomic__RefAssignment_4_1
            {
            pushFollow(FOLLOW_rule__Atomic__RefAssignment_4_1_in_rule__Atomic__Group_4__1__Impl4213);
            rule__Atomic__RefAssignment_4_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getRefAssignment_4_1()); 
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


    // $ANTLR start "rule__Model__VariablesAssignment"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2144:1: rule__Model__VariablesAssignment : ( ruleVariable ) ;
    public final void rule__Model__VariablesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2148:1: ( ( ruleVariable ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2149:1: ( ruleVariable )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2149:1: ( ruleVariable )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2150:1: ruleVariable
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getVariablesVariableParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleVariable_in_rule__Model__VariablesAssignment4255);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2159:1: rule__Variable__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Variable__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2163:1: ( ( RULE_ID ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2164:1: ( RULE_ID )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2164:1: ( RULE_ID )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2165:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Variable__NameAssignment_04286); if (state.failed) return ;
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2174:1: rule__Variable__ExpressionAssignment_2 : ( ruleExpression ) ;
    public final void rule__Variable__ExpressionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2178:1: ( ( ruleExpression ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2179:1: ( ruleExpression )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2179:1: ( ruleExpression )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2180:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableAccess().getExpressionExpressionParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_rule__Variable__ExpressionAssignment_24317);
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


    // $ANTLR start "rule__BooleanExpression__OpAssignment_1_0_1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2189:1: rule__BooleanExpression__OpAssignment_1_0_1 : ( ( rule__BooleanExpression__OpAlternatives_1_0_1_0 ) ) ;
    public final void rule__BooleanExpression__OpAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2193:1: ( ( ( rule__BooleanExpression__OpAlternatives_1_0_1_0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2194:1: ( ( rule__BooleanExpression__OpAlternatives_1_0_1_0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2194:1: ( ( rule__BooleanExpression__OpAlternatives_1_0_1_0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2195:1: ( rule__BooleanExpression__OpAlternatives_1_0_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getOpAlternatives_1_0_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2196:1: ( rule__BooleanExpression__OpAlternatives_1_0_1_0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2196:2: rule__BooleanExpression__OpAlternatives_1_0_1_0
            {
            pushFollow(FOLLOW_rule__BooleanExpression__OpAlternatives_1_0_1_0_in_rule__BooleanExpression__OpAssignment_1_0_14348);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2205:1: rule__BooleanExpression__RightAssignment_1_1 : ( ruleComparison ) ;
    public final void rule__BooleanExpression__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2209:1: ( ( ruleComparison ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2210:1: ( ruleComparison )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2210:1: ( ruleComparison )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2211:1: ruleComparison
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getRightComparisonParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleComparison_in_rule__BooleanExpression__RightAssignment_1_14381);
            ruleComparison();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanExpressionAccess().getRightComparisonParserRuleCall_1_1_0()); 
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


    // $ANTLR start "rule__Comparison__OpAssignment_1_0_1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2220:1: rule__Comparison__OpAssignment_1_0_1 : ( ( '<' ) ) ;
    public final void rule__Comparison__OpAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2224:1: ( ( ( '<' ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2225:1: ( ( '<' ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2225:1: ( ( '<' ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2226:1: ( '<' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getOpLessThanSignKeyword_1_0_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2227:1: ( '<' )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2228:1: '<'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getOpLessThanSignKeyword_1_0_1_0()); 
            }
            match(input,23,FOLLOW_23_in_rule__Comparison__OpAssignment_1_0_14417); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getOpLessThanSignKeyword_1_0_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getOpLessThanSignKeyword_1_0_1_0()); 
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2243:1: rule__Comparison__RightAssignment_1_1 : ( ruleEquals ) ;
    public final void rule__Comparison__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2247:1: ( ( ruleEquals ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2248:1: ( ruleEquals )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2248:1: ( ruleEquals )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2249:1: ruleEquals
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getRightEqualsParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleEquals_in_rule__Comparison__RightAssignment_1_14456);
            ruleEquals();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getRightEqualsParserRuleCall_1_1_0()); 
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


    // $ANTLR start "rule__Equals__OpAssignment_1_0_1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2258:1: rule__Equals__OpAssignment_1_0_1 : ( ( '==' ) ) ;
    public final void rule__Equals__OpAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2262:1: ( ( ( '==' ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2263:1: ( ( '==' ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2263:1: ( ( '==' ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2264:1: ( '==' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualsAccess().getOpEqualsSignEqualsSignKeyword_1_0_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2265:1: ( '==' )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2266:1: '=='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualsAccess().getOpEqualsSignEqualsSignKeyword_1_0_1_0()); 
            }
            match(input,24,FOLLOW_24_in_rule__Equals__OpAssignment_1_0_14492); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualsAccess().getOpEqualsSignEqualsSignKeyword_1_0_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualsAccess().getOpEqualsSignEqualsSignKeyword_1_0_1_0()); 
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
    // $ANTLR end "rule__Equals__OpAssignment_1_0_1"


    // $ANTLR start "rule__Equals__RightAssignment_1_1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2281:1: rule__Equals__RightAssignment_1_1 : ( ruleAddition ) ;
    public final void rule__Equals__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2285:1: ( ( ruleAddition ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2286:1: ( ruleAddition )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2286:1: ( ruleAddition )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2287:1: ruleAddition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualsAccess().getRightAdditionParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleAddition_in_rule__Equals__RightAssignment_1_14531);
            ruleAddition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualsAccess().getRightAdditionParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__Equals__RightAssignment_1_1"


    // $ANTLR start "rule__Addition__RightAssignment_1_1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2296:1: rule__Addition__RightAssignment_1_1 : ( ruleMultiplication ) ;
    public final void rule__Addition__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2300:1: ( ( ruleMultiplication ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2301:1: ( ruleMultiplication )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2301:1: ( ruleMultiplication )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2302:1: ruleMultiplication
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleMultiplication_in_rule__Addition__RightAssignment_1_14562);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2311:1: rule__Multiplication__OpAssignment_1_0_1 : ( ( rule__Multiplication__OpAlternatives_1_0_1_0 ) ) ;
    public final void rule__Multiplication__OpAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2315:1: ( ( ( rule__Multiplication__OpAlternatives_1_0_1_0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2316:1: ( ( rule__Multiplication__OpAlternatives_1_0_1_0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2316:1: ( ( rule__Multiplication__OpAlternatives_1_0_1_0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2317:1: ( rule__Multiplication__OpAlternatives_1_0_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getOpAlternatives_1_0_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2318:1: ( rule__Multiplication__OpAlternatives_1_0_1_0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2318:2: rule__Multiplication__OpAlternatives_1_0_1_0
            {
            pushFollow(FOLLOW_rule__Multiplication__OpAlternatives_1_0_1_0_in_rule__Multiplication__OpAssignment_1_0_14593);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2327:1: rule__Multiplication__RightAssignment_1_1 : ( rulePrefixed ) ;
    public final void rule__Multiplication__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2331:1: ( ( rulePrefixed ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2332:1: ( rulePrefixed )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2332:1: ( rulePrefixed )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2333:1: rulePrefixed
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getRightPrefixedParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_rulePrefixed_in_rule__Multiplication__RightAssignment_1_14626);
            rulePrefixed();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicationAccess().getRightPrefixedParserRuleCall_1_1_0()); 
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


    // $ANTLR start "rule__Prefixed__ExpressionAssignment_0_2"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2342:1: rule__Prefixed__ExpressionAssignment_0_2 : ( ruleAtomic ) ;
    public final void rule__Prefixed__ExpressionAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2346:1: ( ( ruleAtomic ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2347:1: ( ruleAtomic )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2347:1: ( ruleAtomic )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2348:1: ruleAtomic
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getExpressionAtomicParserRuleCall_0_2_0()); 
            }
            pushFollow(FOLLOW_ruleAtomic_in_rule__Prefixed__ExpressionAssignment_0_24657);
            ruleAtomic();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixedAccess().getExpressionAtomicParserRuleCall_0_2_0()); 
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
    // $ANTLR end "rule__Prefixed__ExpressionAssignment_0_2"


    // $ANTLR start "rule__Prefixed__ExpressionAssignment_1_2"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2357:1: rule__Prefixed__ExpressionAssignment_1_2 : ( ruleAtomic ) ;
    public final void rule__Prefixed__ExpressionAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2361:1: ( ( ruleAtomic ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2362:1: ( ruleAtomic )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2362:1: ( ruleAtomic )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2363:1: ruleAtomic
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getExpressionAtomicParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleAtomic_in_rule__Prefixed__ExpressionAssignment_1_24688);
            ruleAtomic();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixedAccess().getExpressionAtomicParserRuleCall_1_2_0()); 
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
    // $ANTLR end "rule__Prefixed__ExpressionAssignment_1_2"


    // $ANTLR start "rule__Atomic__ValueAssignment_1_1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2372:1: rule__Atomic__ValueAssignment_1_1 : ( RULE_INT ) ;
    public final void rule__Atomic__ValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2376:1: ( ( RULE_INT ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2377:1: ( RULE_INT )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2377:1: ( RULE_INT )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2378:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getValueINTTerminalRuleCall_1_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Atomic__ValueAssignment_1_14719); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getValueINTTerminalRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__Atomic__ValueAssignment_1_1"


    // $ANTLR start "rule__Atomic__ValueAssignment_2_1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2387:1: rule__Atomic__ValueAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__Atomic__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2391:1: ( ( RULE_STRING ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2392:1: ( RULE_STRING )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2392:1: ( RULE_STRING )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2393:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getValueSTRINGTerminalRuleCall_2_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Atomic__ValueAssignment_2_14750); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getValueSTRINGTerminalRuleCall_2_1_0()); 
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
    // $ANTLR end "rule__Atomic__ValueAssignment_2_1"


    // $ANTLR start "rule__Atomic__ValueAssignment_3_1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2402:1: rule__Atomic__ValueAssignment_3_1 : ( ( rule__Atomic__ValueAlternatives_3_1_0 ) ) ;
    public final void rule__Atomic__ValueAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2406:1: ( ( ( rule__Atomic__ValueAlternatives_3_1_0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2407:1: ( ( rule__Atomic__ValueAlternatives_3_1_0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2407:1: ( ( rule__Atomic__ValueAlternatives_3_1_0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2408:1: ( rule__Atomic__ValueAlternatives_3_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getValueAlternatives_3_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2409:1: ( rule__Atomic__ValueAlternatives_3_1_0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2409:2: rule__Atomic__ValueAlternatives_3_1_0
            {
            pushFollow(FOLLOW_rule__Atomic__ValueAlternatives_3_1_0_in_rule__Atomic__ValueAssignment_3_14781);
            rule__Atomic__ValueAlternatives_3_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getValueAlternatives_3_1_0()); 
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


    // $ANTLR start "rule__Atomic__RefAssignment_4_1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2418:1: rule__Atomic__RefAssignment_4_1 : ( ( RULE_ID ) ) ;
    public final void rule__Atomic__RefAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2422:1: ( ( ( RULE_ID ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2423:1: ( ( RULE_ID ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2423:1: ( ( RULE_ID ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2424:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getRefVariableCrossReference_4_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2425:1: ( RULE_ID )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2426:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getRefVariableIDTerminalRuleCall_4_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Atomic__RefAssignment_4_14818); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getRefVariableIDTerminalRuleCall_4_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicAccess().getRefVariableCrossReference_4_1_0()); 
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
    // $ANTLR end "rule__Atomic__RefAssignment_4_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__VariablesAssignment_in_ruleModel100 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable128 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group__0_in_ruleVariable161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression188 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanExpression_in_ruleExpression221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanExpression254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group__0_in_ruleBooleanExpression280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparison_in_entryRuleComparison307 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComparison314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group__0_in_ruleComparison340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEquals_in_entryRuleEquals367 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEquals374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equals__Group__0_in_ruleEquals400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_entryRuleAddition427 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddition434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group__0_in_ruleAddition460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_entryRuleMultiplication487 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group__0_in_ruleMultiplication520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrefixed_in_entryRulePrefixed547 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrefixed554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Prefixed__Alternatives_in_rulePrefixed580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomic_in_entryRuleAtomic607 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtomic614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Alternatives_in_ruleAtomic640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__BooleanExpression__OpAlternatives_1_0_1_0679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__BooleanExpression__OpAlternatives_1_0_1_0699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_0__0_in_rule__Addition__Alternatives_1_0733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_1__0_in_rule__Addition__Alternatives_1_0751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Multiplication__OpAlternatives_1_0_1_0785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Multiplication__OpAlternatives_1_0_1_0805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Prefixed__Group_0__0_in_rule__Prefixed__Alternatives839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Prefixed__Group_1__0_in_rule__Prefixed__Alternatives857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomic_in_rule__Prefixed__Alternatives875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_0__0_in_rule__Atomic__Alternatives907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_1__0_in_rule__Atomic__Alternatives925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_2__0_in_rule__Atomic__Alternatives943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_3__0_in_rule__Atomic__Alternatives961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_4__0_in_rule__Atomic__Alternatives979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Atomic__ValueAlternatives_3_1_01013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Atomic__ValueAlternatives_3_1_01033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group__0__Impl_in_rule__Variable__Group__01066 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Variable__Group__1_in_rule__Variable__Group__01069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__NameAssignment_0_in_rule__Variable__Group__0__Impl1096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group__1__Impl_in_rule__Variable__Group__11126 = new BitSet(new long[]{0x0000000000398070L});
    public static final BitSet FOLLOW_rule__Variable__Group__2_in_rule__Variable__Group__11129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Variable__Group__1__Impl1157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group__2__Impl_in_rule__Variable__Group__21188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__ExpressionAssignment_2_in_rule__Variable__Group__2__Impl1215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group__0__Impl_in_rule__BooleanExpression__Group__01251 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group__1_in_rule__BooleanExpression__Group__01254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparison_in_rule__BooleanExpression__Group__0__Impl1281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group__1__Impl_in_rule__BooleanExpression__Group__11310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group_1__0_in_rule__BooleanExpression__Group__1__Impl1337 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group_1__0__Impl_in_rule__BooleanExpression__Group_1__01372 = new BitSet(new long[]{0x0000000000398070L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group_1__1_in_rule__BooleanExpression__Group_1__01375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group_1_0__0_in_rule__BooleanExpression__Group_1__0__Impl1402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group_1__1__Impl_in_rule__BooleanExpression__Group_1__11432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__RightAssignment_1_1_in_rule__BooleanExpression__Group_1__1__Impl1459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group_1_0__0__Impl_in_rule__BooleanExpression__Group_1_0__01493 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group_1_0__1_in_rule__BooleanExpression__Group_1_0__01496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group_1_0__1__Impl_in_rule__BooleanExpression__Group_1_0__11554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__OpAssignment_1_0_1_in_rule__BooleanExpression__Group_1_0__1__Impl1581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group__0__Impl_in_rule__Comparison__Group__01615 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__Comparison__Group__1_in_rule__Comparison__Group__01618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEquals_in_rule__Comparison__Group__0__Impl1645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group__1__Impl_in_rule__Comparison__Group__11674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1__0_in_rule__Comparison__Group__1__Impl1701 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1__0__Impl_in_rule__Comparison__Group_1__01736 = new BitSet(new long[]{0x0000000000398070L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1__1_in_rule__Comparison__Group_1__01739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0__0_in_rule__Comparison__Group_1__0__Impl1766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1__1__Impl_in_rule__Comparison__Group_1__11796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__RightAssignment_1_1_in_rule__Comparison__Group_1__1__Impl1823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0__0__Impl_in_rule__Comparison__Group_1_0__01857 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0__1_in_rule__Comparison__Group_1_0__01860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0__1__Impl_in_rule__Comparison__Group_1_0__11918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__OpAssignment_1_0_1_in_rule__Comparison__Group_1_0__1__Impl1945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equals__Group__0__Impl_in_rule__Equals__Group__01979 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__Equals__Group__1_in_rule__Equals__Group__01982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_rule__Equals__Group__0__Impl2009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equals__Group__1__Impl_in_rule__Equals__Group__12038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equals__Group_1__0_in_rule__Equals__Group__1__Impl2065 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_rule__Equals__Group_1__0__Impl_in_rule__Equals__Group_1__02100 = new BitSet(new long[]{0x0000000000398070L});
    public static final BitSet FOLLOW_rule__Equals__Group_1__1_in_rule__Equals__Group_1__02103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equals__Group_1_0__0_in_rule__Equals__Group_1__0__Impl2130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equals__Group_1__1__Impl_in_rule__Equals__Group_1__12160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equals__RightAssignment_1_1_in_rule__Equals__Group_1__1__Impl2187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equals__Group_1_0__0__Impl_in_rule__Equals__Group_1_0__02221 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__Equals__Group_1_0__1_in_rule__Equals__Group_1_0__02224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equals__Group_1_0__1__Impl_in_rule__Equals__Group_1_0__12282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equals__OpAssignment_1_0_1_in_rule__Equals__Group_1_0__1__Impl2309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group__0__Impl_in_rule__Addition__Group__02343 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_rule__Addition__Group__1_in_rule__Addition__Group__02346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_rule__Addition__Group__0__Impl2373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group__1__Impl_in_rule__Addition__Group__12402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1__0_in_rule__Addition__Group__1__Impl2429 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1__0__Impl_in_rule__Addition__Group_1__02464 = new BitSet(new long[]{0x0000000000398070L});
    public static final BitSet FOLLOW_rule__Addition__Group_1__1_in_rule__Addition__Group_1__02467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Alternatives_1_0_in_rule__Addition__Group_1__0__Impl2494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1__1__Impl_in_rule__Addition__Group_1__12524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__RightAssignment_1_1_in_rule__Addition__Group_1__1__Impl2551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_0__0__Impl_in_rule__Addition__Group_1_0_0__02585 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_0__1_in_rule__Addition__Group_1_0_0__02588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_0__1__Impl_in_rule__Addition__Group_1_0_0__12646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Addition__Group_1_0_0__1__Impl2674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_1__0__Impl_in_rule__Addition__Group_1_0_1__02709 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_1__1_in_rule__Addition__Group_1_0_1__02712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_1__1__Impl_in_rule__Addition__Group_1_0_1__12770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Addition__Group_1_0_1__1__Impl2798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group__0__Impl_in_rule__Multiplication__Group__02833 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_rule__Multiplication__Group__1_in_rule__Multiplication__Group__02836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrefixed_in_rule__Multiplication__Group__0__Impl2863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group__1__Impl_in_rule__Multiplication__Group__12892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1__0_in_rule__Multiplication__Group__1__Impl2919 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1__0__Impl_in_rule__Multiplication__Group_1__02954 = new BitSet(new long[]{0x0000000000398070L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1__1_in_rule__Multiplication__Group_1__02957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0__0_in_rule__Multiplication__Group_1__0__Impl2984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1__1__Impl_in_rule__Multiplication__Group_1__13014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__RightAssignment_1_1_in_rule__Multiplication__Group_1__1__Impl3041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0__0__Impl_in_rule__Multiplication__Group_1_0__03075 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0__1_in_rule__Multiplication__Group_1_0__03078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0__1__Impl_in_rule__Multiplication__Group_1_0__13136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__OpAssignment_1_0_1_in_rule__Multiplication__Group_1_0__1__Impl3163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Prefixed__Group_0__0__Impl_in_rule__Prefixed__Group_0__03197 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Prefixed__Group_0__1_in_rule__Prefixed__Group_0__03200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Prefixed__Group_0__1__Impl_in_rule__Prefixed__Group_0__13258 = new BitSet(new long[]{0x0000000000398070L});
    public static final BitSet FOLLOW_rule__Prefixed__Group_0__2_in_rule__Prefixed__Group_0__13261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Prefixed__Group_0__1__Impl3290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Prefixed__Group_0__2__Impl_in_rule__Prefixed__Group_0__23322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Prefixed__ExpressionAssignment_0_2_in_rule__Prefixed__Group_0__2__Impl3349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Prefixed__Group_1__0__Impl_in_rule__Prefixed__Group_1__03385 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Prefixed__Group_1__1_in_rule__Prefixed__Group_1__03388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Prefixed__Group_1__1__Impl_in_rule__Prefixed__Group_1__13446 = new BitSet(new long[]{0x0000000000398070L});
    public static final BitSet FOLLOW_rule__Prefixed__Group_1__2_in_rule__Prefixed__Group_1__13449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Prefixed__Group_1__1__Impl3478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Prefixed__Group_1__2__Impl_in_rule__Prefixed__Group_1__23510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Prefixed__ExpressionAssignment_1_2_in_rule__Prefixed__Group_1__2__Impl3537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_0__0__Impl_in_rule__Atomic__Group_0__03573 = new BitSet(new long[]{0x0000000000398070L});
    public static final BitSet FOLLOW_rule__Atomic__Group_0__1_in_rule__Atomic__Group_0__03576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Atomic__Group_0__0__Impl3604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_0__1__Impl_in_rule__Atomic__Group_0__13635 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__Atomic__Group_0__2_in_rule__Atomic__Group_0__13638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__Atomic__Group_0__1__Impl3665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_0__2__Impl_in_rule__Atomic__Group_0__23694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Atomic__Group_0__2__Impl3722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_1__0__Impl_in_rule__Atomic__Group_1__03759 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Atomic__Group_1__1_in_rule__Atomic__Group_1__03762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_1__1__Impl_in_rule__Atomic__Group_1__13820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__ValueAssignment_1_1_in_rule__Atomic__Group_1__1__Impl3847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_2__0__Impl_in_rule__Atomic__Group_2__03881 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Atomic__Group_2__1_in_rule__Atomic__Group_2__03884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_2__1__Impl_in_rule__Atomic__Group_2__13942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__ValueAssignment_2_1_in_rule__Atomic__Group_2__1__Impl3969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_3__0__Impl_in_rule__Atomic__Group_3__04003 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_rule__Atomic__Group_3__1_in_rule__Atomic__Group_3__04006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_3__1__Impl_in_rule__Atomic__Group_3__14064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__ValueAssignment_3_1_in_rule__Atomic__Group_3__1__Impl4091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_4__0__Impl_in_rule__Atomic__Group_4__04125 = new BitSet(new long[]{0x0000000000398070L});
    public static final BitSet FOLLOW_rule__Atomic__Group_4__1_in_rule__Atomic__Group_4__04128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_4__1__Impl_in_rule__Atomic__Group_4__14186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__RefAssignment_4_1_in_rule__Atomic__Group_4__1__Impl4213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__Model__VariablesAssignment4255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Variable__NameAssignment_04286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__Variable__ExpressionAssignment_24317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__OpAlternatives_1_0_1_0_in_rule__BooleanExpression__OpAssignment_1_0_14348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparison_in_rule__BooleanExpression__RightAssignment_1_14381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Comparison__OpAssignment_1_0_14417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEquals_in_rule__Comparison__RightAssignment_1_14456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Equals__OpAssignment_1_0_14492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_rule__Equals__RightAssignment_1_14531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_rule__Addition__RightAssignment_1_14562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__OpAlternatives_1_0_1_0_in_rule__Multiplication__OpAssignment_1_0_14593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrefixed_in_rule__Multiplication__RightAssignment_1_14626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomic_in_rule__Prefixed__ExpressionAssignment_0_24657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomic_in_rule__Prefixed__ExpressionAssignment_1_24688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Atomic__ValueAssignment_1_14719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Atomic__ValueAssignment_2_14750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__ValueAlternatives_3_1_0_in_rule__Atomic__ValueAssignment_3_14781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Atomic__RefAssignment_4_14818 = new BitSet(new long[]{0x0000000000000002L});

}