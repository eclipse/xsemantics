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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'||'", "'&&'", "'<'", "'=='", "'*'", "'/'", "'true'", "'false'", "'='", "'+'", "'-'", "'!'", "'('", "')'"
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


    // $ANTLR start "entryRuleAddition"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:201:1: entryRuleAddition : ruleAddition EOF ;
    public final void entryRuleAddition() throws RecognitionException {
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:202:1: ( ruleAddition EOF )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:203:1: ruleAddition EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionRule()); 
            }
            pushFollow(FOLLOW_ruleAddition_in_entryRuleAddition367);
            ruleAddition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddition374); if (state.failed) return ;

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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:210:1: ruleAddition : ( ( rule__Addition__Group__0 ) ) ;
    public final void ruleAddition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:214:2: ( ( ( rule__Addition__Group__0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:215:1: ( ( rule__Addition__Group__0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:215:1: ( ( rule__Addition__Group__0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:216:1: ( rule__Addition__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getGroup()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:217:1: ( rule__Addition__Group__0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:217:2: rule__Addition__Group__0
            {
            pushFollow(FOLLOW_rule__Addition__Group__0_in_ruleAddition400);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:229:1: entryRuleMultiplication : ruleMultiplication EOF ;
    public final void entryRuleMultiplication() throws RecognitionException {
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:230:1: ( ruleMultiplication EOF )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:231:1: ruleMultiplication EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplication_in_entryRuleMultiplication427);
            ruleMultiplication();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicationRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplication434); if (state.failed) return ;

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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:238:1: ruleMultiplication : ( ( rule__Multiplication__Group__0 ) ) ;
    public final void ruleMultiplication() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:242:2: ( ( ( rule__Multiplication__Group__0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:243:1: ( ( rule__Multiplication__Group__0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:243:1: ( ( rule__Multiplication__Group__0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:244:1: ( rule__Multiplication__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getGroup()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:245:1: ( rule__Multiplication__Group__0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:245:2: rule__Multiplication__Group__0
            {
            pushFollow(FOLLOW_rule__Multiplication__Group__0_in_ruleMultiplication460);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:257:1: entryRulePrefixed : rulePrefixed EOF ;
    public final void entryRulePrefixed() throws RecognitionException {
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:258:1: ( rulePrefixed EOF )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:259:1: rulePrefixed EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedRule()); 
            }
            pushFollow(FOLLOW_rulePrefixed_in_entryRulePrefixed487);
            rulePrefixed();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixedRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrefixed494); if (state.failed) return ;

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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:266:1: rulePrefixed : ( ( rule__Prefixed__Alternatives ) ) ;
    public final void rulePrefixed() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:270:2: ( ( ( rule__Prefixed__Alternatives ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:271:1: ( ( rule__Prefixed__Alternatives ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:271:1: ( ( rule__Prefixed__Alternatives ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:272:1: ( rule__Prefixed__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getAlternatives()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:273:1: ( rule__Prefixed__Alternatives )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:273:2: rule__Prefixed__Alternatives
            {
            pushFollow(FOLLOW_rule__Prefixed__Alternatives_in_rulePrefixed520);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:285:1: entryRuleAtomic : ruleAtomic EOF ;
    public final void entryRuleAtomic() throws RecognitionException {
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:286:1: ( ruleAtomic EOF )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:287:1: ruleAtomic EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicRule()); 
            }
            pushFollow(FOLLOW_ruleAtomic_in_entryRuleAtomic547);
            ruleAtomic();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAtomicRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtomic554); if (state.failed) return ;

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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:294:1: ruleAtomic : ( ( rule__Atomic__Alternatives ) ) ;
    public final void ruleAtomic() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:298:2: ( ( ( rule__Atomic__Alternatives ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:299:1: ( ( rule__Atomic__Alternatives ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:299:1: ( ( rule__Atomic__Alternatives ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:300:1: ( rule__Atomic__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getAlternatives()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:301:1: ( rule__Atomic__Alternatives )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:301:2: rule__Atomic__Alternatives
            {
            pushFollow(FOLLOW_rule__Atomic__Alternatives_in_ruleAtomic580);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:315:1: rule__BooleanExpression__OpAlternatives_1_0_1_0 : ( ( '||' ) | ( '&&' ) );
    public final void rule__BooleanExpression__OpAlternatives_1_0_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:319:1: ( ( '||' ) | ( '&&' ) )
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
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:320:1: ( '||' )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:320:1: ( '||' )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:321:1: '||'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanExpressionAccess().getOpVerticalLineVerticalLineKeyword_1_0_1_0_0()); 
                    }
                    match(input,11,FOLLOW_11_in_rule__BooleanExpression__OpAlternatives_1_0_1_0619); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBooleanExpressionAccess().getOpVerticalLineVerticalLineKeyword_1_0_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:328:6: ( '&&' )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:328:6: ( '&&' )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:329:1: '&&'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanExpressionAccess().getOpAmpersandAmpersandKeyword_1_0_1_0_1()); 
                    }
                    match(input,12,FOLLOW_12_in_rule__BooleanExpression__OpAlternatives_1_0_1_0639); if (state.failed) return ;
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


    // $ANTLR start "rule__Comparison__OpAlternatives_1_0_1_0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:341:1: rule__Comparison__OpAlternatives_1_0_1_0 : ( ( '<' ) | ( '==' ) );
    public final void rule__Comparison__OpAlternatives_1_0_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:345:1: ( ( '<' ) | ( '==' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            else if ( (LA3_0==14) ) {
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
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:346:1: ( '<' )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:346:1: ( '<' )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:347:1: '<'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonAccess().getOpLessThanSignKeyword_1_0_1_0_0()); 
                    }
                    match(input,13,FOLLOW_13_in_rule__Comparison__OpAlternatives_1_0_1_0674); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getComparisonAccess().getOpLessThanSignKeyword_1_0_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:354:6: ( '==' )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:354:6: ( '==' )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:355:1: '=='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getComparisonAccess().getOpEqualsSignEqualsSignKeyword_1_0_1_0_1()); 
                    }
                    match(input,14,FOLLOW_14_in_rule__Comparison__OpAlternatives_1_0_1_0694); if (state.failed) return ;
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


    // $ANTLR start "rule__Addition__Alternatives_1_0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:367:1: rule__Addition__Alternatives_1_0 : ( ( ( rule__Addition__Group_1_0_0__0 ) ) | ( ( rule__Addition__Group_1_0_1__0 ) ) );
    public final void rule__Addition__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:371:1: ( ( ( rule__Addition__Group_1_0_0__0 ) ) | ( ( rule__Addition__Group_1_0_1__0 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==20) ) {
                alt4=1;
            }
            else if ( (LA4_0==21) ) {
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
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:372:1: ( ( rule__Addition__Group_1_0_0__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:372:1: ( ( rule__Addition__Group_1_0_0__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:373:1: ( rule__Addition__Group_1_0_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAdditionAccess().getGroup_1_0_0()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:374:1: ( rule__Addition__Group_1_0_0__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:374:2: rule__Addition__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_rule__Addition__Group_1_0_0__0_in_rule__Addition__Alternatives_1_0728);
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
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:378:6: ( ( rule__Addition__Group_1_0_1__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:378:6: ( ( rule__Addition__Group_1_0_1__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:379:1: ( rule__Addition__Group_1_0_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAdditionAccess().getGroup_1_0_1()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:380:1: ( rule__Addition__Group_1_0_1__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:380:2: rule__Addition__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Addition__Group_1_0_1__0_in_rule__Addition__Alternatives_1_0746);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:389:1: rule__Multiplication__OpAlternatives_1_0_1_0 : ( ( '*' ) | ( '/' ) );
    public final void rule__Multiplication__OpAlternatives_1_0_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:393:1: ( ( '*' ) | ( '/' ) )
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
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:394:1: ( '*' )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:394:1: ( '*' )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:395:1: '*'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicationAccess().getOpAsteriskKeyword_1_0_1_0_0()); 
                    }
                    match(input,15,FOLLOW_15_in_rule__Multiplication__OpAlternatives_1_0_1_0780); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicationAccess().getOpAsteriskKeyword_1_0_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:402:6: ( '/' )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:402:6: ( '/' )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:403:1: '/'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicationAccess().getOpSolidusKeyword_1_0_1_0_1()); 
                    }
                    match(input,16,FOLLOW_16_in_rule__Multiplication__OpAlternatives_1_0_1_0800); if (state.failed) return ;
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:415:1: rule__Prefixed__Alternatives : ( ( ( rule__Prefixed__Group_0__0 ) ) | ( ( rule__Prefixed__Group_1__0 ) ) | ( ruleAtomic ) );
    public final void rule__Prefixed__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:419:1: ( ( ( rule__Prefixed__Group_0__0 ) ) | ( ( rule__Prefixed__Group_1__0 ) ) | ( ruleAtomic ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt6=1;
                }
                break;
            case 21:
                {
                alt6=2;
                }
                break;
            case RULE_ID:
            case RULE_INT:
            case RULE_STRING:
            case 17:
            case 18:
            case 23:
                {
                alt6=3;
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
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:420:1: ( ( rule__Prefixed__Group_0__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:420:1: ( ( rule__Prefixed__Group_0__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:421:1: ( rule__Prefixed__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrefixedAccess().getGroup_0()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:422:1: ( rule__Prefixed__Group_0__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:422:2: rule__Prefixed__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Prefixed__Group_0__0_in_rule__Prefixed__Alternatives834);
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
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:426:6: ( ( rule__Prefixed__Group_1__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:426:6: ( ( rule__Prefixed__Group_1__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:427:1: ( rule__Prefixed__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrefixedAccess().getGroup_1()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:428:1: ( rule__Prefixed__Group_1__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:428:2: rule__Prefixed__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Prefixed__Group_1__0_in_rule__Prefixed__Alternatives852);
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
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:432:6: ( ruleAtomic )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:432:6: ( ruleAtomic )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:433:1: ruleAtomic
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrefixedAccess().getAtomicParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_ruleAtomic_in_rule__Prefixed__Alternatives870);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:443:1: rule__Atomic__Alternatives : ( ( ( rule__Atomic__Group_0__0 ) ) | ( ( rule__Atomic__Group_1__0 ) ) | ( ( rule__Atomic__Group_2__0 ) ) | ( ( rule__Atomic__Group_3__0 ) ) | ( ( rule__Atomic__Group_4__0 ) ) );
    public final void rule__Atomic__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:447:1: ( ( ( rule__Atomic__Group_0__0 ) ) | ( ( rule__Atomic__Group_1__0 ) ) | ( ( rule__Atomic__Group_2__0 ) ) | ( ( rule__Atomic__Group_3__0 ) ) | ( ( rule__Atomic__Group_4__0 ) ) )
            int alt7=5;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt7=1;
                }
                break;
            case RULE_INT:
                {
                alt7=2;
                }
                break;
            case RULE_STRING:
                {
                alt7=3;
                }
                break;
            case 17:
            case 18:
                {
                alt7=4;
                }
                break;
            case RULE_ID:
                {
                alt7=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:448:1: ( ( rule__Atomic__Group_0__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:448:1: ( ( rule__Atomic__Group_0__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:449:1: ( rule__Atomic__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getGroup_0()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:450:1: ( rule__Atomic__Group_0__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:450:2: rule__Atomic__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Atomic__Group_0__0_in_rule__Atomic__Alternatives902);
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
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:454:6: ( ( rule__Atomic__Group_1__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:454:6: ( ( rule__Atomic__Group_1__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:455:1: ( rule__Atomic__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getGroup_1()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:456:1: ( rule__Atomic__Group_1__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:456:2: rule__Atomic__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Atomic__Group_1__0_in_rule__Atomic__Alternatives920);
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
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:460:6: ( ( rule__Atomic__Group_2__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:460:6: ( ( rule__Atomic__Group_2__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:461:1: ( rule__Atomic__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getGroup_2()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:462:1: ( rule__Atomic__Group_2__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:462:2: rule__Atomic__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Atomic__Group_2__0_in_rule__Atomic__Alternatives938);
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
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:466:6: ( ( rule__Atomic__Group_3__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:466:6: ( ( rule__Atomic__Group_3__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:467:1: ( rule__Atomic__Group_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getGroup_3()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:468:1: ( rule__Atomic__Group_3__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:468:2: rule__Atomic__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Atomic__Group_3__0_in_rule__Atomic__Alternatives956);
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
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:472:6: ( ( rule__Atomic__Group_4__0 ) )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:472:6: ( ( rule__Atomic__Group_4__0 ) )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:473:1: ( rule__Atomic__Group_4__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getGroup_4()); 
                    }
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:474:1: ( rule__Atomic__Group_4__0 )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:474:2: rule__Atomic__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Atomic__Group_4__0_in_rule__Atomic__Alternatives974);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:483:1: rule__Atomic__ValueAlternatives_3_1_0 : ( ( 'true' ) | ( 'false' ) );
    public final void rule__Atomic__ValueAlternatives_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:487:1: ( ( 'true' ) | ( 'false' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==17) ) {
                alt8=1;
            }
            else if ( (LA8_0==18) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:488:1: ( 'true' )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:488:1: ( 'true' )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:489:1: 'true'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getValueTrueKeyword_3_1_0_0()); 
                    }
                    match(input,17,FOLLOW_17_in_rule__Atomic__ValueAlternatives_3_1_01008); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAtomicAccess().getValueTrueKeyword_3_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:496:6: ( 'false' )
                    {
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:496:6: ( 'false' )
                    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:497:1: 'false'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAtomicAccess().getValueFalseKeyword_3_1_0_1()); 
                    }
                    match(input,18,FOLLOW_18_in_rule__Atomic__ValueAlternatives_3_1_01028); if (state.failed) return ;
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:512:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:516:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:517:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
            {
            pushFollow(FOLLOW_rule__Variable__Group__0__Impl_in_rule__Variable__Group__01061);
            rule__Variable__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Variable__Group__1_in_rule__Variable__Group__01064);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:524:1: rule__Variable__Group__0__Impl : ( ( rule__Variable__NameAssignment_0 ) ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:528:1: ( ( ( rule__Variable__NameAssignment_0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:529:1: ( ( rule__Variable__NameAssignment_0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:529:1: ( ( rule__Variable__NameAssignment_0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:530:1: ( rule__Variable__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableAccess().getNameAssignment_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:531:1: ( rule__Variable__NameAssignment_0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:531:2: rule__Variable__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Variable__NameAssignment_0_in_rule__Variable__Group__0__Impl1091);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:541:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl rule__Variable__Group__2 ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:545:1: ( rule__Variable__Group__1__Impl rule__Variable__Group__2 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:546:2: rule__Variable__Group__1__Impl rule__Variable__Group__2
            {
            pushFollow(FOLLOW_rule__Variable__Group__1__Impl_in_rule__Variable__Group__11121);
            rule__Variable__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Variable__Group__2_in_rule__Variable__Group__11124);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:553:1: rule__Variable__Group__1__Impl : ( '=' ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:557:1: ( ( '=' ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:558:1: ( '=' )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:558:1: ( '=' )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:559:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableAccess().getEqualsSignKeyword_1()); 
            }
            match(input,19,FOLLOW_19_in_rule__Variable__Group__1__Impl1152); if (state.failed) return ;
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:572:1: rule__Variable__Group__2 : rule__Variable__Group__2__Impl ;
    public final void rule__Variable__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:576:1: ( rule__Variable__Group__2__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:577:2: rule__Variable__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Variable__Group__2__Impl_in_rule__Variable__Group__21183);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:583:1: rule__Variable__Group__2__Impl : ( ( rule__Variable__ExpressionAssignment_2 ) ) ;
    public final void rule__Variable__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:587:1: ( ( ( rule__Variable__ExpressionAssignment_2 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:588:1: ( ( rule__Variable__ExpressionAssignment_2 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:588:1: ( ( rule__Variable__ExpressionAssignment_2 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:589:1: ( rule__Variable__ExpressionAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableAccess().getExpressionAssignment_2()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:590:1: ( rule__Variable__ExpressionAssignment_2 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:590:2: rule__Variable__ExpressionAssignment_2
            {
            pushFollow(FOLLOW_rule__Variable__ExpressionAssignment_2_in_rule__Variable__Group__2__Impl1210);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:606:1: rule__BooleanExpression__Group__0 : rule__BooleanExpression__Group__0__Impl rule__BooleanExpression__Group__1 ;
    public final void rule__BooleanExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:610:1: ( rule__BooleanExpression__Group__0__Impl rule__BooleanExpression__Group__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:611:2: rule__BooleanExpression__Group__0__Impl rule__BooleanExpression__Group__1
            {
            pushFollow(FOLLOW_rule__BooleanExpression__Group__0__Impl_in_rule__BooleanExpression__Group__01246);
            rule__BooleanExpression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BooleanExpression__Group__1_in_rule__BooleanExpression__Group__01249);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:618:1: rule__BooleanExpression__Group__0__Impl : ( ruleComparison ) ;
    public final void rule__BooleanExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:622:1: ( ( ruleComparison ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:623:1: ( ruleComparison )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:623:1: ( ruleComparison )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:624:1: ruleComparison
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getComparisonParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleComparison_in_rule__BooleanExpression__Group__0__Impl1276);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:635:1: rule__BooleanExpression__Group__1 : rule__BooleanExpression__Group__1__Impl ;
    public final void rule__BooleanExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:639:1: ( rule__BooleanExpression__Group__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:640:2: rule__BooleanExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__BooleanExpression__Group__1__Impl_in_rule__BooleanExpression__Group__11305);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:646:1: rule__BooleanExpression__Group__1__Impl : ( ( rule__BooleanExpression__Group_1__0 )* ) ;
    public final void rule__BooleanExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:650:1: ( ( ( rule__BooleanExpression__Group_1__0 )* ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:651:1: ( ( rule__BooleanExpression__Group_1__0 )* )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:651:1: ( ( rule__BooleanExpression__Group_1__0 )* )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:652:1: ( rule__BooleanExpression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getGroup_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:653:1: ( rule__BooleanExpression__Group_1__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=11 && LA9_0<=12)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:653:2: rule__BooleanExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__BooleanExpression__Group_1__0_in_rule__BooleanExpression__Group__1__Impl1332);
            	    rule__BooleanExpression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop9;
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:667:1: rule__BooleanExpression__Group_1__0 : rule__BooleanExpression__Group_1__0__Impl rule__BooleanExpression__Group_1__1 ;
    public final void rule__BooleanExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:671:1: ( rule__BooleanExpression__Group_1__0__Impl rule__BooleanExpression__Group_1__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:672:2: rule__BooleanExpression__Group_1__0__Impl rule__BooleanExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__BooleanExpression__Group_1__0__Impl_in_rule__BooleanExpression__Group_1__01367);
            rule__BooleanExpression__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BooleanExpression__Group_1__1_in_rule__BooleanExpression__Group_1__01370);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:679:1: rule__BooleanExpression__Group_1__0__Impl : ( ( rule__BooleanExpression__Group_1_0__0 ) ) ;
    public final void rule__BooleanExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:683:1: ( ( ( rule__BooleanExpression__Group_1_0__0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:684:1: ( ( rule__BooleanExpression__Group_1_0__0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:684:1: ( ( rule__BooleanExpression__Group_1_0__0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:685:1: ( rule__BooleanExpression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getGroup_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:686:1: ( rule__BooleanExpression__Group_1_0__0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:686:2: rule__BooleanExpression__Group_1_0__0
            {
            pushFollow(FOLLOW_rule__BooleanExpression__Group_1_0__0_in_rule__BooleanExpression__Group_1__0__Impl1397);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:696:1: rule__BooleanExpression__Group_1__1 : rule__BooleanExpression__Group_1__1__Impl ;
    public final void rule__BooleanExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:700:1: ( rule__BooleanExpression__Group_1__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:701:2: rule__BooleanExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__BooleanExpression__Group_1__1__Impl_in_rule__BooleanExpression__Group_1__11427);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:707:1: rule__BooleanExpression__Group_1__1__Impl : ( ( rule__BooleanExpression__RightAssignment_1_1 ) ) ;
    public final void rule__BooleanExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:711:1: ( ( ( rule__BooleanExpression__RightAssignment_1_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:712:1: ( ( rule__BooleanExpression__RightAssignment_1_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:712:1: ( ( rule__BooleanExpression__RightAssignment_1_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:713:1: ( rule__BooleanExpression__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getRightAssignment_1_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:714:1: ( rule__BooleanExpression__RightAssignment_1_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:714:2: rule__BooleanExpression__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__BooleanExpression__RightAssignment_1_1_in_rule__BooleanExpression__Group_1__1__Impl1454);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:728:1: rule__BooleanExpression__Group_1_0__0 : rule__BooleanExpression__Group_1_0__0__Impl rule__BooleanExpression__Group_1_0__1 ;
    public final void rule__BooleanExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:732:1: ( rule__BooleanExpression__Group_1_0__0__Impl rule__BooleanExpression__Group_1_0__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:733:2: rule__BooleanExpression__Group_1_0__0__Impl rule__BooleanExpression__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__BooleanExpression__Group_1_0__0__Impl_in_rule__BooleanExpression__Group_1_0__01488);
            rule__BooleanExpression__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BooleanExpression__Group_1_0__1_in_rule__BooleanExpression__Group_1_0__01491);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:740:1: rule__BooleanExpression__Group_1_0__0__Impl : ( () ) ;
    public final void rule__BooleanExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:744:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:745:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:745:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:746:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getAndOrExpressionLeftAction_1_0_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:747:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:749:1: 
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:759:1: rule__BooleanExpression__Group_1_0__1 : rule__BooleanExpression__Group_1_0__1__Impl ;
    public final void rule__BooleanExpression__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:763:1: ( rule__BooleanExpression__Group_1_0__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:764:2: rule__BooleanExpression__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__BooleanExpression__Group_1_0__1__Impl_in_rule__BooleanExpression__Group_1_0__11549);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:770:1: rule__BooleanExpression__Group_1_0__1__Impl : ( ( rule__BooleanExpression__OpAssignment_1_0_1 ) ) ;
    public final void rule__BooleanExpression__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:774:1: ( ( ( rule__BooleanExpression__OpAssignment_1_0_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:775:1: ( ( rule__BooleanExpression__OpAssignment_1_0_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:775:1: ( ( rule__BooleanExpression__OpAssignment_1_0_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:776:1: ( rule__BooleanExpression__OpAssignment_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getOpAssignment_1_0_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:777:1: ( rule__BooleanExpression__OpAssignment_1_0_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:777:2: rule__BooleanExpression__OpAssignment_1_0_1
            {
            pushFollow(FOLLOW_rule__BooleanExpression__OpAssignment_1_0_1_in_rule__BooleanExpression__Group_1_0__1__Impl1576);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:791:1: rule__Comparison__Group__0 : rule__Comparison__Group__0__Impl rule__Comparison__Group__1 ;
    public final void rule__Comparison__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:795:1: ( rule__Comparison__Group__0__Impl rule__Comparison__Group__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:796:2: rule__Comparison__Group__0__Impl rule__Comparison__Group__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group__0__Impl_in_rule__Comparison__Group__01610);
            rule__Comparison__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Comparison__Group__1_in_rule__Comparison__Group__01613);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:803:1: rule__Comparison__Group__0__Impl : ( ruleAddition ) ;
    public final void rule__Comparison__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:807:1: ( ( ruleAddition ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:808:1: ( ruleAddition )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:808:1: ( ruleAddition )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:809:1: ruleAddition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getAdditionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleAddition_in_rule__Comparison__Group__0__Impl1640);
            ruleAddition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getAdditionParserRuleCall_0()); 
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:820:1: rule__Comparison__Group__1 : rule__Comparison__Group__1__Impl ;
    public final void rule__Comparison__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:824:1: ( rule__Comparison__Group__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:825:2: rule__Comparison__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group__1__Impl_in_rule__Comparison__Group__11669);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:831:1: rule__Comparison__Group__1__Impl : ( ( rule__Comparison__Group_1__0 )* ) ;
    public final void rule__Comparison__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:835:1: ( ( ( rule__Comparison__Group_1__0 )* ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:836:1: ( ( rule__Comparison__Group_1__0 )* )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:836:1: ( ( rule__Comparison__Group_1__0 )* )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:837:1: ( rule__Comparison__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getGroup_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:838:1: ( rule__Comparison__Group_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=13 && LA10_0<=14)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:838:2: rule__Comparison__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Comparison__Group_1__0_in_rule__Comparison__Group__1__Impl1696);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:852:1: rule__Comparison__Group_1__0 : rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1 ;
    public final void rule__Comparison__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:856:1: ( rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:857:2: rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1__0__Impl_in_rule__Comparison__Group_1__01731);
            rule__Comparison__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Comparison__Group_1__1_in_rule__Comparison__Group_1__01734);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:864:1: rule__Comparison__Group_1__0__Impl : ( ( rule__Comparison__Group_1_0__0 ) ) ;
    public final void rule__Comparison__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:868:1: ( ( ( rule__Comparison__Group_1_0__0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:869:1: ( ( rule__Comparison__Group_1_0__0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:869:1: ( ( rule__Comparison__Group_1_0__0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:870:1: ( rule__Comparison__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getGroup_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:871:1: ( rule__Comparison__Group_1_0__0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:871:2: rule__Comparison__Group_1_0__0
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0__0_in_rule__Comparison__Group_1__0__Impl1761);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:881:1: rule__Comparison__Group_1__1 : rule__Comparison__Group_1__1__Impl ;
    public final void rule__Comparison__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:885:1: ( rule__Comparison__Group_1__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:886:2: rule__Comparison__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1__1__Impl_in_rule__Comparison__Group_1__11791);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:892:1: rule__Comparison__Group_1__1__Impl : ( ( rule__Comparison__RightAssignment_1_1 ) ) ;
    public final void rule__Comparison__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:896:1: ( ( ( rule__Comparison__RightAssignment_1_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:897:1: ( ( rule__Comparison__RightAssignment_1_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:897:1: ( ( rule__Comparison__RightAssignment_1_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:898:1: ( rule__Comparison__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getRightAssignment_1_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:899:1: ( rule__Comparison__RightAssignment_1_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:899:2: rule__Comparison__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Comparison__RightAssignment_1_1_in_rule__Comparison__Group_1__1__Impl1818);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:913:1: rule__Comparison__Group_1_0__0 : rule__Comparison__Group_1_0__0__Impl rule__Comparison__Group_1_0__1 ;
    public final void rule__Comparison__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:917:1: ( rule__Comparison__Group_1_0__0__Impl rule__Comparison__Group_1_0__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:918:2: rule__Comparison__Group_1_0__0__Impl rule__Comparison__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0__0__Impl_in_rule__Comparison__Group_1_0__01852);
            rule__Comparison__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Comparison__Group_1_0__1_in_rule__Comparison__Group_1_0__01855);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:925:1: rule__Comparison__Group_1_0__0__Impl : ( () ) ;
    public final void rule__Comparison__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:929:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:930:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:930:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:931:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getComparisonLeftAction_1_0_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:932:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:934:1: 
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:944:1: rule__Comparison__Group_1_0__1 : rule__Comparison__Group_1_0__1__Impl ;
    public final void rule__Comparison__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:948:1: ( rule__Comparison__Group_1_0__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:949:2: rule__Comparison__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0__1__Impl_in_rule__Comparison__Group_1_0__11913);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:955:1: rule__Comparison__Group_1_0__1__Impl : ( ( rule__Comparison__OpAssignment_1_0_1 ) ) ;
    public final void rule__Comparison__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:959:1: ( ( ( rule__Comparison__OpAssignment_1_0_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:960:1: ( ( rule__Comparison__OpAssignment_1_0_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:960:1: ( ( rule__Comparison__OpAssignment_1_0_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:961:1: ( rule__Comparison__OpAssignment_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getOpAssignment_1_0_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:962:1: ( rule__Comparison__OpAssignment_1_0_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:962:2: rule__Comparison__OpAssignment_1_0_1
            {
            pushFollow(FOLLOW_rule__Comparison__OpAssignment_1_0_1_in_rule__Comparison__Group_1_0__1__Impl1940);
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


    // $ANTLR start "rule__Addition__Group__0"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:976:1: rule__Addition__Group__0 : rule__Addition__Group__0__Impl rule__Addition__Group__1 ;
    public final void rule__Addition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:980:1: ( rule__Addition__Group__0__Impl rule__Addition__Group__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:981:2: rule__Addition__Group__0__Impl rule__Addition__Group__1
            {
            pushFollow(FOLLOW_rule__Addition__Group__0__Impl_in_rule__Addition__Group__01974);
            rule__Addition__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Addition__Group__1_in_rule__Addition__Group__01977);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:988:1: rule__Addition__Group__0__Impl : ( ruleMultiplication ) ;
    public final void rule__Addition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:992:1: ( ( ruleMultiplication ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:993:1: ( ruleMultiplication )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:993:1: ( ruleMultiplication )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:994:1: ruleMultiplication
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleMultiplication_in_rule__Addition__Group__0__Impl2004);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1005:1: rule__Addition__Group__1 : rule__Addition__Group__1__Impl ;
    public final void rule__Addition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1009:1: ( rule__Addition__Group__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1010:2: rule__Addition__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Addition__Group__1__Impl_in_rule__Addition__Group__12033);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1016:1: rule__Addition__Group__1__Impl : ( ( rule__Addition__Group_1__0 )* ) ;
    public final void rule__Addition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1020:1: ( ( ( rule__Addition__Group_1__0 )* ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1021:1: ( ( rule__Addition__Group_1__0 )* )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1021:1: ( ( rule__Addition__Group_1__0 )* )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1022:1: ( rule__Addition__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getGroup_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1023:1: ( rule__Addition__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=20 && LA11_0<=21)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1023:2: rule__Addition__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Addition__Group_1__0_in_rule__Addition__Group__1__Impl2060);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1037:1: rule__Addition__Group_1__0 : rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1 ;
    public final void rule__Addition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1041:1: ( rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1042:2: rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1
            {
            pushFollow(FOLLOW_rule__Addition__Group_1__0__Impl_in_rule__Addition__Group_1__02095);
            rule__Addition__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Addition__Group_1__1_in_rule__Addition__Group_1__02098);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1049:1: rule__Addition__Group_1__0__Impl : ( ( rule__Addition__Alternatives_1_0 ) ) ;
    public final void rule__Addition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1053:1: ( ( ( rule__Addition__Alternatives_1_0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1054:1: ( ( rule__Addition__Alternatives_1_0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1054:1: ( ( rule__Addition__Alternatives_1_0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1055:1: ( rule__Addition__Alternatives_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getAlternatives_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1056:1: ( rule__Addition__Alternatives_1_0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1056:2: rule__Addition__Alternatives_1_0
            {
            pushFollow(FOLLOW_rule__Addition__Alternatives_1_0_in_rule__Addition__Group_1__0__Impl2125);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1066:1: rule__Addition__Group_1__1 : rule__Addition__Group_1__1__Impl ;
    public final void rule__Addition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1070:1: ( rule__Addition__Group_1__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1071:2: rule__Addition__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Addition__Group_1__1__Impl_in_rule__Addition__Group_1__12155);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1077:1: rule__Addition__Group_1__1__Impl : ( ( rule__Addition__RightAssignment_1_1 ) ) ;
    public final void rule__Addition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1081:1: ( ( ( rule__Addition__RightAssignment_1_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1082:1: ( ( rule__Addition__RightAssignment_1_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1082:1: ( ( rule__Addition__RightAssignment_1_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1083:1: ( rule__Addition__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getRightAssignment_1_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1084:1: ( rule__Addition__RightAssignment_1_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1084:2: rule__Addition__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Addition__RightAssignment_1_1_in_rule__Addition__Group_1__1__Impl2182);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1098:1: rule__Addition__Group_1_0_0__0 : rule__Addition__Group_1_0_0__0__Impl rule__Addition__Group_1_0_0__1 ;
    public final void rule__Addition__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1102:1: ( rule__Addition__Group_1_0_0__0__Impl rule__Addition__Group_1_0_0__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1103:2: rule__Addition__Group_1_0_0__0__Impl rule__Addition__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__Addition__Group_1_0_0__0__Impl_in_rule__Addition__Group_1_0_0__02216);
            rule__Addition__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Addition__Group_1_0_0__1_in_rule__Addition__Group_1_0_0__02219);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1110:1: rule__Addition__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Addition__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1114:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1115:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1115:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1116:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1117:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1119:1: 
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1129:1: rule__Addition__Group_1_0_0__1 : rule__Addition__Group_1_0_0__1__Impl ;
    public final void rule__Addition__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1133:1: ( rule__Addition__Group_1_0_0__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1134:2: rule__Addition__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Addition__Group_1_0_0__1__Impl_in_rule__Addition__Group_1_0_0__12277);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1140:1: rule__Addition__Group_1_0_0__1__Impl : ( '+' ) ;
    public final void rule__Addition__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1144:1: ( ( '+' ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1145:1: ( '+' )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1145:1: ( '+' )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1146:1: '+'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1()); 
            }
            match(input,20,FOLLOW_20_in_rule__Addition__Group_1_0_0__1__Impl2305); if (state.failed) return ;
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1163:1: rule__Addition__Group_1_0_1__0 : rule__Addition__Group_1_0_1__0__Impl rule__Addition__Group_1_0_1__1 ;
    public final void rule__Addition__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1167:1: ( rule__Addition__Group_1_0_1__0__Impl rule__Addition__Group_1_0_1__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1168:2: rule__Addition__Group_1_0_1__0__Impl rule__Addition__Group_1_0_1__1
            {
            pushFollow(FOLLOW_rule__Addition__Group_1_0_1__0__Impl_in_rule__Addition__Group_1_0_1__02340);
            rule__Addition__Group_1_0_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Addition__Group_1_0_1__1_in_rule__Addition__Group_1_0_1__02343);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1175:1: rule__Addition__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Addition__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1179:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1180:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1180:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1181:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1182:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1184:1: 
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1194:1: rule__Addition__Group_1_0_1__1 : rule__Addition__Group_1_0_1__1__Impl ;
    public final void rule__Addition__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1198:1: ( rule__Addition__Group_1_0_1__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1199:2: rule__Addition__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Addition__Group_1_0_1__1__Impl_in_rule__Addition__Group_1_0_1__12401);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1205:1: rule__Addition__Group_1_0_1__1__Impl : ( '-' ) ;
    public final void rule__Addition__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1209:1: ( ( '-' ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1210:1: ( '-' )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1210:1: ( '-' )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1211:1: '-'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1()); 
            }
            match(input,21,FOLLOW_21_in_rule__Addition__Group_1_0_1__1__Impl2429); if (state.failed) return ;
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1228:1: rule__Multiplication__Group__0 : rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1 ;
    public final void rule__Multiplication__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1232:1: ( rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1233:2: rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1
            {
            pushFollow(FOLLOW_rule__Multiplication__Group__0__Impl_in_rule__Multiplication__Group__02464);
            rule__Multiplication__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Multiplication__Group__1_in_rule__Multiplication__Group__02467);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1240:1: rule__Multiplication__Group__0__Impl : ( rulePrefixed ) ;
    public final void rule__Multiplication__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1244:1: ( ( rulePrefixed ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1245:1: ( rulePrefixed )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1245:1: ( rulePrefixed )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1246:1: rulePrefixed
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getPrefixedParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_rulePrefixed_in_rule__Multiplication__Group__0__Impl2494);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1257:1: rule__Multiplication__Group__1 : rule__Multiplication__Group__1__Impl ;
    public final void rule__Multiplication__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1261:1: ( rule__Multiplication__Group__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1262:2: rule__Multiplication__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Multiplication__Group__1__Impl_in_rule__Multiplication__Group__12523);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1268:1: rule__Multiplication__Group__1__Impl : ( ( rule__Multiplication__Group_1__0 )* ) ;
    public final void rule__Multiplication__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1272:1: ( ( ( rule__Multiplication__Group_1__0 )* ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1273:1: ( ( rule__Multiplication__Group_1__0 )* )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1273:1: ( ( rule__Multiplication__Group_1__0 )* )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1274:1: ( rule__Multiplication__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getGroup_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1275:1: ( rule__Multiplication__Group_1__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=15 && LA12_0<=16)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1275:2: rule__Multiplication__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Multiplication__Group_1__0_in_rule__Multiplication__Group__1__Impl2550);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1289:1: rule__Multiplication__Group_1__0 : rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1 ;
    public final void rule__Multiplication__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1293:1: ( rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1294:2: rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1__0__Impl_in_rule__Multiplication__Group_1__02585);
            rule__Multiplication__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Multiplication__Group_1__1_in_rule__Multiplication__Group_1__02588);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1301:1: rule__Multiplication__Group_1__0__Impl : ( ( rule__Multiplication__Group_1_0__0 ) ) ;
    public final void rule__Multiplication__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1305:1: ( ( ( rule__Multiplication__Group_1_0__0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1306:1: ( ( rule__Multiplication__Group_1_0__0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1306:1: ( ( rule__Multiplication__Group_1_0__0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1307:1: ( rule__Multiplication__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getGroup_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1308:1: ( rule__Multiplication__Group_1_0__0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1308:2: rule__Multiplication__Group_1_0__0
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0__0_in_rule__Multiplication__Group_1__0__Impl2615);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1318:1: rule__Multiplication__Group_1__1 : rule__Multiplication__Group_1__1__Impl ;
    public final void rule__Multiplication__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1322:1: ( rule__Multiplication__Group_1__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1323:2: rule__Multiplication__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1__1__Impl_in_rule__Multiplication__Group_1__12645);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1329:1: rule__Multiplication__Group_1__1__Impl : ( ( rule__Multiplication__RightAssignment_1_1 ) ) ;
    public final void rule__Multiplication__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1333:1: ( ( ( rule__Multiplication__RightAssignment_1_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1334:1: ( ( rule__Multiplication__RightAssignment_1_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1334:1: ( ( rule__Multiplication__RightAssignment_1_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1335:1: ( rule__Multiplication__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getRightAssignment_1_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1336:1: ( rule__Multiplication__RightAssignment_1_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1336:2: rule__Multiplication__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Multiplication__RightAssignment_1_1_in_rule__Multiplication__Group_1__1__Impl2672);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1350:1: rule__Multiplication__Group_1_0__0 : rule__Multiplication__Group_1_0__0__Impl rule__Multiplication__Group_1_0__1 ;
    public final void rule__Multiplication__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1354:1: ( rule__Multiplication__Group_1_0__0__Impl rule__Multiplication__Group_1_0__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1355:2: rule__Multiplication__Group_1_0__0__Impl rule__Multiplication__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0__0__Impl_in_rule__Multiplication__Group_1_0__02706);
            rule__Multiplication__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0__1_in_rule__Multiplication__Group_1_0__02709);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1362:1: rule__Multiplication__Group_1_0__0__Impl : ( () ) ;
    public final void rule__Multiplication__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1366:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1367:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1367:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1368:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getMultiOrDivLeftAction_1_0_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1369:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1371:1: 
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1381:1: rule__Multiplication__Group_1_0__1 : rule__Multiplication__Group_1_0__1__Impl ;
    public final void rule__Multiplication__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1385:1: ( rule__Multiplication__Group_1_0__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1386:2: rule__Multiplication__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0__1__Impl_in_rule__Multiplication__Group_1_0__12767);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1392:1: rule__Multiplication__Group_1_0__1__Impl : ( ( rule__Multiplication__OpAssignment_1_0_1 ) ) ;
    public final void rule__Multiplication__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1396:1: ( ( ( rule__Multiplication__OpAssignment_1_0_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1397:1: ( ( rule__Multiplication__OpAssignment_1_0_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1397:1: ( ( rule__Multiplication__OpAssignment_1_0_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1398:1: ( rule__Multiplication__OpAssignment_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getOpAssignment_1_0_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1399:1: ( rule__Multiplication__OpAssignment_1_0_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1399:2: rule__Multiplication__OpAssignment_1_0_1
            {
            pushFollow(FOLLOW_rule__Multiplication__OpAssignment_1_0_1_in_rule__Multiplication__Group_1_0__1__Impl2794);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1413:1: rule__Prefixed__Group_0__0 : rule__Prefixed__Group_0__0__Impl rule__Prefixed__Group_0__1 ;
    public final void rule__Prefixed__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1417:1: ( rule__Prefixed__Group_0__0__Impl rule__Prefixed__Group_0__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1418:2: rule__Prefixed__Group_0__0__Impl rule__Prefixed__Group_0__1
            {
            pushFollow(FOLLOW_rule__Prefixed__Group_0__0__Impl_in_rule__Prefixed__Group_0__02828);
            rule__Prefixed__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Prefixed__Group_0__1_in_rule__Prefixed__Group_0__02831);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1425:1: rule__Prefixed__Group_0__0__Impl : ( () ) ;
    public final void rule__Prefixed__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1429:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1430:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1430:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1431:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getBooleanNegationAction_0_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1432:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1434:1: 
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1444:1: rule__Prefixed__Group_0__1 : rule__Prefixed__Group_0__1__Impl rule__Prefixed__Group_0__2 ;
    public final void rule__Prefixed__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1448:1: ( rule__Prefixed__Group_0__1__Impl rule__Prefixed__Group_0__2 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1449:2: rule__Prefixed__Group_0__1__Impl rule__Prefixed__Group_0__2
            {
            pushFollow(FOLLOW_rule__Prefixed__Group_0__1__Impl_in_rule__Prefixed__Group_0__12889);
            rule__Prefixed__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Prefixed__Group_0__2_in_rule__Prefixed__Group_0__12892);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1456:1: rule__Prefixed__Group_0__1__Impl : ( ( '!' ) ) ;
    public final void rule__Prefixed__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1460:1: ( ( ( '!' ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1461:1: ( ( '!' ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1461:1: ( ( '!' ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1462:1: ( '!' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getExclamationMarkKeyword_0_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1463:1: ( '!' )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1464:2: '!'
            {
            match(input,22,FOLLOW_22_in_rule__Prefixed__Group_0__1__Impl2921); if (state.failed) return ;

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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1475:1: rule__Prefixed__Group_0__2 : rule__Prefixed__Group_0__2__Impl ;
    public final void rule__Prefixed__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1479:1: ( rule__Prefixed__Group_0__2__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1480:2: rule__Prefixed__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__Prefixed__Group_0__2__Impl_in_rule__Prefixed__Group_0__22953);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1486:1: rule__Prefixed__Group_0__2__Impl : ( ( rule__Prefixed__ExpressionAssignment_0_2 ) ) ;
    public final void rule__Prefixed__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1490:1: ( ( ( rule__Prefixed__ExpressionAssignment_0_2 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1491:1: ( ( rule__Prefixed__ExpressionAssignment_0_2 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1491:1: ( ( rule__Prefixed__ExpressionAssignment_0_2 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1492:1: ( rule__Prefixed__ExpressionAssignment_0_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getExpressionAssignment_0_2()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1493:1: ( rule__Prefixed__ExpressionAssignment_0_2 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1493:2: rule__Prefixed__ExpressionAssignment_0_2
            {
            pushFollow(FOLLOW_rule__Prefixed__ExpressionAssignment_0_2_in_rule__Prefixed__Group_0__2__Impl2980);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1509:1: rule__Prefixed__Group_1__0 : rule__Prefixed__Group_1__0__Impl rule__Prefixed__Group_1__1 ;
    public final void rule__Prefixed__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1513:1: ( rule__Prefixed__Group_1__0__Impl rule__Prefixed__Group_1__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1514:2: rule__Prefixed__Group_1__0__Impl rule__Prefixed__Group_1__1
            {
            pushFollow(FOLLOW_rule__Prefixed__Group_1__0__Impl_in_rule__Prefixed__Group_1__03016);
            rule__Prefixed__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Prefixed__Group_1__1_in_rule__Prefixed__Group_1__03019);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1521:1: rule__Prefixed__Group_1__0__Impl : ( () ) ;
    public final void rule__Prefixed__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1525:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1526:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1526:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1527:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getArithmeticSignedAction_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1528:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1530:1: 
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1540:1: rule__Prefixed__Group_1__1 : rule__Prefixed__Group_1__1__Impl rule__Prefixed__Group_1__2 ;
    public final void rule__Prefixed__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1544:1: ( rule__Prefixed__Group_1__1__Impl rule__Prefixed__Group_1__2 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1545:2: rule__Prefixed__Group_1__1__Impl rule__Prefixed__Group_1__2
            {
            pushFollow(FOLLOW_rule__Prefixed__Group_1__1__Impl_in_rule__Prefixed__Group_1__13077);
            rule__Prefixed__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Prefixed__Group_1__2_in_rule__Prefixed__Group_1__13080);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1552:1: rule__Prefixed__Group_1__1__Impl : ( ( '-' ) ) ;
    public final void rule__Prefixed__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1556:1: ( ( ( '-' ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1557:1: ( ( '-' ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1557:1: ( ( '-' ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1558:1: ( '-' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getHyphenMinusKeyword_1_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1559:1: ( '-' )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1560:2: '-'
            {
            match(input,21,FOLLOW_21_in_rule__Prefixed__Group_1__1__Impl3109); if (state.failed) return ;

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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1571:1: rule__Prefixed__Group_1__2 : rule__Prefixed__Group_1__2__Impl ;
    public final void rule__Prefixed__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1575:1: ( rule__Prefixed__Group_1__2__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1576:2: rule__Prefixed__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Prefixed__Group_1__2__Impl_in_rule__Prefixed__Group_1__23141);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1582:1: rule__Prefixed__Group_1__2__Impl : ( ( rule__Prefixed__ExpressionAssignment_1_2 ) ) ;
    public final void rule__Prefixed__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1586:1: ( ( ( rule__Prefixed__ExpressionAssignment_1_2 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1587:1: ( ( rule__Prefixed__ExpressionAssignment_1_2 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1587:1: ( ( rule__Prefixed__ExpressionAssignment_1_2 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1588:1: ( rule__Prefixed__ExpressionAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getExpressionAssignment_1_2()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1589:1: ( rule__Prefixed__ExpressionAssignment_1_2 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1589:2: rule__Prefixed__ExpressionAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Prefixed__ExpressionAssignment_1_2_in_rule__Prefixed__Group_1__2__Impl3168);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1605:1: rule__Atomic__Group_0__0 : rule__Atomic__Group_0__0__Impl rule__Atomic__Group_0__1 ;
    public final void rule__Atomic__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1609:1: ( rule__Atomic__Group_0__0__Impl rule__Atomic__Group_0__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1610:2: rule__Atomic__Group_0__0__Impl rule__Atomic__Group_0__1
            {
            pushFollow(FOLLOW_rule__Atomic__Group_0__0__Impl_in_rule__Atomic__Group_0__03204);
            rule__Atomic__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Atomic__Group_0__1_in_rule__Atomic__Group_0__03207);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1617:1: rule__Atomic__Group_0__0__Impl : ( '(' ) ;
    public final void rule__Atomic__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1621:1: ( ( '(' ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1622:1: ( '(' )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1622:1: ( '(' )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1623:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getLeftParenthesisKeyword_0_0()); 
            }
            match(input,23,FOLLOW_23_in_rule__Atomic__Group_0__0__Impl3235); if (state.failed) return ;
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1636:1: rule__Atomic__Group_0__1 : rule__Atomic__Group_0__1__Impl rule__Atomic__Group_0__2 ;
    public final void rule__Atomic__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1640:1: ( rule__Atomic__Group_0__1__Impl rule__Atomic__Group_0__2 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1641:2: rule__Atomic__Group_0__1__Impl rule__Atomic__Group_0__2
            {
            pushFollow(FOLLOW_rule__Atomic__Group_0__1__Impl_in_rule__Atomic__Group_0__13266);
            rule__Atomic__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Atomic__Group_0__2_in_rule__Atomic__Group_0__13269);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1648:1: rule__Atomic__Group_0__1__Impl : ( ruleExpression ) ;
    public final void rule__Atomic__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1652:1: ( ( ruleExpression ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1653:1: ( ruleExpression )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1653:1: ( ruleExpression )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1654:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getExpressionParserRuleCall_0_1()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_rule__Atomic__Group_0__1__Impl3296);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1665:1: rule__Atomic__Group_0__2 : rule__Atomic__Group_0__2__Impl ;
    public final void rule__Atomic__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1669:1: ( rule__Atomic__Group_0__2__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1670:2: rule__Atomic__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__Atomic__Group_0__2__Impl_in_rule__Atomic__Group_0__23325);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1676:1: rule__Atomic__Group_0__2__Impl : ( ')' ) ;
    public final void rule__Atomic__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1680:1: ( ( ')' ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1681:1: ( ')' )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1681:1: ( ')' )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1682:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getRightParenthesisKeyword_0_2()); 
            }
            match(input,24,FOLLOW_24_in_rule__Atomic__Group_0__2__Impl3353); if (state.failed) return ;
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1701:1: rule__Atomic__Group_1__0 : rule__Atomic__Group_1__0__Impl rule__Atomic__Group_1__1 ;
    public final void rule__Atomic__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1705:1: ( rule__Atomic__Group_1__0__Impl rule__Atomic__Group_1__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1706:2: rule__Atomic__Group_1__0__Impl rule__Atomic__Group_1__1
            {
            pushFollow(FOLLOW_rule__Atomic__Group_1__0__Impl_in_rule__Atomic__Group_1__03390);
            rule__Atomic__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Atomic__Group_1__1_in_rule__Atomic__Group_1__03393);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1713:1: rule__Atomic__Group_1__0__Impl : ( () ) ;
    public final void rule__Atomic__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1717:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1718:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1718:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1719:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getNumberLiteralAction_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1720:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1722:1: 
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1732:1: rule__Atomic__Group_1__1 : rule__Atomic__Group_1__1__Impl ;
    public final void rule__Atomic__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1736:1: ( rule__Atomic__Group_1__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1737:2: rule__Atomic__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Atomic__Group_1__1__Impl_in_rule__Atomic__Group_1__13451);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1743:1: rule__Atomic__Group_1__1__Impl : ( ( rule__Atomic__ValueAssignment_1_1 ) ) ;
    public final void rule__Atomic__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1747:1: ( ( ( rule__Atomic__ValueAssignment_1_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1748:1: ( ( rule__Atomic__ValueAssignment_1_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1748:1: ( ( rule__Atomic__ValueAssignment_1_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1749:1: ( rule__Atomic__ValueAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getValueAssignment_1_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1750:1: ( rule__Atomic__ValueAssignment_1_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1750:2: rule__Atomic__ValueAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Atomic__ValueAssignment_1_1_in_rule__Atomic__Group_1__1__Impl3478);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1764:1: rule__Atomic__Group_2__0 : rule__Atomic__Group_2__0__Impl rule__Atomic__Group_2__1 ;
    public final void rule__Atomic__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1768:1: ( rule__Atomic__Group_2__0__Impl rule__Atomic__Group_2__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1769:2: rule__Atomic__Group_2__0__Impl rule__Atomic__Group_2__1
            {
            pushFollow(FOLLOW_rule__Atomic__Group_2__0__Impl_in_rule__Atomic__Group_2__03512);
            rule__Atomic__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Atomic__Group_2__1_in_rule__Atomic__Group_2__03515);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1776:1: rule__Atomic__Group_2__0__Impl : ( () ) ;
    public final void rule__Atomic__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1780:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1781:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1781:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1782:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getStringLiteralAction_2_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1783:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1785:1: 
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1795:1: rule__Atomic__Group_2__1 : rule__Atomic__Group_2__1__Impl ;
    public final void rule__Atomic__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1799:1: ( rule__Atomic__Group_2__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1800:2: rule__Atomic__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Atomic__Group_2__1__Impl_in_rule__Atomic__Group_2__13573);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1806:1: rule__Atomic__Group_2__1__Impl : ( ( rule__Atomic__ValueAssignment_2_1 ) ) ;
    public final void rule__Atomic__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1810:1: ( ( ( rule__Atomic__ValueAssignment_2_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1811:1: ( ( rule__Atomic__ValueAssignment_2_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1811:1: ( ( rule__Atomic__ValueAssignment_2_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1812:1: ( rule__Atomic__ValueAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getValueAssignment_2_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1813:1: ( rule__Atomic__ValueAssignment_2_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1813:2: rule__Atomic__ValueAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Atomic__ValueAssignment_2_1_in_rule__Atomic__Group_2__1__Impl3600);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1827:1: rule__Atomic__Group_3__0 : rule__Atomic__Group_3__0__Impl rule__Atomic__Group_3__1 ;
    public final void rule__Atomic__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1831:1: ( rule__Atomic__Group_3__0__Impl rule__Atomic__Group_3__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1832:2: rule__Atomic__Group_3__0__Impl rule__Atomic__Group_3__1
            {
            pushFollow(FOLLOW_rule__Atomic__Group_3__0__Impl_in_rule__Atomic__Group_3__03634);
            rule__Atomic__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Atomic__Group_3__1_in_rule__Atomic__Group_3__03637);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1839:1: rule__Atomic__Group_3__0__Impl : ( () ) ;
    public final void rule__Atomic__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1843:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1844:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1844:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1845:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getBooleanLiteralAction_3_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1846:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1848:1: 
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1858:1: rule__Atomic__Group_3__1 : rule__Atomic__Group_3__1__Impl ;
    public final void rule__Atomic__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1862:1: ( rule__Atomic__Group_3__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1863:2: rule__Atomic__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Atomic__Group_3__1__Impl_in_rule__Atomic__Group_3__13695);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1869:1: rule__Atomic__Group_3__1__Impl : ( ( rule__Atomic__ValueAssignment_3_1 ) ) ;
    public final void rule__Atomic__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1873:1: ( ( ( rule__Atomic__ValueAssignment_3_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1874:1: ( ( rule__Atomic__ValueAssignment_3_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1874:1: ( ( rule__Atomic__ValueAssignment_3_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1875:1: ( rule__Atomic__ValueAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getValueAssignment_3_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1876:1: ( rule__Atomic__ValueAssignment_3_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1876:2: rule__Atomic__ValueAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Atomic__ValueAssignment_3_1_in_rule__Atomic__Group_3__1__Impl3722);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1890:1: rule__Atomic__Group_4__0 : rule__Atomic__Group_4__0__Impl rule__Atomic__Group_4__1 ;
    public final void rule__Atomic__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1894:1: ( rule__Atomic__Group_4__0__Impl rule__Atomic__Group_4__1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1895:2: rule__Atomic__Group_4__0__Impl rule__Atomic__Group_4__1
            {
            pushFollow(FOLLOW_rule__Atomic__Group_4__0__Impl_in_rule__Atomic__Group_4__03756);
            rule__Atomic__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Atomic__Group_4__1_in_rule__Atomic__Group_4__03759);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1902:1: rule__Atomic__Group_4__0__Impl : ( () ) ;
    public final void rule__Atomic__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1906:1: ( ( () ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1907:1: ( () )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1907:1: ( () )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1908:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getVariableReferenceAction_4_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1909:1: ()
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1911:1: 
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1921:1: rule__Atomic__Group_4__1 : rule__Atomic__Group_4__1__Impl ;
    public final void rule__Atomic__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1925:1: ( rule__Atomic__Group_4__1__Impl )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1926:2: rule__Atomic__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Atomic__Group_4__1__Impl_in_rule__Atomic__Group_4__13817);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1932:1: rule__Atomic__Group_4__1__Impl : ( ( rule__Atomic__RefAssignment_4_1 ) ) ;
    public final void rule__Atomic__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1936:1: ( ( ( rule__Atomic__RefAssignment_4_1 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1937:1: ( ( rule__Atomic__RefAssignment_4_1 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1937:1: ( ( rule__Atomic__RefAssignment_4_1 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1938:1: ( rule__Atomic__RefAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getRefAssignment_4_1()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1939:1: ( rule__Atomic__RefAssignment_4_1 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1939:2: rule__Atomic__RefAssignment_4_1
            {
            pushFollow(FOLLOW_rule__Atomic__RefAssignment_4_1_in_rule__Atomic__Group_4__1__Impl3844);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1957:1: rule__Model__VariablesAssignment : ( ruleVariable ) ;
    public final void rule__Model__VariablesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1961:1: ( ( ruleVariable ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1962:1: ( ruleVariable )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1962:1: ( ruleVariable )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1963:1: ruleVariable
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getVariablesVariableParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleVariable_in_rule__Model__VariablesAssignment3886);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1972:1: rule__Variable__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Variable__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1976:1: ( ( RULE_ID ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1977:1: ( RULE_ID )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1977:1: ( RULE_ID )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1978:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Variable__NameAssignment_03917); if (state.failed) return ;
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1987:1: rule__Variable__ExpressionAssignment_2 : ( ruleExpression ) ;
    public final void rule__Variable__ExpressionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1991:1: ( ( ruleExpression ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1992:1: ( ruleExpression )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1992:1: ( ruleExpression )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1993:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableAccess().getExpressionExpressionParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_rule__Variable__ExpressionAssignment_23948);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2002:1: rule__BooleanExpression__OpAssignment_1_0_1 : ( ( rule__BooleanExpression__OpAlternatives_1_0_1_0 ) ) ;
    public final void rule__BooleanExpression__OpAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2006:1: ( ( ( rule__BooleanExpression__OpAlternatives_1_0_1_0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2007:1: ( ( rule__BooleanExpression__OpAlternatives_1_0_1_0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2007:1: ( ( rule__BooleanExpression__OpAlternatives_1_0_1_0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2008:1: ( rule__BooleanExpression__OpAlternatives_1_0_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getOpAlternatives_1_0_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2009:1: ( rule__BooleanExpression__OpAlternatives_1_0_1_0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2009:2: rule__BooleanExpression__OpAlternatives_1_0_1_0
            {
            pushFollow(FOLLOW_rule__BooleanExpression__OpAlternatives_1_0_1_0_in_rule__BooleanExpression__OpAssignment_1_0_13979);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2018:1: rule__BooleanExpression__RightAssignment_1_1 : ( ruleComparison ) ;
    public final void rule__BooleanExpression__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2022:1: ( ( ruleComparison ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2023:1: ( ruleComparison )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2023:1: ( ruleComparison )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2024:1: ruleComparison
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanExpressionAccess().getRightComparisonParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleComparison_in_rule__BooleanExpression__RightAssignment_1_14012);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2033:1: rule__Comparison__OpAssignment_1_0_1 : ( ( rule__Comparison__OpAlternatives_1_0_1_0 ) ) ;
    public final void rule__Comparison__OpAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2037:1: ( ( ( rule__Comparison__OpAlternatives_1_0_1_0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2038:1: ( ( rule__Comparison__OpAlternatives_1_0_1_0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2038:1: ( ( rule__Comparison__OpAlternatives_1_0_1_0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2039:1: ( rule__Comparison__OpAlternatives_1_0_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getOpAlternatives_1_0_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2040:1: ( rule__Comparison__OpAlternatives_1_0_1_0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2040:2: rule__Comparison__OpAlternatives_1_0_1_0
            {
            pushFollow(FOLLOW_rule__Comparison__OpAlternatives_1_0_1_0_in_rule__Comparison__OpAssignment_1_0_14043);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2049:1: rule__Comparison__RightAssignment_1_1 : ( ruleAddition ) ;
    public final void rule__Comparison__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2053:1: ( ( ruleAddition ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2054:1: ( ruleAddition )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2054:1: ( ruleAddition )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2055:1: ruleAddition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getComparisonAccess().getRightAdditionParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleAddition_in_rule__Comparison__RightAssignment_1_14076);
            ruleAddition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getComparisonAccess().getRightAdditionParserRuleCall_1_1_0()); 
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


    // $ANTLR start "rule__Addition__RightAssignment_1_1"
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2064:1: rule__Addition__RightAssignment_1_1 : ( ruleMultiplication ) ;
    public final void rule__Addition__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2068:1: ( ( ruleMultiplication ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2069:1: ( ruleMultiplication )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2069:1: ( ruleMultiplication )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2070:1: ruleMultiplication
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleMultiplication_in_rule__Addition__RightAssignment_1_14107);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2079:1: rule__Multiplication__OpAssignment_1_0_1 : ( ( rule__Multiplication__OpAlternatives_1_0_1_0 ) ) ;
    public final void rule__Multiplication__OpAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2083:1: ( ( ( rule__Multiplication__OpAlternatives_1_0_1_0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2084:1: ( ( rule__Multiplication__OpAlternatives_1_0_1_0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2084:1: ( ( rule__Multiplication__OpAlternatives_1_0_1_0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2085:1: ( rule__Multiplication__OpAlternatives_1_0_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getOpAlternatives_1_0_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2086:1: ( rule__Multiplication__OpAlternatives_1_0_1_0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2086:2: rule__Multiplication__OpAlternatives_1_0_1_0
            {
            pushFollow(FOLLOW_rule__Multiplication__OpAlternatives_1_0_1_0_in_rule__Multiplication__OpAssignment_1_0_14138);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2095:1: rule__Multiplication__RightAssignment_1_1 : ( rulePrefixed ) ;
    public final void rule__Multiplication__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2099:1: ( ( rulePrefixed ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2100:1: ( rulePrefixed )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2100:1: ( rulePrefixed )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2101:1: rulePrefixed
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicationAccess().getRightPrefixedParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_rulePrefixed_in_rule__Multiplication__RightAssignment_1_14171);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2110:1: rule__Prefixed__ExpressionAssignment_0_2 : ( ruleAtomic ) ;
    public final void rule__Prefixed__ExpressionAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2114:1: ( ( ruleAtomic ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2115:1: ( ruleAtomic )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2115:1: ( ruleAtomic )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2116:1: ruleAtomic
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getExpressionAtomicParserRuleCall_0_2_0()); 
            }
            pushFollow(FOLLOW_ruleAtomic_in_rule__Prefixed__ExpressionAssignment_0_24202);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2125:1: rule__Prefixed__ExpressionAssignment_1_2 : ( ruleAtomic ) ;
    public final void rule__Prefixed__ExpressionAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2129:1: ( ( ruleAtomic ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2130:1: ( ruleAtomic )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2130:1: ( ruleAtomic )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2131:1: ruleAtomic
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixedAccess().getExpressionAtomicParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleAtomic_in_rule__Prefixed__ExpressionAssignment_1_24233);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2140:1: rule__Atomic__ValueAssignment_1_1 : ( RULE_INT ) ;
    public final void rule__Atomic__ValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2144:1: ( ( RULE_INT ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2145:1: ( RULE_INT )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2145:1: ( RULE_INT )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2146:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getValueINTTerminalRuleCall_1_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Atomic__ValueAssignment_1_14264); if (state.failed) return ;
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2155:1: rule__Atomic__ValueAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__Atomic__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2159:1: ( ( RULE_STRING ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2160:1: ( RULE_STRING )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2160:1: ( RULE_STRING )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2161:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getValueSTRINGTerminalRuleCall_2_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Atomic__ValueAssignment_2_14295); if (state.failed) return ;
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2170:1: rule__Atomic__ValueAssignment_3_1 : ( ( rule__Atomic__ValueAlternatives_3_1_0 ) ) ;
    public final void rule__Atomic__ValueAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2174:1: ( ( ( rule__Atomic__ValueAlternatives_3_1_0 ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2175:1: ( ( rule__Atomic__ValueAlternatives_3_1_0 ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2175:1: ( ( rule__Atomic__ValueAlternatives_3_1_0 ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2176:1: ( rule__Atomic__ValueAlternatives_3_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getValueAlternatives_3_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2177:1: ( rule__Atomic__ValueAlternatives_3_1_0 )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2177:2: rule__Atomic__ValueAlternatives_3_1_0
            {
            pushFollow(FOLLOW_rule__Atomic__ValueAlternatives_3_1_0_in_rule__Atomic__ValueAssignment_3_14326);
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
    // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2186:1: rule__Atomic__RefAssignment_4_1 : ( ( RULE_ID ) ) ;
    public final void rule__Atomic__RefAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2190:1: ( ( ( RULE_ID ) ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2191:1: ( ( RULE_ID ) )
            {
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2191:1: ( ( RULE_ID ) )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2192:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getRefVariableCrossReference_4_1_0()); 
            }
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2193:1: ( RULE_ID )
            // ../it.xsemantics.example.expressions.ui/src-gen/it/xsemantics/example/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:2194:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAtomicAccess().getRefVariableIDTerminalRuleCall_4_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Atomic__RefAssignment_4_14363); if (state.failed) return ;
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
    public static final BitSet FOLLOW_ruleAddition_in_entryRuleAddition367 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddition374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group__0_in_ruleAddition400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_entryRuleMultiplication427 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group__0_in_ruleMultiplication460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrefixed_in_entryRulePrefixed487 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrefixed494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Prefixed__Alternatives_in_rulePrefixed520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomic_in_entryRuleAtomic547 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtomic554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Alternatives_in_ruleAtomic580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__BooleanExpression__OpAlternatives_1_0_1_0619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__BooleanExpression__OpAlternatives_1_0_1_0639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Comparison__OpAlternatives_1_0_1_0674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Comparison__OpAlternatives_1_0_1_0694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_0__0_in_rule__Addition__Alternatives_1_0728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_1__0_in_rule__Addition__Alternatives_1_0746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Multiplication__OpAlternatives_1_0_1_0780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Multiplication__OpAlternatives_1_0_1_0800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Prefixed__Group_0__0_in_rule__Prefixed__Alternatives834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Prefixed__Group_1__0_in_rule__Prefixed__Alternatives852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomic_in_rule__Prefixed__Alternatives870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_0__0_in_rule__Atomic__Alternatives902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_1__0_in_rule__Atomic__Alternatives920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_2__0_in_rule__Atomic__Alternatives938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_3__0_in_rule__Atomic__Alternatives956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_4__0_in_rule__Atomic__Alternatives974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Atomic__ValueAlternatives_3_1_01008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Atomic__ValueAlternatives_3_1_01028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group__0__Impl_in_rule__Variable__Group__01061 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Variable__Group__1_in_rule__Variable__Group__01064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__NameAssignment_0_in_rule__Variable__Group__0__Impl1091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group__1__Impl_in_rule__Variable__Group__11121 = new BitSet(new long[]{0x0000000000E60070L});
    public static final BitSet FOLLOW_rule__Variable__Group__2_in_rule__Variable__Group__11124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Variable__Group__1__Impl1152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__Group__2__Impl_in_rule__Variable__Group__21183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__ExpressionAssignment_2_in_rule__Variable__Group__2__Impl1210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group__0__Impl_in_rule__BooleanExpression__Group__01246 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group__1_in_rule__BooleanExpression__Group__01249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparison_in_rule__BooleanExpression__Group__0__Impl1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group__1__Impl_in_rule__BooleanExpression__Group__11305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group_1__0_in_rule__BooleanExpression__Group__1__Impl1332 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group_1__0__Impl_in_rule__BooleanExpression__Group_1__01367 = new BitSet(new long[]{0x0000000000E60070L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group_1__1_in_rule__BooleanExpression__Group_1__01370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group_1_0__0_in_rule__BooleanExpression__Group_1__0__Impl1397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group_1__1__Impl_in_rule__BooleanExpression__Group_1__11427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__RightAssignment_1_1_in_rule__BooleanExpression__Group_1__1__Impl1454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group_1_0__0__Impl_in_rule__BooleanExpression__Group_1_0__01488 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group_1_0__1_in_rule__BooleanExpression__Group_1_0__01491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Group_1_0__1__Impl_in_rule__BooleanExpression__Group_1_0__11549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__OpAssignment_1_0_1_in_rule__BooleanExpression__Group_1_0__1__Impl1576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group__0__Impl_in_rule__Comparison__Group__01610 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_rule__Comparison__Group__1_in_rule__Comparison__Group__01613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_rule__Comparison__Group__0__Impl1640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group__1__Impl_in_rule__Comparison__Group__11669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1__0_in_rule__Comparison__Group__1__Impl1696 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1__0__Impl_in_rule__Comparison__Group_1__01731 = new BitSet(new long[]{0x0000000000E60070L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1__1_in_rule__Comparison__Group_1__01734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0__0_in_rule__Comparison__Group_1__0__Impl1761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1__1__Impl_in_rule__Comparison__Group_1__11791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__RightAssignment_1_1_in_rule__Comparison__Group_1__1__Impl1818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0__0__Impl_in_rule__Comparison__Group_1_0__01852 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0__1_in_rule__Comparison__Group_1_0__01855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0__1__Impl_in_rule__Comparison__Group_1_0__11913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__OpAssignment_1_0_1_in_rule__Comparison__Group_1_0__1__Impl1940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group__0__Impl_in_rule__Addition__Group__01974 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_rule__Addition__Group__1_in_rule__Addition__Group__01977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_rule__Addition__Group__0__Impl2004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group__1__Impl_in_rule__Addition__Group__12033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1__0_in_rule__Addition__Group__1__Impl2060 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1__0__Impl_in_rule__Addition__Group_1__02095 = new BitSet(new long[]{0x0000000000E60070L});
    public static final BitSet FOLLOW_rule__Addition__Group_1__1_in_rule__Addition__Group_1__02098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Alternatives_1_0_in_rule__Addition__Group_1__0__Impl2125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1__1__Impl_in_rule__Addition__Group_1__12155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__RightAssignment_1_1_in_rule__Addition__Group_1__1__Impl2182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_0__0__Impl_in_rule__Addition__Group_1_0_0__02216 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_0__1_in_rule__Addition__Group_1_0_0__02219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_0__1__Impl_in_rule__Addition__Group_1_0_0__12277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Addition__Group_1_0_0__1__Impl2305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_1__0__Impl_in_rule__Addition__Group_1_0_1__02340 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_1__1_in_rule__Addition__Group_1_0_1__02343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_1__1__Impl_in_rule__Addition__Group_1_0_1__12401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Addition__Group_1_0_1__1__Impl2429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group__0__Impl_in_rule__Multiplication__Group__02464 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_rule__Multiplication__Group__1_in_rule__Multiplication__Group__02467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrefixed_in_rule__Multiplication__Group__0__Impl2494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group__1__Impl_in_rule__Multiplication__Group__12523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1__0_in_rule__Multiplication__Group__1__Impl2550 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1__0__Impl_in_rule__Multiplication__Group_1__02585 = new BitSet(new long[]{0x0000000000E60070L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1__1_in_rule__Multiplication__Group_1__02588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0__0_in_rule__Multiplication__Group_1__0__Impl2615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1__1__Impl_in_rule__Multiplication__Group_1__12645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__RightAssignment_1_1_in_rule__Multiplication__Group_1__1__Impl2672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0__0__Impl_in_rule__Multiplication__Group_1_0__02706 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0__1_in_rule__Multiplication__Group_1_0__02709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0__1__Impl_in_rule__Multiplication__Group_1_0__12767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__OpAssignment_1_0_1_in_rule__Multiplication__Group_1_0__1__Impl2794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Prefixed__Group_0__0__Impl_in_rule__Prefixed__Group_0__02828 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__Prefixed__Group_0__1_in_rule__Prefixed__Group_0__02831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Prefixed__Group_0__1__Impl_in_rule__Prefixed__Group_0__12889 = new BitSet(new long[]{0x0000000000E60070L});
    public static final BitSet FOLLOW_rule__Prefixed__Group_0__2_in_rule__Prefixed__Group_0__12892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Prefixed__Group_0__1__Impl2921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Prefixed__Group_0__2__Impl_in_rule__Prefixed__Group_0__22953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Prefixed__ExpressionAssignment_0_2_in_rule__Prefixed__Group_0__2__Impl2980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Prefixed__Group_1__0__Impl_in_rule__Prefixed__Group_1__03016 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__Prefixed__Group_1__1_in_rule__Prefixed__Group_1__03019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Prefixed__Group_1__1__Impl_in_rule__Prefixed__Group_1__13077 = new BitSet(new long[]{0x0000000000E60070L});
    public static final BitSet FOLLOW_rule__Prefixed__Group_1__2_in_rule__Prefixed__Group_1__13080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Prefixed__Group_1__1__Impl3109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Prefixed__Group_1__2__Impl_in_rule__Prefixed__Group_1__23141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Prefixed__ExpressionAssignment_1_2_in_rule__Prefixed__Group_1__2__Impl3168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_0__0__Impl_in_rule__Atomic__Group_0__03204 = new BitSet(new long[]{0x0000000000E60070L});
    public static final BitSet FOLLOW_rule__Atomic__Group_0__1_in_rule__Atomic__Group_0__03207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Atomic__Group_0__0__Impl3235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_0__1__Impl_in_rule__Atomic__Group_0__13266 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__Atomic__Group_0__2_in_rule__Atomic__Group_0__13269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__Atomic__Group_0__1__Impl3296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_0__2__Impl_in_rule__Atomic__Group_0__23325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Atomic__Group_0__2__Impl3353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_1__0__Impl_in_rule__Atomic__Group_1__03390 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Atomic__Group_1__1_in_rule__Atomic__Group_1__03393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_1__1__Impl_in_rule__Atomic__Group_1__13451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__ValueAssignment_1_1_in_rule__Atomic__Group_1__1__Impl3478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_2__0__Impl_in_rule__Atomic__Group_2__03512 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Atomic__Group_2__1_in_rule__Atomic__Group_2__03515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_2__1__Impl_in_rule__Atomic__Group_2__13573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__ValueAssignment_2_1_in_rule__Atomic__Group_2__1__Impl3600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_3__0__Impl_in_rule__Atomic__Group_3__03634 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__Atomic__Group_3__1_in_rule__Atomic__Group_3__03637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_3__1__Impl_in_rule__Atomic__Group_3__13695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__ValueAssignment_3_1_in_rule__Atomic__Group_3__1__Impl3722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_4__0__Impl_in_rule__Atomic__Group_4__03756 = new BitSet(new long[]{0x0000000000E60070L});
    public static final BitSet FOLLOW_rule__Atomic__Group_4__1_in_rule__Atomic__Group_4__03759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__Group_4__1__Impl_in_rule__Atomic__Group_4__13817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__RefAssignment_4_1_in_rule__Atomic__Group_4__1__Impl3844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__Model__VariablesAssignment3886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Variable__NameAssignment_03917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__Variable__ExpressionAssignment_23948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__OpAlternatives_1_0_1_0_in_rule__BooleanExpression__OpAssignment_1_0_13979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparison_in_rule__BooleanExpression__RightAssignment_1_14012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__OpAlternatives_1_0_1_0_in_rule__Comparison__OpAssignment_1_0_14043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_rule__Comparison__RightAssignment_1_14076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_rule__Addition__RightAssignment_1_14107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__OpAlternatives_1_0_1_0_in_rule__Multiplication__OpAssignment_1_0_14138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrefixed_in_rule__Multiplication__RightAssignment_1_14171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomic_in_rule__Prefixed__ExpressionAssignment_0_24202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomic_in_rule__Prefixed__ExpressionAssignment_1_24233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Atomic__ValueAssignment_1_14264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Atomic__ValueAssignment_2_14295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Atomic__ValueAlternatives_3_1_0_in_rule__Atomic__ValueAssignment_3_14326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Atomic__RefAssignment_4_14363 = new BitSet(new long[]{0x0000000000000002L});

}