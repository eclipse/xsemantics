package it.xsemantics.example.lambda.ui.contentassist.antlr.internal; 

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
import it.xsemantics.example.lambda.services.LambdaGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalLambdaParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_INT", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'-'", "'lambda'", "'.'", "':'", "'->'", "'int'", "'string'"
    };
    public static final int RULE_ID=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=4;
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


        public InternalLambdaParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalLambdaParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalLambdaParser.tokenNames; }
    public String getGrammarFileName() { return "../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g"; }


     
     	private LambdaGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(LambdaGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleProgram"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:61:1: entryRuleProgram : ruleProgram EOF ;
    public final void entryRuleProgram() throws RecognitionException {
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:62:1: ( ruleProgram EOF )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:63:1: ruleProgram EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramRule()); 
            }
            pushFollow(FOLLOW_ruleProgram_in_entryRuleProgram67);
            ruleProgram();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleProgram74); if (state.failed) return ;

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
    // $ANTLR end "entryRuleProgram"


    // $ANTLR start "ruleProgram"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:70:1: ruleProgram : ( ( rule__Program__TermAssignment ) ) ;
    public final void ruleProgram() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:74:2: ( ( ( rule__Program__TermAssignment ) ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:75:1: ( ( rule__Program__TermAssignment ) )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:75:1: ( ( rule__Program__TermAssignment ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:76:1: ( rule__Program__TermAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getTermAssignment()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:77:1: ( rule__Program__TermAssignment )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:77:2: rule__Program__TermAssignment
            {
            pushFollow(FOLLOW_rule__Program__TermAssignment_in_ruleProgram100);
            rule__Program__TermAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getTermAssignment()); 
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
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleTerm"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:89:1: entryRuleTerm : ruleTerm EOF ;
    public final void entryRuleTerm() throws RecognitionException {
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:90:1: ( ruleTerm EOF )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:91:1: ruleTerm EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTermRule()); 
            }
            pushFollow(FOLLOW_ruleTerm_in_entryRuleTerm127);
            ruleTerm();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTermRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerm134); if (state.failed) return ;

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
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:98:1: ruleTerm : ( ( rule__Term__Group__0 ) ) ;
    public final void ruleTerm() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:102:2: ( ( ( rule__Term__Group__0 ) ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:103:1: ( ( rule__Term__Group__0 ) )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:103:1: ( ( rule__Term__Group__0 ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:104:1: ( rule__Term__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTermAccess().getGroup()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:105:1: ( rule__Term__Group__0 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:105:2: rule__Term__Group__0
            {
            pushFollow(FOLLOW_rule__Term__Group__0_in_ruleTerm160);
            rule__Term__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTermAccess().getGroup()); 
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
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleTerminalTerm"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:117:1: entryRuleTerminalTerm : ruleTerminalTerm EOF ;
    public final void entryRuleTerminalTerm() throws RecognitionException {
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:118:1: ( ruleTerminalTerm EOF )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:119:1: ruleTerminalTerm EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalTermRule()); 
            }
            pushFollow(FOLLOW_ruleTerminalTerm_in_entryRuleTerminalTerm187);
            ruleTerminalTerm();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalTermRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalTerm194); if (state.failed) return ;

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
    // $ANTLR end "entryRuleTerminalTerm"


    // $ANTLR start "ruleTerminalTerm"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:126:1: ruleTerminalTerm : ( ( rule__TerminalTerm__Alternatives ) ) ;
    public final void ruleTerminalTerm() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:130:2: ( ( ( rule__TerminalTerm__Alternatives ) ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:131:1: ( ( rule__TerminalTerm__Alternatives ) )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:131:1: ( ( rule__TerminalTerm__Alternatives ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:132:1: ( rule__TerminalTerm__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalTermAccess().getAlternatives()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:133:1: ( rule__TerminalTerm__Alternatives )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:133:2: rule__TerminalTerm__Alternatives
            {
            pushFollow(FOLLOW_rule__TerminalTerm__Alternatives_in_ruleTerminalTerm220);
            rule__TerminalTerm__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalTermAccess().getAlternatives()); 
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
    // $ANTLR end "ruleTerminalTerm"


    // $ANTLR start "entryRuleConstant"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:145:1: entryRuleConstant : ruleConstant EOF ;
    public final void entryRuleConstant() throws RecognitionException {
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:146:1: ( ruleConstant EOF )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:147:1: ruleConstant EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantRule()); 
            }
            pushFollow(FOLLOW_ruleConstant_in_entryRuleConstant247);
            ruleConstant();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstant254); if (state.failed) return ;

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
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:154:1: ruleConstant : ( ( rule__Constant__Alternatives ) ) ;
    public final void ruleConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:158:2: ( ( ( rule__Constant__Alternatives ) ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:159:1: ( ( rule__Constant__Alternatives ) )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:159:1: ( ( rule__Constant__Alternatives ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:160:1: ( rule__Constant__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantAccess().getAlternatives()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:161:1: ( rule__Constant__Alternatives )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:161:2: rule__Constant__Alternatives
            {
            pushFollow(FOLLOW_rule__Constant__Alternatives_in_ruleConstant280);
            rule__Constant__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantAccess().getAlternatives()); 
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
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleStringConstant"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:173:1: entryRuleStringConstant : ruleStringConstant EOF ;
    public final void entryRuleStringConstant() throws RecognitionException {
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:174:1: ( ruleStringConstant EOF )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:175:1: ruleStringConstant EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringConstantRule()); 
            }
            pushFollow(FOLLOW_ruleStringConstant_in_entryRuleStringConstant307);
            ruleStringConstant();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringConstantRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringConstant314); if (state.failed) return ;

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
    // $ANTLR end "entryRuleStringConstant"


    // $ANTLR start "ruleStringConstant"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:182:1: ruleStringConstant : ( ( rule__StringConstant__StringAssignment ) ) ;
    public final void ruleStringConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:186:2: ( ( ( rule__StringConstant__StringAssignment ) ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:187:1: ( ( rule__StringConstant__StringAssignment ) )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:187:1: ( ( rule__StringConstant__StringAssignment ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:188:1: ( rule__StringConstant__StringAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringConstantAccess().getStringAssignment()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:189:1: ( rule__StringConstant__StringAssignment )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:189:2: rule__StringConstant__StringAssignment
            {
            pushFollow(FOLLOW_rule__StringConstant__StringAssignment_in_ruleStringConstant340);
            rule__StringConstant__StringAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringConstantAccess().getStringAssignment()); 
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
    // $ANTLR end "ruleStringConstant"


    // $ANTLR start "entryRuleIntConstant"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:201:1: entryRuleIntConstant : ruleIntConstant EOF ;
    public final void entryRuleIntConstant() throws RecognitionException {
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:202:1: ( ruleIntConstant EOF )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:203:1: ruleIntConstant EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntConstantRule()); 
            }
            pushFollow(FOLLOW_ruleIntConstant_in_entryRuleIntConstant367);
            ruleIntConstant();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntConstantRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntConstant374); if (state.failed) return ;

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
    // $ANTLR end "entryRuleIntConstant"


    // $ANTLR start "ruleIntConstant"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:210:1: ruleIntConstant : ( ( rule__IntConstant__IntAssignment ) ) ;
    public final void ruleIntConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:214:2: ( ( ( rule__IntConstant__IntAssignment ) ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:215:1: ( ( rule__IntConstant__IntAssignment ) )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:215:1: ( ( rule__IntConstant__IntAssignment ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:216:1: ( rule__IntConstant__IntAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntConstantAccess().getIntAssignment()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:217:1: ( rule__IntConstant__IntAssignment )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:217:2: rule__IntConstant__IntAssignment
            {
            pushFollow(FOLLOW_rule__IntConstant__IntAssignment_in_ruleIntConstant400);
            rule__IntConstant__IntAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntConstantAccess().getIntAssignment()); 
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
    // $ANTLR end "ruleIntConstant"


    // $ANTLR start "entryRuleArithmetics"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:229:1: entryRuleArithmetics : ruleArithmetics EOF ;
    public final void entryRuleArithmetics() throws RecognitionException {
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:230:1: ( ruleArithmetics EOF )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:231:1: ruleArithmetics EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArithmeticsRule()); 
            }
            pushFollow(FOLLOW_ruleArithmetics_in_entryRuleArithmetics427);
            ruleArithmetics();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArithmeticsRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArithmetics434); if (state.failed) return ;

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
    // $ANTLR end "entryRuleArithmetics"


    // $ANTLR start "ruleArithmetics"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:238:1: ruleArithmetics : ( ( rule__Arithmetics__Group__0 ) ) ;
    public final void ruleArithmetics() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:242:2: ( ( ( rule__Arithmetics__Group__0 ) ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:243:1: ( ( rule__Arithmetics__Group__0 ) )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:243:1: ( ( rule__Arithmetics__Group__0 ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:244:1: ( rule__Arithmetics__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArithmeticsAccess().getGroup()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:245:1: ( rule__Arithmetics__Group__0 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:245:2: rule__Arithmetics__Group__0
            {
            pushFollow(FOLLOW_rule__Arithmetics__Group__0_in_ruleArithmetics460);
            rule__Arithmetics__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getArithmeticsAccess().getGroup()); 
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
    // $ANTLR end "ruleArithmetics"


    // $ANTLR start "entryRuleVariable"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:257:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:258:1: ( ruleVariable EOF )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:259:1: ruleVariable EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableRule()); 
            }
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable487);
            ruleVariable();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable494); if (state.failed) return ;

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
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:266:1: ruleVariable : ( ( rule__Variable__RefAssignment ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:270:2: ( ( ( rule__Variable__RefAssignment ) ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:271:1: ( ( rule__Variable__RefAssignment ) )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:271:1: ( ( rule__Variable__RefAssignment ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:272:1: ( rule__Variable__RefAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableAccess().getRefAssignment()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:273:1: ( rule__Variable__RefAssignment )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:273:2: rule__Variable__RefAssignment
            {
            pushFollow(FOLLOW_rule__Variable__RefAssignment_in_ruleVariable520);
            rule__Variable__RefAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableAccess().getRefAssignment()); 
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


    // $ANTLR start "entryRuleAbstraction"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:285:1: entryRuleAbstraction : ruleAbstraction EOF ;
    public final void entryRuleAbstraction() throws RecognitionException {
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:286:1: ( ruleAbstraction EOF )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:287:1: ruleAbstraction EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbstractionRule()); 
            }
            pushFollow(FOLLOW_ruleAbstraction_in_entryRuleAbstraction547);
            ruleAbstraction();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbstractionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstraction554); if (state.failed) return ;

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
    // $ANTLR end "entryRuleAbstraction"


    // $ANTLR start "ruleAbstraction"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:294:1: ruleAbstraction : ( ( rule__Abstraction__Group__0 ) ) ;
    public final void ruleAbstraction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:298:2: ( ( ( rule__Abstraction__Group__0 ) ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:299:1: ( ( rule__Abstraction__Group__0 ) )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:299:1: ( ( rule__Abstraction__Group__0 ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:300:1: ( rule__Abstraction__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbstractionAccess().getGroup()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:301:1: ( rule__Abstraction__Group__0 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:301:2: rule__Abstraction__Group__0
            {
            pushFollow(FOLLOW_rule__Abstraction__Group__0_in_ruleAbstraction580);
            rule__Abstraction__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbstractionAccess().getGroup()); 
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
    // $ANTLR end "ruleAbstraction"


    // $ANTLR start "entryRuleParameter"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:313:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:314:1: ( ruleParameter EOF )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:315:1: ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRule()); 
            }
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter607);
            ruleParameter();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter614); if (state.failed) return ;

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
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:322:1: ruleParameter : ( ( rule__Parameter__Group__0 ) ) ;
    public final void ruleParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:326:2: ( ( ( rule__Parameter__Group__0 ) ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:327:1: ( ( rule__Parameter__Group__0 ) )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:327:1: ( ( rule__Parameter__Group__0 ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:328:1: ( rule__Parameter__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getGroup()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:329:1: ( rule__Parameter__Group__0 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:329:2: rule__Parameter__Group__0
            {
            pushFollow(FOLLOW_rule__Parameter__Group__0_in_ruleParameter640);
            rule__Parameter__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getGroup()); 
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
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleType"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:341:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:342:1: ( ruleType EOF )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:343:1: ruleType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_ruleType_in_entryRuleType667);
            ruleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleType674); if (state.failed) return ;

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
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:350:1: ruleType : ( ( rule__Type__Group__0 ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:354:2: ( ( ( rule__Type__Group__0 ) ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:355:1: ( ( rule__Type__Group__0 ) )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:355:1: ( ( rule__Type__Group__0 ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:356:1: ( rule__Type__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAccess().getGroup()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:357:1: ( rule__Type__Group__0 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:357:2: rule__Type__Group__0
            {
            pushFollow(FOLLOW_rule__Type__Group__0_in_ruleType700);
            rule__Type__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeAccess().getGroup()); 
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
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleTerminalType"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:369:1: entryRuleTerminalType : ruleTerminalType EOF ;
    public final void entryRuleTerminalType() throws RecognitionException {
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:370:1: ( ruleTerminalType EOF )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:371:1: ruleTerminalType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalTypeRule()); 
            }
            pushFollow(FOLLOW_ruleTerminalType_in_entryRuleTerminalType727);
            ruleTerminalType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalTypeRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalType734); if (state.failed) return ;

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
    // $ANTLR end "entryRuleTerminalType"


    // $ANTLR start "ruleTerminalType"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:378:1: ruleTerminalType : ( ( rule__TerminalType__Alternatives ) ) ;
    public final void ruleTerminalType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:382:2: ( ( ( rule__TerminalType__Alternatives ) ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:383:1: ( ( rule__TerminalType__Alternatives ) )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:383:1: ( ( rule__TerminalType__Alternatives ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:384:1: ( rule__TerminalType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalTypeAccess().getAlternatives()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:385:1: ( rule__TerminalType__Alternatives )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:385:2: rule__TerminalType__Alternatives
            {
            pushFollow(FOLLOW_rule__TerminalType__Alternatives_in_ruleTerminalType760);
            rule__TerminalType__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalTypeAccess().getAlternatives()); 
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
    // $ANTLR end "ruleTerminalType"


    // $ANTLR start "entryRuleBasicType"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:397:1: entryRuleBasicType : ruleBasicType EOF ;
    public final void entryRuleBasicType() throws RecognitionException {
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:398:1: ( ruleBasicType EOF )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:399:1: ruleBasicType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBasicTypeRule()); 
            }
            pushFollow(FOLLOW_ruleBasicType_in_entryRuleBasicType787);
            ruleBasicType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBasicTypeRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBasicType794); if (state.failed) return ;

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
    // $ANTLR end "entryRuleBasicType"


    // $ANTLR start "ruleBasicType"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:406:1: ruleBasicType : ( ( rule__BasicType__Alternatives ) ) ;
    public final void ruleBasicType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:410:2: ( ( ( rule__BasicType__Alternatives ) ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:411:1: ( ( rule__BasicType__Alternatives ) )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:411:1: ( ( rule__BasicType__Alternatives ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:412:1: ( rule__BasicType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBasicTypeAccess().getAlternatives()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:413:1: ( rule__BasicType__Alternatives )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:413:2: rule__BasicType__Alternatives
            {
            pushFollow(FOLLOW_rule__BasicType__Alternatives_in_ruleBasicType820);
            rule__BasicType__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBasicTypeAccess().getAlternatives()); 
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
    // $ANTLR end "ruleBasicType"


    // $ANTLR start "entryRuleTypeVariable"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:425:1: entryRuleTypeVariable : ruleTypeVariable EOF ;
    public final void entryRuleTypeVariable() throws RecognitionException {
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:426:1: ( ruleTypeVariable EOF )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:427:1: ruleTypeVariable EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeVariableRule()); 
            }
            pushFollow(FOLLOW_ruleTypeVariable_in_entryRuleTypeVariable847);
            ruleTypeVariable();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeVariableRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeVariable854); if (state.failed) return ;

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
    // $ANTLR end "entryRuleTypeVariable"


    // $ANTLR start "ruleTypeVariable"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:434:1: ruleTypeVariable : ( ( rule__TypeVariable__TypevarNameAssignment ) ) ;
    public final void ruleTypeVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:438:2: ( ( ( rule__TypeVariable__TypevarNameAssignment ) ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:439:1: ( ( rule__TypeVariable__TypevarNameAssignment ) )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:439:1: ( ( rule__TypeVariable__TypevarNameAssignment ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:440:1: ( rule__TypeVariable__TypevarNameAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeVariableAccess().getTypevarNameAssignment()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:441:1: ( rule__TypeVariable__TypevarNameAssignment )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:441:2: rule__TypeVariable__TypevarNameAssignment
            {
            pushFollow(FOLLOW_rule__TypeVariable__TypevarNameAssignment_in_ruleTypeVariable880);
            rule__TypeVariable__TypevarNameAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeVariableAccess().getTypevarNameAssignment()); 
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
    // $ANTLR end "ruleTypeVariable"


    // $ANTLR start "rule__TerminalTerm__Alternatives"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:453:1: rule__TerminalTerm__Alternatives : ( ( ( rule__TerminalTerm__Group_0__0 ) ) | ( ruleConstant ) | ( ruleArithmetics ) | ( ruleVariable ) | ( ruleAbstraction ) );
    public final void rule__TerminalTerm__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:457:1: ( ( ( rule__TerminalTerm__Group_0__0 ) ) | ( ruleConstant ) | ( ruleArithmetics ) | ( ruleVariable ) | ( ruleAbstraction ) )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case RULE_STRING:
            case RULE_INT:
                {
                alt1=2;
                }
                break;
            case 13:
                {
                alt1=3;
                }
                break;
            case RULE_ID:
                {
                alt1=4;
                }
                break;
            case 14:
                {
                alt1=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:458:1: ( ( rule__TerminalTerm__Group_0__0 ) )
                    {
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:458:1: ( ( rule__TerminalTerm__Group_0__0 ) )
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:459:1: ( rule__TerminalTerm__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalTermAccess().getGroup_0()); 
                    }
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:460:1: ( rule__TerminalTerm__Group_0__0 )
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:460:2: rule__TerminalTerm__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__TerminalTerm__Group_0__0_in_rule__TerminalTerm__Alternatives916);
                    rule__TerminalTerm__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalTermAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:464:6: ( ruleConstant )
                    {
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:464:6: ( ruleConstant )
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:465:1: ruleConstant
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalTermAccess().getConstantParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleConstant_in_rule__TerminalTerm__Alternatives934);
                    ruleConstant();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalTermAccess().getConstantParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:470:6: ( ruleArithmetics )
                    {
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:470:6: ( ruleArithmetics )
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:471:1: ruleArithmetics
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalTermAccess().getArithmeticsParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_ruleArithmetics_in_rule__TerminalTerm__Alternatives951);
                    ruleArithmetics();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalTermAccess().getArithmeticsParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:476:6: ( ruleVariable )
                    {
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:476:6: ( ruleVariable )
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:477:1: ruleVariable
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalTermAccess().getVariableParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_ruleVariable_in_rule__TerminalTerm__Alternatives968);
                    ruleVariable();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalTermAccess().getVariableParserRuleCall_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:482:6: ( ruleAbstraction )
                    {
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:482:6: ( ruleAbstraction )
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:483:1: ruleAbstraction
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalTermAccess().getAbstractionParserRuleCall_4()); 
                    }
                    pushFollow(FOLLOW_ruleAbstraction_in_rule__TerminalTerm__Alternatives985);
                    ruleAbstraction();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalTermAccess().getAbstractionParserRuleCall_4()); 
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
    // $ANTLR end "rule__TerminalTerm__Alternatives"


    // $ANTLR start "rule__Constant__Alternatives"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:493:1: rule__Constant__Alternatives : ( ( ruleStringConstant ) | ( ruleIntConstant ) );
    public final void rule__Constant__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:497:1: ( ( ruleStringConstant ) | ( ruleIntConstant ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_INT) ) {
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
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:498:1: ( ruleStringConstant )
                    {
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:498:1: ( ruleStringConstant )
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:499:1: ruleStringConstant
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConstantAccess().getStringConstantParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleStringConstant_in_rule__Constant__Alternatives1017);
                    ruleStringConstant();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getConstantAccess().getStringConstantParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:504:6: ( ruleIntConstant )
                    {
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:504:6: ( ruleIntConstant )
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:505:1: ruleIntConstant
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConstantAccess().getIntConstantParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleIntConstant_in_rule__Constant__Alternatives1034);
                    ruleIntConstant();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getConstantAccess().getIntConstantParserRuleCall_1()); 
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
    // $ANTLR end "rule__Constant__Alternatives"


    // $ANTLR start "rule__TerminalType__Alternatives"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:515:1: rule__TerminalType__Alternatives : ( ( ( rule__TerminalType__Group_0__0 ) ) | ( ruleBasicType ) | ( ruleTypeVariable ) );
    public final void rule__TerminalType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:519:1: ( ( ( rule__TerminalType__Group_0__0 ) ) | ( ruleBasicType ) | ( ruleTypeVariable ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt3=1;
                }
                break;
            case 18:
            case 19:
                {
                alt3=2;
                }
                break;
            case RULE_ID:
                {
                alt3=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:520:1: ( ( rule__TerminalType__Group_0__0 ) )
                    {
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:520:1: ( ( rule__TerminalType__Group_0__0 ) )
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:521:1: ( rule__TerminalType__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalTypeAccess().getGroup_0()); 
                    }
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:522:1: ( rule__TerminalType__Group_0__0 )
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:522:2: rule__TerminalType__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__TerminalType__Group_0__0_in_rule__TerminalType__Alternatives1066);
                    rule__TerminalType__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalTypeAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:526:6: ( ruleBasicType )
                    {
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:526:6: ( ruleBasicType )
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:527:1: ruleBasicType
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalTypeAccess().getBasicTypeParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleBasicType_in_rule__TerminalType__Alternatives1084);
                    ruleBasicType();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalTypeAccess().getBasicTypeParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:532:6: ( ruleTypeVariable )
                    {
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:532:6: ( ruleTypeVariable )
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:533:1: ruleTypeVariable
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalTypeAccess().getTypeVariableParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_ruleTypeVariable_in_rule__TerminalType__Alternatives1101);
                    ruleTypeVariable();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalTypeAccess().getTypeVariableParserRuleCall_2()); 
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
    // $ANTLR end "rule__TerminalType__Alternatives"


    // $ANTLR start "rule__BasicType__Alternatives"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:543:1: rule__BasicType__Alternatives : ( ( ( rule__BasicType__Group_0__0 ) ) | ( ( rule__BasicType__Group_1__0 ) ) );
    public final void rule__BasicType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:547:1: ( ( ( rule__BasicType__Group_0__0 ) ) | ( ( rule__BasicType__Group_1__0 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            else if ( (LA4_0==19) ) {
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
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:548:1: ( ( rule__BasicType__Group_0__0 ) )
                    {
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:548:1: ( ( rule__BasicType__Group_0__0 ) )
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:549:1: ( rule__BasicType__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBasicTypeAccess().getGroup_0()); 
                    }
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:550:1: ( rule__BasicType__Group_0__0 )
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:550:2: rule__BasicType__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__BasicType__Group_0__0_in_rule__BasicType__Alternatives1133);
                    rule__BasicType__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBasicTypeAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:554:6: ( ( rule__BasicType__Group_1__0 ) )
                    {
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:554:6: ( ( rule__BasicType__Group_1__0 ) )
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:555:1: ( rule__BasicType__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBasicTypeAccess().getGroup_1()); 
                    }
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:556:1: ( rule__BasicType__Group_1__0 )
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:556:2: rule__BasicType__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__BasicType__Group_1__0_in_rule__BasicType__Alternatives1151);
                    rule__BasicType__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBasicTypeAccess().getGroup_1()); 
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
    // $ANTLR end "rule__BasicType__Alternatives"


    // $ANTLR start "rule__Term__Group__0"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:567:1: rule__Term__Group__0 : rule__Term__Group__0__Impl rule__Term__Group__1 ;
    public final void rule__Term__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:571:1: ( rule__Term__Group__0__Impl rule__Term__Group__1 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:572:2: rule__Term__Group__0__Impl rule__Term__Group__1
            {
            pushFollow(FOLLOW_rule__Term__Group__0__Impl_in_rule__Term__Group__01182);
            rule__Term__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Term__Group__1_in_rule__Term__Group__01185);
            rule__Term__Group__1();

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
    // $ANTLR end "rule__Term__Group__0"


    // $ANTLR start "rule__Term__Group__0__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:579:1: rule__Term__Group__0__Impl : ( ruleTerminalTerm ) ;
    public final void rule__Term__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:583:1: ( ( ruleTerminalTerm ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:584:1: ( ruleTerminalTerm )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:584:1: ( ruleTerminalTerm )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:585:1: ruleTerminalTerm
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTermAccess().getTerminalTermParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleTerminalTerm_in_rule__Term__Group__0__Impl1212);
            ruleTerminalTerm();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTermAccess().getTerminalTermParserRuleCall_0()); 
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
    // $ANTLR end "rule__Term__Group__0__Impl"


    // $ANTLR start "rule__Term__Group__1"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:596:1: rule__Term__Group__1 : rule__Term__Group__1__Impl ;
    public final void rule__Term__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:600:1: ( rule__Term__Group__1__Impl )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:601:2: rule__Term__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Term__Group__1__Impl_in_rule__Term__Group__11241);
            rule__Term__Group__1__Impl();

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
    // $ANTLR end "rule__Term__Group__1"


    // $ANTLR start "rule__Term__Group__1__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:607:1: rule__Term__Group__1__Impl : ( ( rule__Term__Group_1__0 )* ) ;
    public final void rule__Term__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:611:1: ( ( ( rule__Term__Group_1__0 )* ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:612:1: ( ( rule__Term__Group_1__0 )* )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:612:1: ( ( rule__Term__Group_1__0 )* )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:613:1: ( rule__Term__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTermAccess().getGroup_1()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:614:1: ( rule__Term__Group_1__0 )*
            loop5:
            do {
                int alt5=2;
                alt5 = dfa5.predict(input);
                switch (alt5) {
            	case 1 :
            	    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:614:2: rule__Term__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Term__Group_1__0_in_rule__Term__Group__1__Impl1268);
            	    rule__Term__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTermAccess().getGroup_1()); 
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
    // $ANTLR end "rule__Term__Group__1__Impl"


    // $ANTLR start "rule__Term__Group_1__0"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:628:1: rule__Term__Group_1__0 : rule__Term__Group_1__0__Impl ;
    public final void rule__Term__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:632:1: ( rule__Term__Group_1__0__Impl )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:633:2: rule__Term__Group_1__0__Impl
            {
            pushFollow(FOLLOW_rule__Term__Group_1__0__Impl_in_rule__Term__Group_1__01303);
            rule__Term__Group_1__0__Impl();

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
    // $ANTLR end "rule__Term__Group_1__0"


    // $ANTLR start "rule__Term__Group_1__0__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:639:1: rule__Term__Group_1__0__Impl : ( ( rule__Term__Group_1_0__0 ) ) ;
    public final void rule__Term__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:643:1: ( ( ( rule__Term__Group_1_0__0 ) ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:644:1: ( ( rule__Term__Group_1_0__0 ) )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:644:1: ( ( rule__Term__Group_1_0__0 ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:645:1: ( rule__Term__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTermAccess().getGroup_1_0()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:646:1: ( rule__Term__Group_1_0__0 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:646:2: rule__Term__Group_1_0__0
            {
            pushFollow(FOLLOW_rule__Term__Group_1_0__0_in_rule__Term__Group_1__0__Impl1330);
            rule__Term__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTermAccess().getGroup_1_0()); 
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
    // $ANTLR end "rule__Term__Group_1__0__Impl"


    // $ANTLR start "rule__Term__Group_1_0__0"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:658:1: rule__Term__Group_1_0__0 : rule__Term__Group_1_0__0__Impl rule__Term__Group_1_0__1 ;
    public final void rule__Term__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:662:1: ( rule__Term__Group_1_0__0__Impl rule__Term__Group_1_0__1 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:663:2: rule__Term__Group_1_0__0__Impl rule__Term__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__Term__Group_1_0__0__Impl_in_rule__Term__Group_1_0__01362);
            rule__Term__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Term__Group_1_0__1_in_rule__Term__Group_1_0__01365);
            rule__Term__Group_1_0__1();

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
    // $ANTLR end "rule__Term__Group_1_0__0"


    // $ANTLR start "rule__Term__Group_1_0__0__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:670:1: rule__Term__Group_1_0__0__Impl : ( () ) ;
    public final void rule__Term__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:674:1: ( ( () ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:675:1: ( () )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:675:1: ( () )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:676:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTermAccess().getApplicationFunAction_1_0_0()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:677:1: ()
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:679:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTermAccess().getApplicationFunAction_1_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Term__Group_1_0__0__Impl"


    // $ANTLR start "rule__Term__Group_1_0__1"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:689:1: rule__Term__Group_1_0__1 : rule__Term__Group_1_0__1__Impl ;
    public final void rule__Term__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:693:1: ( rule__Term__Group_1_0__1__Impl )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:694:2: rule__Term__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Term__Group_1_0__1__Impl_in_rule__Term__Group_1_0__11423);
            rule__Term__Group_1_0__1__Impl();

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
    // $ANTLR end "rule__Term__Group_1_0__1"


    // $ANTLR start "rule__Term__Group_1_0__1__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:700:1: rule__Term__Group_1_0__1__Impl : ( ( rule__Term__ArgAssignment_1_0_1 ) ) ;
    public final void rule__Term__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:704:1: ( ( ( rule__Term__ArgAssignment_1_0_1 ) ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:705:1: ( ( rule__Term__ArgAssignment_1_0_1 ) )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:705:1: ( ( rule__Term__ArgAssignment_1_0_1 ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:706:1: ( rule__Term__ArgAssignment_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTermAccess().getArgAssignment_1_0_1()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:707:1: ( rule__Term__ArgAssignment_1_0_1 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:707:2: rule__Term__ArgAssignment_1_0_1
            {
            pushFollow(FOLLOW_rule__Term__ArgAssignment_1_0_1_in_rule__Term__Group_1_0__1__Impl1450);
            rule__Term__ArgAssignment_1_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTermAccess().getArgAssignment_1_0_1()); 
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
    // $ANTLR end "rule__Term__Group_1_0__1__Impl"


    // $ANTLR start "rule__TerminalTerm__Group_0__0"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:721:1: rule__TerminalTerm__Group_0__0 : rule__TerminalTerm__Group_0__0__Impl rule__TerminalTerm__Group_0__1 ;
    public final void rule__TerminalTerm__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:725:1: ( rule__TerminalTerm__Group_0__0__Impl rule__TerminalTerm__Group_0__1 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:726:2: rule__TerminalTerm__Group_0__0__Impl rule__TerminalTerm__Group_0__1
            {
            pushFollow(FOLLOW_rule__TerminalTerm__Group_0__0__Impl_in_rule__TerminalTerm__Group_0__01484);
            rule__TerminalTerm__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalTerm__Group_0__1_in_rule__TerminalTerm__Group_0__01487);
            rule__TerminalTerm__Group_0__1();

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
    // $ANTLR end "rule__TerminalTerm__Group_0__0"


    // $ANTLR start "rule__TerminalTerm__Group_0__0__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:733:1: rule__TerminalTerm__Group_0__0__Impl : ( '(' ) ;
    public final void rule__TerminalTerm__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:737:1: ( ( '(' ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:738:1: ( '(' )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:738:1: ( '(' )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:739:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalTermAccess().getLeftParenthesisKeyword_0_0()); 
            }
            match(input,11,FOLLOW_11_in_rule__TerminalTerm__Group_0__0__Impl1515); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalTermAccess().getLeftParenthesisKeyword_0_0()); 
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
    // $ANTLR end "rule__TerminalTerm__Group_0__0__Impl"


    // $ANTLR start "rule__TerminalTerm__Group_0__1"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:752:1: rule__TerminalTerm__Group_0__1 : rule__TerminalTerm__Group_0__1__Impl rule__TerminalTerm__Group_0__2 ;
    public final void rule__TerminalTerm__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:756:1: ( rule__TerminalTerm__Group_0__1__Impl rule__TerminalTerm__Group_0__2 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:757:2: rule__TerminalTerm__Group_0__1__Impl rule__TerminalTerm__Group_0__2
            {
            pushFollow(FOLLOW_rule__TerminalTerm__Group_0__1__Impl_in_rule__TerminalTerm__Group_0__11546);
            rule__TerminalTerm__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalTerm__Group_0__2_in_rule__TerminalTerm__Group_0__11549);
            rule__TerminalTerm__Group_0__2();

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
    // $ANTLR end "rule__TerminalTerm__Group_0__1"


    // $ANTLR start "rule__TerminalTerm__Group_0__1__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:764:1: rule__TerminalTerm__Group_0__1__Impl : ( ruleTerm ) ;
    public final void rule__TerminalTerm__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:768:1: ( ( ruleTerm ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:769:1: ( ruleTerm )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:769:1: ( ruleTerm )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:770:1: ruleTerm
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalTermAccess().getTermParserRuleCall_0_1()); 
            }
            pushFollow(FOLLOW_ruleTerm_in_rule__TerminalTerm__Group_0__1__Impl1576);
            ruleTerm();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalTermAccess().getTermParserRuleCall_0_1()); 
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
    // $ANTLR end "rule__TerminalTerm__Group_0__1__Impl"


    // $ANTLR start "rule__TerminalTerm__Group_0__2"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:781:1: rule__TerminalTerm__Group_0__2 : rule__TerminalTerm__Group_0__2__Impl ;
    public final void rule__TerminalTerm__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:785:1: ( rule__TerminalTerm__Group_0__2__Impl )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:786:2: rule__TerminalTerm__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__TerminalTerm__Group_0__2__Impl_in_rule__TerminalTerm__Group_0__21605);
            rule__TerminalTerm__Group_0__2__Impl();

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
    // $ANTLR end "rule__TerminalTerm__Group_0__2"


    // $ANTLR start "rule__TerminalTerm__Group_0__2__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:792:1: rule__TerminalTerm__Group_0__2__Impl : ( ')' ) ;
    public final void rule__TerminalTerm__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:796:1: ( ( ')' ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:797:1: ( ')' )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:797:1: ( ')' )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:798:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalTermAccess().getRightParenthesisKeyword_0_2()); 
            }
            match(input,12,FOLLOW_12_in_rule__TerminalTerm__Group_0__2__Impl1633); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalTermAccess().getRightParenthesisKeyword_0_2()); 
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
    // $ANTLR end "rule__TerminalTerm__Group_0__2__Impl"


    // $ANTLR start "rule__Arithmetics__Group__0"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:817:1: rule__Arithmetics__Group__0 : rule__Arithmetics__Group__0__Impl rule__Arithmetics__Group__1 ;
    public final void rule__Arithmetics__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:821:1: ( rule__Arithmetics__Group__0__Impl rule__Arithmetics__Group__1 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:822:2: rule__Arithmetics__Group__0__Impl rule__Arithmetics__Group__1
            {
            pushFollow(FOLLOW_rule__Arithmetics__Group__0__Impl_in_rule__Arithmetics__Group__01670);
            rule__Arithmetics__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Arithmetics__Group__1_in_rule__Arithmetics__Group__01673);
            rule__Arithmetics__Group__1();

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
    // $ANTLR end "rule__Arithmetics__Group__0"


    // $ANTLR start "rule__Arithmetics__Group__0__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:829:1: rule__Arithmetics__Group__0__Impl : ( '-' ) ;
    public final void rule__Arithmetics__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:833:1: ( ( '-' ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:834:1: ( '-' )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:834:1: ( '-' )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:835:1: '-'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArithmeticsAccess().getHyphenMinusKeyword_0()); 
            }
            match(input,13,FOLLOW_13_in_rule__Arithmetics__Group__0__Impl1701); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArithmeticsAccess().getHyphenMinusKeyword_0()); 
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
    // $ANTLR end "rule__Arithmetics__Group__0__Impl"


    // $ANTLR start "rule__Arithmetics__Group__1"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:848:1: rule__Arithmetics__Group__1 : rule__Arithmetics__Group__1__Impl ;
    public final void rule__Arithmetics__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:852:1: ( rule__Arithmetics__Group__1__Impl )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:853:2: rule__Arithmetics__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Arithmetics__Group__1__Impl_in_rule__Arithmetics__Group__11732);
            rule__Arithmetics__Group__1__Impl();

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
    // $ANTLR end "rule__Arithmetics__Group__1"


    // $ANTLR start "rule__Arithmetics__Group__1__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:859:1: rule__Arithmetics__Group__1__Impl : ( ( rule__Arithmetics__TermAssignment_1 ) ) ;
    public final void rule__Arithmetics__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:863:1: ( ( ( rule__Arithmetics__TermAssignment_1 ) ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:864:1: ( ( rule__Arithmetics__TermAssignment_1 ) )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:864:1: ( ( rule__Arithmetics__TermAssignment_1 ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:865:1: ( rule__Arithmetics__TermAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArithmeticsAccess().getTermAssignment_1()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:866:1: ( rule__Arithmetics__TermAssignment_1 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:866:2: rule__Arithmetics__TermAssignment_1
            {
            pushFollow(FOLLOW_rule__Arithmetics__TermAssignment_1_in_rule__Arithmetics__Group__1__Impl1759);
            rule__Arithmetics__TermAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getArithmeticsAccess().getTermAssignment_1()); 
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
    // $ANTLR end "rule__Arithmetics__Group__1__Impl"


    // $ANTLR start "rule__Abstraction__Group__0"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:880:1: rule__Abstraction__Group__0 : rule__Abstraction__Group__0__Impl rule__Abstraction__Group__1 ;
    public final void rule__Abstraction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:884:1: ( rule__Abstraction__Group__0__Impl rule__Abstraction__Group__1 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:885:2: rule__Abstraction__Group__0__Impl rule__Abstraction__Group__1
            {
            pushFollow(FOLLOW_rule__Abstraction__Group__0__Impl_in_rule__Abstraction__Group__01793);
            rule__Abstraction__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Abstraction__Group__1_in_rule__Abstraction__Group__01796);
            rule__Abstraction__Group__1();

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
    // $ANTLR end "rule__Abstraction__Group__0"


    // $ANTLR start "rule__Abstraction__Group__0__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:892:1: rule__Abstraction__Group__0__Impl : ( 'lambda' ) ;
    public final void rule__Abstraction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:896:1: ( ( 'lambda' ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:897:1: ( 'lambda' )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:897:1: ( 'lambda' )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:898:1: 'lambda'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbstractionAccess().getLambdaKeyword_0()); 
            }
            match(input,14,FOLLOW_14_in_rule__Abstraction__Group__0__Impl1824); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbstractionAccess().getLambdaKeyword_0()); 
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
    // $ANTLR end "rule__Abstraction__Group__0__Impl"


    // $ANTLR start "rule__Abstraction__Group__1"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:911:1: rule__Abstraction__Group__1 : rule__Abstraction__Group__1__Impl rule__Abstraction__Group__2 ;
    public final void rule__Abstraction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:915:1: ( rule__Abstraction__Group__1__Impl rule__Abstraction__Group__2 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:916:2: rule__Abstraction__Group__1__Impl rule__Abstraction__Group__2
            {
            pushFollow(FOLLOW_rule__Abstraction__Group__1__Impl_in_rule__Abstraction__Group__11855);
            rule__Abstraction__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Abstraction__Group__2_in_rule__Abstraction__Group__11858);
            rule__Abstraction__Group__2();

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
    // $ANTLR end "rule__Abstraction__Group__1"


    // $ANTLR start "rule__Abstraction__Group__1__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:923:1: rule__Abstraction__Group__1__Impl : ( ( rule__Abstraction__ParamAssignment_1 ) ) ;
    public final void rule__Abstraction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:927:1: ( ( ( rule__Abstraction__ParamAssignment_1 ) ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:928:1: ( ( rule__Abstraction__ParamAssignment_1 ) )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:928:1: ( ( rule__Abstraction__ParamAssignment_1 ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:929:1: ( rule__Abstraction__ParamAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbstractionAccess().getParamAssignment_1()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:930:1: ( rule__Abstraction__ParamAssignment_1 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:930:2: rule__Abstraction__ParamAssignment_1
            {
            pushFollow(FOLLOW_rule__Abstraction__ParamAssignment_1_in_rule__Abstraction__Group__1__Impl1885);
            rule__Abstraction__ParamAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbstractionAccess().getParamAssignment_1()); 
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
    // $ANTLR end "rule__Abstraction__Group__1__Impl"


    // $ANTLR start "rule__Abstraction__Group__2"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:940:1: rule__Abstraction__Group__2 : rule__Abstraction__Group__2__Impl rule__Abstraction__Group__3 ;
    public final void rule__Abstraction__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:944:1: ( rule__Abstraction__Group__2__Impl rule__Abstraction__Group__3 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:945:2: rule__Abstraction__Group__2__Impl rule__Abstraction__Group__3
            {
            pushFollow(FOLLOW_rule__Abstraction__Group__2__Impl_in_rule__Abstraction__Group__21915);
            rule__Abstraction__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Abstraction__Group__3_in_rule__Abstraction__Group__21918);
            rule__Abstraction__Group__3();

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
    // $ANTLR end "rule__Abstraction__Group__2"


    // $ANTLR start "rule__Abstraction__Group__2__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:952:1: rule__Abstraction__Group__2__Impl : ( '.' ) ;
    public final void rule__Abstraction__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:956:1: ( ( '.' ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:957:1: ( '.' )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:957:1: ( '.' )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:958:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbstractionAccess().getFullStopKeyword_2()); 
            }
            match(input,15,FOLLOW_15_in_rule__Abstraction__Group__2__Impl1946); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbstractionAccess().getFullStopKeyword_2()); 
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
    // $ANTLR end "rule__Abstraction__Group__2__Impl"


    // $ANTLR start "rule__Abstraction__Group__3"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:971:1: rule__Abstraction__Group__3 : rule__Abstraction__Group__3__Impl ;
    public final void rule__Abstraction__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:975:1: ( rule__Abstraction__Group__3__Impl )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:976:2: rule__Abstraction__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Abstraction__Group__3__Impl_in_rule__Abstraction__Group__31977);
            rule__Abstraction__Group__3__Impl();

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
    // $ANTLR end "rule__Abstraction__Group__3"


    // $ANTLR start "rule__Abstraction__Group__3__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:982:1: rule__Abstraction__Group__3__Impl : ( ( rule__Abstraction__TermAssignment_3 ) ) ;
    public final void rule__Abstraction__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:986:1: ( ( ( rule__Abstraction__TermAssignment_3 ) ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:987:1: ( ( rule__Abstraction__TermAssignment_3 ) )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:987:1: ( ( rule__Abstraction__TermAssignment_3 ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:988:1: ( rule__Abstraction__TermAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbstractionAccess().getTermAssignment_3()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:989:1: ( rule__Abstraction__TermAssignment_3 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:989:2: rule__Abstraction__TermAssignment_3
            {
            pushFollow(FOLLOW_rule__Abstraction__TermAssignment_3_in_rule__Abstraction__Group__3__Impl2004);
            rule__Abstraction__TermAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbstractionAccess().getTermAssignment_3()); 
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
    // $ANTLR end "rule__Abstraction__Group__3__Impl"


    // $ANTLR start "rule__Parameter__Group__0"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1007:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1011:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1012:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
            {
            pushFollow(FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__02042);
            rule__Parameter__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__02045);
            rule__Parameter__Group__1();

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
    // $ANTLR end "rule__Parameter__Group__0"


    // $ANTLR start "rule__Parameter__Group__0__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1019:1: rule__Parameter__Group__0__Impl : ( ( rule__Parameter__NameAssignment_0 ) ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1023:1: ( ( ( rule__Parameter__NameAssignment_0 ) ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1024:1: ( ( rule__Parameter__NameAssignment_0 ) )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1024:1: ( ( rule__Parameter__NameAssignment_0 ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1025:1: ( rule__Parameter__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getNameAssignment_0()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1026:1: ( rule__Parameter__NameAssignment_0 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1026:2: rule__Parameter__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Parameter__NameAssignment_0_in_rule__Parameter__Group__0__Impl2072);
            rule__Parameter__NameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getNameAssignment_0()); 
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
    // $ANTLR end "rule__Parameter__Group__0__Impl"


    // $ANTLR start "rule__Parameter__Group__1"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1036:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1040:1: ( rule__Parameter__Group__1__Impl )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1041:2: rule__Parameter__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__12102);
            rule__Parameter__Group__1__Impl();

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
    // $ANTLR end "rule__Parameter__Group__1"


    // $ANTLR start "rule__Parameter__Group__1__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1047:1: rule__Parameter__Group__1__Impl : ( ( rule__Parameter__Group_1__0 )? ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1051:1: ( ( ( rule__Parameter__Group_1__0 )? ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1052:1: ( ( rule__Parameter__Group_1__0 )? )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1052:1: ( ( rule__Parameter__Group_1__0 )? )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1053:1: ( rule__Parameter__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getGroup_1()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1054:1: ( rule__Parameter__Group_1__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1054:2: rule__Parameter__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Parameter__Group_1__0_in_rule__Parameter__Group__1__Impl2129);
                    rule__Parameter__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getGroup_1()); 
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
    // $ANTLR end "rule__Parameter__Group__1__Impl"


    // $ANTLR start "rule__Parameter__Group_1__0"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1068:1: rule__Parameter__Group_1__0 : rule__Parameter__Group_1__0__Impl rule__Parameter__Group_1__1 ;
    public final void rule__Parameter__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1072:1: ( rule__Parameter__Group_1__0__Impl rule__Parameter__Group_1__1 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1073:2: rule__Parameter__Group_1__0__Impl rule__Parameter__Group_1__1
            {
            pushFollow(FOLLOW_rule__Parameter__Group_1__0__Impl_in_rule__Parameter__Group_1__02164);
            rule__Parameter__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Parameter__Group_1__1_in_rule__Parameter__Group_1__02167);
            rule__Parameter__Group_1__1();

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
    // $ANTLR end "rule__Parameter__Group_1__0"


    // $ANTLR start "rule__Parameter__Group_1__0__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1080:1: rule__Parameter__Group_1__0__Impl : ( ':' ) ;
    public final void rule__Parameter__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1084:1: ( ( ':' ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1085:1: ( ':' )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1085:1: ( ':' )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1086:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getColonKeyword_1_0()); 
            }
            match(input,16,FOLLOW_16_in_rule__Parameter__Group_1__0__Impl2195); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getColonKeyword_1_0()); 
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
    // $ANTLR end "rule__Parameter__Group_1__0__Impl"


    // $ANTLR start "rule__Parameter__Group_1__1"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1099:1: rule__Parameter__Group_1__1 : rule__Parameter__Group_1__1__Impl ;
    public final void rule__Parameter__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1103:1: ( rule__Parameter__Group_1__1__Impl )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1104:2: rule__Parameter__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Parameter__Group_1__1__Impl_in_rule__Parameter__Group_1__12226);
            rule__Parameter__Group_1__1__Impl();

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
    // $ANTLR end "rule__Parameter__Group_1__1"


    // $ANTLR start "rule__Parameter__Group_1__1__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1110:1: rule__Parameter__Group_1__1__Impl : ( ( rule__Parameter__TypeAssignment_1_1 ) ) ;
    public final void rule__Parameter__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1114:1: ( ( ( rule__Parameter__TypeAssignment_1_1 ) ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1115:1: ( ( rule__Parameter__TypeAssignment_1_1 ) )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1115:1: ( ( rule__Parameter__TypeAssignment_1_1 ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1116:1: ( rule__Parameter__TypeAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getTypeAssignment_1_1()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1117:1: ( rule__Parameter__TypeAssignment_1_1 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1117:2: rule__Parameter__TypeAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Parameter__TypeAssignment_1_1_in_rule__Parameter__Group_1__1__Impl2253);
            rule__Parameter__TypeAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getTypeAssignment_1_1()); 
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
    // $ANTLR end "rule__Parameter__Group_1__1__Impl"


    // $ANTLR start "rule__Type__Group__0"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1131:1: rule__Type__Group__0 : rule__Type__Group__0__Impl rule__Type__Group__1 ;
    public final void rule__Type__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1135:1: ( rule__Type__Group__0__Impl rule__Type__Group__1 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1136:2: rule__Type__Group__0__Impl rule__Type__Group__1
            {
            pushFollow(FOLLOW_rule__Type__Group__0__Impl_in_rule__Type__Group__02287);
            rule__Type__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Type__Group__1_in_rule__Type__Group__02290);
            rule__Type__Group__1();

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
    // $ANTLR end "rule__Type__Group__0"


    // $ANTLR start "rule__Type__Group__0__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1143:1: rule__Type__Group__0__Impl : ( ruleTerminalType ) ;
    public final void rule__Type__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1147:1: ( ( ruleTerminalType ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1148:1: ( ruleTerminalType )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1148:1: ( ruleTerminalType )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1149:1: ruleTerminalType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAccess().getTerminalTypeParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleTerminalType_in_rule__Type__Group__0__Impl2317);
            ruleTerminalType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeAccess().getTerminalTypeParserRuleCall_0()); 
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
    // $ANTLR end "rule__Type__Group__0__Impl"


    // $ANTLR start "rule__Type__Group__1"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1160:1: rule__Type__Group__1 : rule__Type__Group__1__Impl ;
    public final void rule__Type__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1164:1: ( rule__Type__Group__1__Impl )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1165:2: rule__Type__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Type__Group__1__Impl_in_rule__Type__Group__12346);
            rule__Type__Group__1__Impl();

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
    // $ANTLR end "rule__Type__Group__1"


    // $ANTLR start "rule__Type__Group__1__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1171:1: rule__Type__Group__1__Impl : ( ( rule__Type__Group_1__0 )? ) ;
    public final void rule__Type__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1175:1: ( ( ( rule__Type__Group_1__0 )? ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1176:1: ( ( rule__Type__Group_1__0 )? )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1176:1: ( ( rule__Type__Group_1__0 )? )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1177:1: ( rule__Type__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAccess().getGroup_1()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1178:1: ( rule__Type__Group_1__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1178:2: rule__Type__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Type__Group_1__0_in_rule__Type__Group__1__Impl2373);
                    rule__Type__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeAccess().getGroup_1()); 
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
    // $ANTLR end "rule__Type__Group__1__Impl"


    // $ANTLR start "rule__Type__Group_1__0"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1192:1: rule__Type__Group_1__0 : rule__Type__Group_1__0__Impl rule__Type__Group_1__1 ;
    public final void rule__Type__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1196:1: ( rule__Type__Group_1__0__Impl rule__Type__Group_1__1 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1197:2: rule__Type__Group_1__0__Impl rule__Type__Group_1__1
            {
            pushFollow(FOLLOW_rule__Type__Group_1__0__Impl_in_rule__Type__Group_1__02408);
            rule__Type__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Type__Group_1__1_in_rule__Type__Group_1__02411);
            rule__Type__Group_1__1();

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
    // $ANTLR end "rule__Type__Group_1__0"


    // $ANTLR start "rule__Type__Group_1__0__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1204:1: rule__Type__Group_1__0__Impl : ( () ) ;
    public final void rule__Type__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1208:1: ( ( () ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1209:1: ( () )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1209:1: ( () )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1210:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAccess().getArrowTypeLeftAction_1_0()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1211:1: ()
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1213:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeAccess().getArrowTypeLeftAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__Group_1__0__Impl"


    // $ANTLR start "rule__Type__Group_1__1"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1223:1: rule__Type__Group_1__1 : rule__Type__Group_1__1__Impl rule__Type__Group_1__2 ;
    public final void rule__Type__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1227:1: ( rule__Type__Group_1__1__Impl rule__Type__Group_1__2 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1228:2: rule__Type__Group_1__1__Impl rule__Type__Group_1__2
            {
            pushFollow(FOLLOW_rule__Type__Group_1__1__Impl_in_rule__Type__Group_1__12469);
            rule__Type__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Type__Group_1__2_in_rule__Type__Group_1__12472);
            rule__Type__Group_1__2();

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
    // $ANTLR end "rule__Type__Group_1__1"


    // $ANTLR start "rule__Type__Group_1__1__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1235:1: rule__Type__Group_1__1__Impl : ( '->' ) ;
    public final void rule__Type__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1239:1: ( ( '->' ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1240:1: ( '->' )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1240:1: ( '->' )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1241:1: '->'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAccess().getHyphenMinusGreaterThanSignKeyword_1_1()); 
            }
            match(input,17,FOLLOW_17_in_rule__Type__Group_1__1__Impl2500); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeAccess().getHyphenMinusGreaterThanSignKeyword_1_1()); 
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
    // $ANTLR end "rule__Type__Group_1__1__Impl"


    // $ANTLR start "rule__Type__Group_1__2"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1254:1: rule__Type__Group_1__2 : rule__Type__Group_1__2__Impl ;
    public final void rule__Type__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1258:1: ( rule__Type__Group_1__2__Impl )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1259:2: rule__Type__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Type__Group_1__2__Impl_in_rule__Type__Group_1__22531);
            rule__Type__Group_1__2__Impl();

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
    // $ANTLR end "rule__Type__Group_1__2"


    // $ANTLR start "rule__Type__Group_1__2__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1265:1: rule__Type__Group_1__2__Impl : ( ( rule__Type__RightAssignment_1_2 ) ) ;
    public final void rule__Type__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1269:1: ( ( ( rule__Type__RightAssignment_1_2 ) ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1270:1: ( ( rule__Type__RightAssignment_1_2 ) )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1270:1: ( ( rule__Type__RightAssignment_1_2 ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1271:1: ( rule__Type__RightAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAccess().getRightAssignment_1_2()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1272:1: ( rule__Type__RightAssignment_1_2 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1272:2: rule__Type__RightAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Type__RightAssignment_1_2_in_rule__Type__Group_1__2__Impl2558);
            rule__Type__RightAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeAccess().getRightAssignment_1_2()); 
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
    // $ANTLR end "rule__Type__Group_1__2__Impl"


    // $ANTLR start "rule__TerminalType__Group_0__0"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1288:1: rule__TerminalType__Group_0__0 : rule__TerminalType__Group_0__0__Impl rule__TerminalType__Group_0__1 ;
    public final void rule__TerminalType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1292:1: ( rule__TerminalType__Group_0__0__Impl rule__TerminalType__Group_0__1 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1293:2: rule__TerminalType__Group_0__0__Impl rule__TerminalType__Group_0__1
            {
            pushFollow(FOLLOW_rule__TerminalType__Group_0__0__Impl_in_rule__TerminalType__Group_0__02594);
            rule__TerminalType__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalType__Group_0__1_in_rule__TerminalType__Group_0__02597);
            rule__TerminalType__Group_0__1();

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
    // $ANTLR end "rule__TerminalType__Group_0__0"


    // $ANTLR start "rule__TerminalType__Group_0__0__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1300:1: rule__TerminalType__Group_0__0__Impl : ( '(' ) ;
    public final void rule__TerminalType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1304:1: ( ( '(' ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1305:1: ( '(' )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1305:1: ( '(' )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1306:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalTypeAccess().getLeftParenthesisKeyword_0_0()); 
            }
            match(input,11,FOLLOW_11_in_rule__TerminalType__Group_0__0__Impl2625); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalTypeAccess().getLeftParenthesisKeyword_0_0()); 
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
    // $ANTLR end "rule__TerminalType__Group_0__0__Impl"


    // $ANTLR start "rule__TerminalType__Group_0__1"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1319:1: rule__TerminalType__Group_0__1 : rule__TerminalType__Group_0__1__Impl rule__TerminalType__Group_0__2 ;
    public final void rule__TerminalType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1323:1: ( rule__TerminalType__Group_0__1__Impl rule__TerminalType__Group_0__2 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1324:2: rule__TerminalType__Group_0__1__Impl rule__TerminalType__Group_0__2
            {
            pushFollow(FOLLOW_rule__TerminalType__Group_0__1__Impl_in_rule__TerminalType__Group_0__12656);
            rule__TerminalType__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalType__Group_0__2_in_rule__TerminalType__Group_0__12659);
            rule__TerminalType__Group_0__2();

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
    // $ANTLR end "rule__TerminalType__Group_0__1"


    // $ANTLR start "rule__TerminalType__Group_0__1__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1331:1: rule__TerminalType__Group_0__1__Impl : ( ruleType ) ;
    public final void rule__TerminalType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1335:1: ( ( ruleType ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1336:1: ( ruleType )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1336:1: ( ruleType )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1337:1: ruleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalTypeAccess().getTypeParserRuleCall_0_1()); 
            }
            pushFollow(FOLLOW_ruleType_in_rule__TerminalType__Group_0__1__Impl2686);
            ruleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalTypeAccess().getTypeParserRuleCall_0_1()); 
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
    // $ANTLR end "rule__TerminalType__Group_0__1__Impl"


    // $ANTLR start "rule__TerminalType__Group_0__2"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1348:1: rule__TerminalType__Group_0__2 : rule__TerminalType__Group_0__2__Impl ;
    public final void rule__TerminalType__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1352:1: ( rule__TerminalType__Group_0__2__Impl )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1353:2: rule__TerminalType__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__TerminalType__Group_0__2__Impl_in_rule__TerminalType__Group_0__22715);
            rule__TerminalType__Group_0__2__Impl();

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
    // $ANTLR end "rule__TerminalType__Group_0__2"


    // $ANTLR start "rule__TerminalType__Group_0__2__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1359:1: rule__TerminalType__Group_0__2__Impl : ( ')' ) ;
    public final void rule__TerminalType__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1363:1: ( ( ')' ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1364:1: ( ')' )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1364:1: ( ')' )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1365:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalTypeAccess().getRightParenthesisKeyword_0_2()); 
            }
            match(input,12,FOLLOW_12_in_rule__TerminalType__Group_0__2__Impl2743); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalTypeAccess().getRightParenthesisKeyword_0_2()); 
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
    // $ANTLR end "rule__TerminalType__Group_0__2__Impl"


    // $ANTLR start "rule__BasicType__Group_0__0"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1384:1: rule__BasicType__Group_0__0 : rule__BasicType__Group_0__0__Impl rule__BasicType__Group_0__1 ;
    public final void rule__BasicType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1388:1: ( rule__BasicType__Group_0__0__Impl rule__BasicType__Group_0__1 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1389:2: rule__BasicType__Group_0__0__Impl rule__BasicType__Group_0__1
            {
            pushFollow(FOLLOW_rule__BasicType__Group_0__0__Impl_in_rule__BasicType__Group_0__02780);
            rule__BasicType__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BasicType__Group_0__1_in_rule__BasicType__Group_0__02783);
            rule__BasicType__Group_0__1();

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
    // $ANTLR end "rule__BasicType__Group_0__0"


    // $ANTLR start "rule__BasicType__Group_0__0__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1396:1: rule__BasicType__Group_0__0__Impl : ( () ) ;
    public final void rule__BasicType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1400:1: ( ( () ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1401:1: ( () )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1401:1: ( () )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1402:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBasicTypeAccess().getIntTypeAction_0_0()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1403:1: ()
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1405:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBasicTypeAccess().getIntTypeAction_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BasicType__Group_0__0__Impl"


    // $ANTLR start "rule__BasicType__Group_0__1"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1415:1: rule__BasicType__Group_0__1 : rule__BasicType__Group_0__1__Impl ;
    public final void rule__BasicType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1419:1: ( rule__BasicType__Group_0__1__Impl )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1420:2: rule__BasicType__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__BasicType__Group_0__1__Impl_in_rule__BasicType__Group_0__12841);
            rule__BasicType__Group_0__1__Impl();

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
    // $ANTLR end "rule__BasicType__Group_0__1"


    // $ANTLR start "rule__BasicType__Group_0__1__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1426:1: rule__BasicType__Group_0__1__Impl : ( 'int' ) ;
    public final void rule__BasicType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1430:1: ( ( 'int' ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1431:1: ( 'int' )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1431:1: ( 'int' )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1432:1: 'int'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBasicTypeAccess().getIntKeyword_0_1()); 
            }
            match(input,18,FOLLOW_18_in_rule__BasicType__Group_0__1__Impl2869); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBasicTypeAccess().getIntKeyword_0_1()); 
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
    // $ANTLR end "rule__BasicType__Group_0__1__Impl"


    // $ANTLR start "rule__BasicType__Group_1__0"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1449:1: rule__BasicType__Group_1__0 : rule__BasicType__Group_1__0__Impl rule__BasicType__Group_1__1 ;
    public final void rule__BasicType__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1453:1: ( rule__BasicType__Group_1__0__Impl rule__BasicType__Group_1__1 )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1454:2: rule__BasicType__Group_1__0__Impl rule__BasicType__Group_1__1
            {
            pushFollow(FOLLOW_rule__BasicType__Group_1__0__Impl_in_rule__BasicType__Group_1__02904);
            rule__BasicType__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BasicType__Group_1__1_in_rule__BasicType__Group_1__02907);
            rule__BasicType__Group_1__1();

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
    // $ANTLR end "rule__BasicType__Group_1__0"


    // $ANTLR start "rule__BasicType__Group_1__0__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1461:1: rule__BasicType__Group_1__0__Impl : ( () ) ;
    public final void rule__BasicType__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1465:1: ( ( () ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1466:1: ( () )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1466:1: ( () )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1467:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBasicTypeAccess().getStringTypeAction_1_0()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1468:1: ()
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1470:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBasicTypeAccess().getStringTypeAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BasicType__Group_1__0__Impl"


    // $ANTLR start "rule__BasicType__Group_1__1"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1480:1: rule__BasicType__Group_1__1 : rule__BasicType__Group_1__1__Impl ;
    public final void rule__BasicType__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1484:1: ( rule__BasicType__Group_1__1__Impl )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1485:2: rule__BasicType__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__BasicType__Group_1__1__Impl_in_rule__BasicType__Group_1__12965);
            rule__BasicType__Group_1__1__Impl();

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
    // $ANTLR end "rule__BasicType__Group_1__1"


    // $ANTLR start "rule__BasicType__Group_1__1__Impl"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1491:1: rule__BasicType__Group_1__1__Impl : ( 'string' ) ;
    public final void rule__BasicType__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1495:1: ( ( 'string' ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1496:1: ( 'string' )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1496:1: ( 'string' )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1497:1: 'string'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBasicTypeAccess().getStringKeyword_1_1()); 
            }
            match(input,19,FOLLOW_19_in_rule__BasicType__Group_1__1__Impl2993); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBasicTypeAccess().getStringKeyword_1_1()); 
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
    // $ANTLR end "rule__BasicType__Group_1__1__Impl"


    // $ANTLR start "rule__Program__TermAssignment"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1515:1: rule__Program__TermAssignment : ( ruleTerm ) ;
    public final void rule__Program__TermAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1519:1: ( ( ruleTerm ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1520:1: ( ruleTerm )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1520:1: ( ruleTerm )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1521:1: ruleTerm
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getTermTermParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleTerm_in_rule__Program__TermAssignment3033);
            ruleTerm();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getTermTermParserRuleCall_0()); 
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
    // $ANTLR end "rule__Program__TermAssignment"


    // $ANTLR start "rule__Term__ArgAssignment_1_0_1"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1530:1: rule__Term__ArgAssignment_1_0_1 : ( ruleTerminalTerm ) ;
    public final void rule__Term__ArgAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1534:1: ( ( ruleTerminalTerm ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1535:1: ( ruleTerminalTerm )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1535:1: ( ruleTerminalTerm )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1536:1: ruleTerminalTerm
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTermAccess().getArgTerminalTermParserRuleCall_1_0_1_0()); 
            }
            pushFollow(FOLLOW_ruleTerminalTerm_in_rule__Term__ArgAssignment_1_0_13064);
            ruleTerminalTerm();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTermAccess().getArgTerminalTermParserRuleCall_1_0_1_0()); 
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
    // $ANTLR end "rule__Term__ArgAssignment_1_0_1"


    // $ANTLR start "rule__StringConstant__StringAssignment"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1545:1: rule__StringConstant__StringAssignment : ( RULE_STRING ) ;
    public final void rule__StringConstant__StringAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1549:1: ( ( RULE_STRING ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1550:1: ( RULE_STRING )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1550:1: ( RULE_STRING )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1551:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringConstantAccess().getStringSTRINGTerminalRuleCall_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringConstant__StringAssignment3095); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringConstantAccess().getStringSTRINGTerminalRuleCall_0()); 
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
    // $ANTLR end "rule__StringConstant__StringAssignment"


    // $ANTLR start "rule__IntConstant__IntAssignment"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1560:1: rule__IntConstant__IntAssignment : ( RULE_INT ) ;
    public final void rule__IntConstant__IntAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1564:1: ( ( RULE_INT ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1565:1: ( RULE_INT )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1565:1: ( RULE_INT )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1566:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntConstantAccess().getIntINTTerminalRuleCall_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__IntConstant__IntAssignment3126); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntConstantAccess().getIntINTTerminalRuleCall_0()); 
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
    // $ANTLR end "rule__IntConstant__IntAssignment"


    // $ANTLR start "rule__Arithmetics__TermAssignment_1"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1575:1: rule__Arithmetics__TermAssignment_1 : ( ruleTerm ) ;
    public final void rule__Arithmetics__TermAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1579:1: ( ( ruleTerm ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1580:1: ( ruleTerm )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1580:1: ( ruleTerm )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1581:1: ruleTerm
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArithmeticsAccess().getTermTermParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleTerm_in_rule__Arithmetics__TermAssignment_13157);
            ruleTerm();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArithmeticsAccess().getTermTermParserRuleCall_1_0()); 
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
    // $ANTLR end "rule__Arithmetics__TermAssignment_1"


    // $ANTLR start "rule__Variable__RefAssignment"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1590:1: rule__Variable__RefAssignment : ( ( RULE_ID ) ) ;
    public final void rule__Variable__RefAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1594:1: ( ( ( RULE_ID ) ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1595:1: ( ( RULE_ID ) )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1595:1: ( ( RULE_ID ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1596:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableAccess().getRefParameterCrossReference_0()); 
            }
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1597:1: ( RULE_ID )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1598:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariableAccess().getRefParameterIDTerminalRuleCall_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Variable__RefAssignment3192); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableAccess().getRefParameterIDTerminalRuleCall_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVariableAccess().getRefParameterCrossReference_0()); 
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
    // $ANTLR end "rule__Variable__RefAssignment"


    // $ANTLR start "rule__Abstraction__ParamAssignment_1"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1609:1: rule__Abstraction__ParamAssignment_1 : ( ruleParameter ) ;
    public final void rule__Abstraction__ParamAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1613:1: ( ( ruleParameter ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1614:1: ( ruleParameter )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1614:1: ( ruleParameter )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1615:1: ruleParameter
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbstractionAccess().getParamParameterParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleParameter_in_rule__Abstraction__ParamAssignment_13227);
            ruleParameter();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbstractionAccess().getParamParameterParserRuleCall_1_0()); 
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
    // $ANTLR end "rule__Abstraction__ParamAssignment_1"


    // $ANTLR start "rule__Abstraction__TermAssignment_3"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1624:1: rule__Abstraction__TermAssignment_3 : ( ruleTerm ) ;
    public final void rule__Abstraction__TermAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1628:1: ( ( ruleTerm ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1629:1: ( ruleTerm )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1629:1: ( ruleTerm )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1630:1: ruleTerm
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbstractionAccess().getTermTermParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleTerm_in_rule__Abstraction__TermAssignment_33258);
            ruleTerm();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbstractionAccess().getTermTermParserRuleCall_3_0()); 
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
    // $ANTLR end "rule__Abstraction__TermAssignment_3"


    // $ANTLR start "rule__Parameter__NameAssignment_0"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1639:1: rule__Parameter__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Parameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1643:1: ( ( RULE_ID ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1644:1: ( RULE_ID )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1644:1: ( RULE_ID )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1645:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Parameter__NameAssignment_03289); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0_0()); 
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
    // $ANTLR end "rule__Parameter__NameAssignment_0"


    // $ANTLR start "rule__Parameter__TypeAssignment_1_1"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1654:1: rule__Parameter__TypeAssignment_1_1 : ( ruleType ) ;
    public final void rule__Parameter__TypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1658:1: ( ( ruleType ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1659:1: ( ruleType )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1659:1: ( ruleType )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1660:1: ruleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleType_in_rule__Parameter__TypeAssignment_1_13320);
            ruleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__Parameter__TypeAssignment_1_1"


    // $ANTLR start "rule__Type__RightAssignment_1_2"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1669:1: rule__Type__RightAssignment_1_2 : ( ruleType ) ;
    public final void rule__Type__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1673:1: ( ( ruleType ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1674:1: ( ruleType )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1674:1: ( ruleType )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1675:1: ruleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAccess().getRightTypeParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleType_in_rule__Type__RightAssignment_1_23351);
            ruleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeAccess().getRightTypeParserRuleCall_1_2_0()); 
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
    // $ANTLR end "rule__Type__RightAssignment_1_2"


    // $ANTLR start "rule__TypeVariable__TypevarNameAssignment"
    // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1684:1: rule__TypeVariable__TypevarNameAssignment : ( RULE_ID ) ;
    public final void rule__TypeVariable__TypevarNameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1688:1: ( ( RULE_ID ) )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1689:1: ( RULE_ID )
            {
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1689:1: ( RULE_ID )
            // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:1690:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeVariableAccess().getTypevarNameIDTerminalRuleCall_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__TypeVariable__TypevarNameAssignment3382); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeVariableAccess().getTypevarNameIDTerminalRuleCall_0()); 
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
    // $ANTLR end "rule__TypeVariable__TypevarNameAssignment"

    // $ANTLR start synpred9_InternalLambda
    public final void synpred9_InternalLambda_fragment() throws RecognitionException {   
        // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:614:2: ( rule__Term__Group_1__0 )
        // ../it.xsemantics.example.lambda.ui/src-gen/it/xsemantics/example/lambda/ui/contentassist/antlr/internal/InternalLambda.g:614:2: rule__Term__Group_1__0
        {
        pushFollow(FOLLOW_rule__Term__Group_1__0_in_synpred9_InternalLambda1268);
        rule__Term__Group_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_InternalLambda

    // Delegated rules

    public final boolean synpred9_InternalLambda() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalLambda_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\12\uffff";
    static final String DFA5_eofS =
        "\1\1\11\uffff";
    static final String DFA5_minS =
        "\1\4\2\uffff\6\0\1\uffff";
    static final String DFA5_maxS =
        "\1\16\2\uffff\6\0\1\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\2\7\uffff\1\1";
    static final String DFA5_specialS =
        "\3\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\4\1\5\1\7\4\uffff\1\3\1\1\1\6\1\10",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "()* loopback of 614:1: ( rule__Term__Group_1__0 )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA5_3 = input.LA(1);

                         
                        int index5_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalLambda()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index5_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA5_4 = input.LA(1);

                         
                        int index5_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalLambda()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index5_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA5_5 = input.LA(1);

                         
                        int index5_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalLambda()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index5_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA5_6 = input.LA(1);

                         
                        int index5_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalLambda()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index5_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA5_7 = input.LA(1);

                         
                        int index5_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalLambda()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index5_7);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA5_8 = input.LA(1);

                         
                        int index5_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalLambda()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index5_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 5, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleProgram_in_entryRuleProgram67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProgram74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Program__TermAssignment_in_ruleProgram100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerm_in_entryRuleTerm127 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerm134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Term__Group__0_in_ruleTerm160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTerm_in_entryRuleTerminalTerm187 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalTerm194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalTerm__Alternatives_in_ruleTerminalTerm220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_entryRuleConstant247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstant254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Alternatives_in_ruleConstant280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringConstant_in_entryRuleStringConstant307 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringConstant314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringConstant__StringAssignment_in_ruleStringConstant340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntConstant_in_entryRuleIntConstant367 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntConstant374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntConstant__IntAssignment_in_ruleIntConstant400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArithmetics_in_entryRuleArithmetics427 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArithmetics434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arithmetics__Group__0_in_ruleArithmetics460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable487 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__RefAssignment_in_ruleVariable520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstraction_in_entryRuleAbstraction547 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstraction554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Abstraction__Group__0_in_ruleAbstraction580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter607 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__0_in_ruleParameter640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType667 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Group__0_in_ruleType700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalType_in_entryRuleTerminalType727 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalType734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalType__Alternatives_in_ruleTerminalType760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicType_in_entryRuleBasicType787 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBasicType794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicType__Alternatives_in_ruleBasicType820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeVariable_in_entryRuleTypeVariable847 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeVariable854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeVariable__TypevarNameAssignment_in_ruleTypeVariable880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalTerm__Group_0__0_in_rule__TerminalTerm__Alternatives916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_rule__TerminalTerm__Alternatives934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArithmetics_in_rule__TerminalTerm__Alternatives951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__TerminalTerm__Alternatives968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstraction_in_rule__TerminalTerm__Alternatives985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringConstant_in_rule__Constant__Alternatives1017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntConstant_in_rule__Constant__Alternatives1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalType__Group_0__0_in_rule__TerminalType__Alternatives1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicType_in_rule__TerminalType__Alternatives1084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeVariable_in_rule__TerminalType__Alternatives1101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicType__Group_0__0_in_rule__BasicType__Alternatives1133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicType__Group_1__0_in_rule__BasicType__Alternatives1151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Term__Group__0__Impl_in_rule__Term__Group__01182 = new BitSet(new long[]{0x0000000000006870L});
    public static final BitSet FOLLOW_rule__Term__Group__1_in_rule__Term__Group__01185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTerm_in_rule__Term__Group__0__Impl1212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Term__Group__1__Impl_in_rule__Term__Group__11241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Term__Group_1__0_in_rule__Term__Group__1__Impl1268 = new BitSet(new long[]{0x0000000000006872L});
    public static final BitSet FOLLOW_rule__Term__Group_1__0__Impl_in_rule__Term__Group_1__01303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Term__Group_1_0__0_in_rule__Term__Group_1__0__Impl1330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Term__Group_1_0__0__Impl_in_rule__Term__Group_1_0__01362 = new BitSet(new long[]{0x0000000000006870L});
    public static final BitSet FOLLOW_rule__Term__Group_1_0__1_in_rule__Term__Group_1_0__01365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Term__Group_1_0__1__Impl_in_rule__Term__Group_1_0__11423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Term__ArgAssignment_1_0_1_in_rule__Term__Group_1_0__1__Impl1450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalTerm__Group_0__0__Impl_in_rule__TerminalTerm__Group_0__01484 = new BitSet(new long[]{0x0000000000006870L});
    public static final BitSet FOLLOW_rule__TerminalTerm__Group_0__1_in_rule__TerminalTerm__Group_0__01487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__TerminalTerm__Group_0__0__Impl1515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalTerm__Group_0__1__Impl_in_rule__TerminalTerm__Group_0__11546 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__TerminalTerm__Group_0__2_in_rule__TerminalTerm__Group_0__11549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerm_in_rule__TerminalTerm__Group_0__1__Impl1576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalTerm__Group_0__2__Impl_in_rule__TerminalTerm__Group_0__21605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__TerminalTerm__Group_0__2__Impl1633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arithmetics__Group__0__Impl_in_rule__Arithmetics__Group__01670 = new BitSet(new long[]{0x0000000000006870L});
    public static final BitSet FOLLOW_rule__Arithmetics__Group__1_in_rule__Arithmetics__Group__01673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Arithmetics__Group__0__Impl1701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arithmetics__Group__1__Impl_in_rule__Arithmetics__Group__11732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arithmetics__TermAssignment_1_in_rule__Arithmetics__Group__1__Impl1759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Abstraction__Group__0__Impl_in_rule__Abstraction__Group__01793 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Abstraction__Group__1_in_rule__Abstraction__Group__01796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Abstraction__Group__0__Impl1824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Abstraction__Group__1__Impl_in_rule__Abstraction__Group__11855 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Abstraction__Group__2_in_rule__Abstraction__Group__11858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Abstraction__ParamAssignment_1_in_rule__Abstraction__Group__1__Impl1885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Abstraction__Group__2__Impl_in_rule__Abstraction__Group__21915 = new BitSet(new long[]{0x0000000000006870L});
    public static final BitSet FOLLOW_rule__Abstraction__Group__3_in_rule__Abstraction__Group__21918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Abstraction__Group__2__Impl1946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Abstraction__Group__3__Impl_in_rule__Abstraction__Group__31977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Abstraction__TermAssignment_3_in_rule__Abstraction__Group__3__Impl2004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__02042 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__02045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__NameAssignment_0_in_rule__Parameter__Group__0__Impl2072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__12102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group_1__0_in_rule__Parameter__Group__1__Impl2129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group_1__0__Impl_in_rule__Parameter__Group_1__02164 = new BitSet(new long[]{0x00000000000C0840L});
    public static final BitSet FOLLOW_rule__Parameter__Group_1__1_in_rule__Parameter__Group_1__02167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Parameter__Group_1__0__Impl2195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group_1__1__Impl_in_rule__Parameter__Group_1__12226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__TypeAssignment_1_1_in_rule__Parameter__Group_1__1__Impl2253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Group__0__Impl_in_rule__Type__Group__02287 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Type__Group__1_in_rule__Type__Group__02290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalType_in_rule__Type__Group__0__Impl2317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Group__1__Impl_in_rule__Type__Group__12346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Group_1__0_in_rule__Type__Group__1__Impl2373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Group_1__0__Impl_in_rule__Type__Group_1__02408 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Type__Group_1__1_in_rule__Type__Group_1__02411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Group_1__1__Impl_in_rule__Type__Group_1__12469 = new BitSet(new long[]{0x00000000000C0840L});
    public static final BitSet FOLLOW_rule__Type__Group_1__2_in_rule__Type__Group_1__12472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Type__Group_1__1__Impl2500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Group_1__2__Impl_in_rule__Type__Group_1__22531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__RightAssignment_1_2_in_rule__Type__Group_1__2__Impl2558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalType__Group_0__0__Impl_in_rule__TerminalType__Group_0__02594 = new BitSet(new long[]{0x00000000000C0840L});
    public static final BitSet FOLLOW_rule__TerminalType__Group_0__1_in_rule__TerminalType__Group_0__02597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__TerminalType__Group_0__0__Impl2625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalType__Group_0__1__Impl_in_rule__TerminalType__Group_0__12656 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__TerminalType__Group_0__2_in_rule__TerminalType__Group_0__12659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_rule__TerminalType__Group_0__1__Impl2686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalType__Group_0__2__Impl_in_rule__TerminalType__Group_0__22715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__TerminalType__Group_0__2__Impl2743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicType__Group_0__0__Impl_in_rule__BasicType__Group_0__02780 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__BasicType__Group_0__1_in_rule__BasicType__Group_0__02783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicType__Group_0__1__Impl_in_rule__BasicType__Group_0__12841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__BasicType__Group_0__1__Impl2869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicType__Group_1__0__Impl_in_rule__BasicType__Group_1__02904 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_rule__BasicType__Group_1__1_in_rule__BasicType__Group_1__02907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicType__Group_1__1__Impl_in_rule__BasicType__Group_1__12965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__BasicType__Group_1__1__Impl2993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerm_in_rule__Program__TermAssignment3033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTerm_in_rule__Term__ArgAssignment_1_0_13064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringConstant__StringAssignment3095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__IntConstant__IntAssignment3126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerm_in_rule__Arithmetics__TermAssignment_13157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Variable__RefAssignment3192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_rule__Abstraction__ParamAssignment_13227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerm_in_rule__Abstraction__TermAssignment_33258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Parameter__NameAssignment_03289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_rule__Parameter__TypeAssignment_1_13320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_rule__Type__RightAssignment_1_23351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__TypeVariable__TypevarNameAssignment3382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Term__Group_1__0_in_synpred9_InternalLambda1268 = new BitSet(new long[]{0x0000000000000002L});

}