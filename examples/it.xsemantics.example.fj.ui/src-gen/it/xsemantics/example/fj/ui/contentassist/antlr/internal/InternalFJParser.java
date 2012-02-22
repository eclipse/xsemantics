package it.xsemantics.example.fj.ui.contentassist.antlr.internal; 

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
import it.xsemantics.example.fj.services.FJGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalFJParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'int'", "'boolean'", "'String'", "'true'", "'false'", "'class'", "'{'", "'}'", "'extends'", "';'", "'('", "')'", "','", "'return'", "'.'", "'new'", "'this'"
    };
    public static final int RULE_ID=4;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
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
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalFJParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalFJParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalFJParser.tokenNames; }
    public String getGrammarFileName() { return "../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g"; }


     
     	private FJGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(FJGrammarAccess grammarAccess) {
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
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:61:1: entryRuleProgram : ruleProgram EOF ;
    public final void entryRuleProgram() throws RecognitionException {
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:62:1: ( ruleProgram EOF )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:63:1: ruleProgram EOF
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
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:70:1: ruleProgram : ( ( rule__Program__Group__0 ) ) ;
    public final void ruleProgram() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:74:2: ( ( ( rule__Program__Group__0 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:75:1: ( ( rule__Program__Group__0 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:75:1: ( ( rule__Program__Group__0 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:76:1: ( rule__Program__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getGroup()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:77:1: ( rule__Program__Group__0 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:77:2: rule__Program__Group__0
            {
            pushFollow(FOLLOW_rule__Program__Group__0_in_ruleProgram100);
            rule__Program__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getGroup()); 
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


    // $ANTLR start "entryRuleType"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:89:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:90:1: ( ruleType EOF )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:91:1: ruleType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_ruleType_in_entryRuleType127);
            ruleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleType134); if (state.failed) return ;

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
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:98:1: ruleType : ( ( rule__Type__Alternatives ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:102:2: ( ( ( rule__Type__Alternatives ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:103:1: ( ( rule__Type__Alternatives ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:103:1: ( ( rule__Type__Alternatives ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:104:1: ( rule__Type__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAccess().getAlternatives()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:105:1: ( rule__Type__Alternatives )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:105:2: rule__Type__Alternatives
            {
            pushFollow(FOLLOW_rule__Type__Alternatives_in_ruleType160);
            rule__Type__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeAccess().getAlternatives()); 
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


    // $ANTLR start "entryRuleBasicType"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:117:1: entryRuleBasicType : ruleBasicType EOF ;
    public final void entryRuleBasicType() throws RecognitionException {
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:118:1: ( ruleBasicType EOF )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:119:1: ruleBasicType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBasicTypeRule()); 
            }
            pushFollow(FOLLOW_ruleBasicType_in_entryRuleBasicType187);
            ruleBasicType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBasicTypeRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBasicType194); if (state.failed) return ;

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
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:126:1: ruleBasicType : ( ( rule__BasicType__BasicAssignment ) ) ;
    public final void ruleBasicType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:130:2: ( ( ( rule__BasicType__BasicAssignment ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:131:1: ( ( rule__BasicType__BasicAssignment ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:131:1: ( ( rule__BasicType__BasicAssignment ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:132:1: ( rule__BasicType__BasicAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBasicTypeAccess().getBasicAssignment()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:133:1: ( rule__BasicType__BasicAssignment )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:133:2: rule__BasicType__BasicAssignment
            {
            pushFollow(FOLLOW_rule__BasicType__BasicAssignment_in_ruleBasicType220);
            rule__BasicType__BasicAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBasicTypeAccess().getBasicAssignment()); 
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


    // $ANTLR start "entryRuleClassType"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:145:1: entryRuleClassType : ruleClassType EOF ;
    public final void entryRuleClassType() throws RecognitionException {
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:146:1: ( ruleClassType EOF )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:147:1: ruleClassType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassTypeRule()); 
            }
            pushFollow(FOLLOW_ruleClassType_in_entryRuleClassType247);
            ruleClassType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassTypeRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassType254); if (state.failed) return ;

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
    // $ANTLR end "entryRuleClassType"


    // $ANTLR start "ruleClassType"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:154:1: ruleClassType : ( ( rule__ClassType__ClassrefAssignment ) ) ;
    public final void ruleClassType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:158:2: ( ( ( rule__ClassType__ClassrefAssignment ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:159:1: ( ( rule__ClassType__ClassrefAssignment ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:159:1: ( ( rule__ClassType__ClassrefAssignment ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:160:1: ( rule__ClassType__ClassrefAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassTypeAccess().getClassrefAssignment()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:161:1: ( rule__ClassType__ClassrefAssignment )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:161:2: rule__ClassType__ClassrefAssignment
            {
            pushFollow(FOLLOW_rule__ClassType__ClassrefAssignment_in_ruleClassType280);
            rule__ClassType__ClassrefAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassTypeAccess().getClassrefAssignment()); 
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
    // $ANTLR end "ruleClassType"


    // $ANTLR start "entryRuleClass"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:173:1: entryRuleClass : ruleClass EOF ;
    public final void entryRuleClass() throws RecognitionException {
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:174:1: ( ruleClass EOF )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:175:1: ruleClass EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassRule()); 
            }
            pushFollow(FOLLOW_ruleClass_in_entryRuleClass307);
            ruleClass();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleClass314); if (state.failed) return ;

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
    // $ANTLR end "entryRuleClass"


    // $ANTLR start "ruleClass"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:182:1: ruleClass : ( ( rule__Class__Group__0 ) ) ;
    public final void ruleClass() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:186:2: ( ( ( rule__Class__Group__0 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:187:1: ( ( rule__Class__Group__0 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:187:1: ( ( rule__Class__Group__0 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:188:1: ( rule__Class__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassAccess().getGroup()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:189:1: ( rule__Class__Group__0 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:189:2: rule__Class__Group__0
            {
            pushFollow(FOLLOW_rule__Class__Group__0_in_ruleClass340);
            rule__Class__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassAccess().getGroup()); 
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
    // $ANTLR end "ruleClass"


    // $ANTLR start "entryRuleMember"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:201:1: entryRuleMember : ruleMember EOF ;
    public final void entryRuleMember() throws RecognitionException {
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:202:1: ( ruleMember EOF )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:203:1: ruleMember EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMemberRule()); 
            }
            pushFollow(FOLLOW_ruleMember_in_entryRuleMember367);
            ruleMember();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMemberRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMember374); if (state.failed) return ;

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
    // $ANTLR end "entryRuleMember"


    // $ANTLR start "ruleMember"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:210:1: ruleMember : ( ( rule__Member__Alternatives ) ) ;
    public final void ruleMember() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:214:2: ( ( ( rule__Member__Alternatives ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:215:1: ( ( rule__Member__Alternatives ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:215:1: ( ( rule__Member__Alternatives ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:216:1: ( rule__Member__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMemberAccess().getAlternatives()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:217:1: ( rule__Member__Alternatives )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:217:2: rule__Member__Alternatives
            {
            pushFollow(FOLLOW_rule__Member__Alternatives_in_ruleMember400);
            rule__Member__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMemberAccess().getAlternatives()); 
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
    // $ANTLR end "ruleMember"


    // $ANTLR start "entryRuleField"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:229:1: entryRuleField : ruleField EOF ;
    public final void entryRuleField() throws RecognitionException {
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:230:1: ( ruleField EOF )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:231:1: ruleField EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldRule()); 
            }
            pushFollow(FOLLOW_ruleField_in_entryRuleField427);
            ruleField();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleField434); if (state.failed) return ;

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
    // $ANTLR end "entryRuleField"


    // $ANTLR start "ruleField"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:238:1: ruleField : ( ( rule__Field__Group__0 ) ) ;
    public final void ruleField() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:242:2: ( ( ( rule__Field__Group__0 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:243:1: ( ( rule__Field__Group__0 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:243:1: ( ( rule__Field__Group__0 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:244:1: ( rule__Field__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getGroup()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:245:1: ( rule__Field__Group__0 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:245:2: rule__Field__Group__0
            {
            pushFollow(FOLLOW_rule__Field__Group__0_in_ruleField460);
            rule__Field__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getGroup()); 
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
    // $ANTLR end "ruleField"


    // $ANTLR start "entryRuleMethod"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:257:1: entryRuleMethod : ruleMethod EOF ;
    public final void entryRuleMethod() throws RecognitionException {
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:258:1: ( ruleMethod EOF )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:259:1: ruleMethod EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodRule()); 
            }
            pushFollow(FOLLOW_ruleMethod_in_entryRuleMethod487);
            ruleMethod();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethod494); if (state.failed) return ;

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
    // $ANTLR end "entryRuleMethod"


    // $ANTLR start "ruleMethod"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:266:1: ruleMethod : ( ( rule__Method__Group__0 ) ) ;
    public final void ruleMethod() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:270:2: ( ( ( rule__Method__Group__0 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:271:1: ( ( rule__Method__Group__0 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:271:1: ( ( rule__Method__Group__0 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:272:1: ( rule__Method__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getGroup()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:273:1: ( rule__Method__Group__0 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:273:2: rule__Method__Group__0
            {
            pushFollow(FOLLOW_rule__Method__Group__0_in_ruleMethod520);
            rule__Method__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getGroup()); 
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
    // $ANTLR end "ruleMethod"


    // $ANTLR start "entryRuleParameter"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:285:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:286:1: ( ruleParameter EOF )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:287:1: ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterRule()); 
            }
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter547);
            ruleParameter();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter554); if (state.failed) return ;

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
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:294:1: ruleParameter : ( ( rule__Parameter__Group__0 ) ) ;
    public final void ruleParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:298:2: ( ( ( rule__Parameter__Group__0 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:299:1: ( ( rule__Parameter__Group__0 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:299:1: ( ( rule__Parameter__Group__0 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:300:1: ( rule__Parameter__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getGroup()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:301:1: ( rule__Parameter__Group__0 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:301:2: rule__Parameter__Group__0
            {
            pushFollow(FOLLOW_rule__Parameter__Group__0_in_ruleParameter580);
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


    // $ANTLR start "entryRuleMethodBody"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:315:1: entryRuleMethodBody : ruleMethodBody EOF ;
    public final void entryRuleMethodBody() throws RecognitionException {
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:316:1: ( ruleMethodBody EOF )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:317:1: ruleMethodBody EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodBodyRule()); 
            }
            pushFollow(FOLLOW_ruleMethodBody_in_entryRuleMethodBody609);
            ruleMethodBody();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodBodyRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodBody616); if (state.failed) return ;

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
    // $ANTLR end "entryRuleMethodBody"


    // $ANTLR start "ruleMethodBody"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:324:1: ruleMethodBody : ( ( rule__MethodBody__Group__0 ) ) ;
    public final void ruleMethodBody() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:328:2: ( ( ( rule__MethodBody__Group__0 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:329:1: ( ( rule__MethodBody__Group__0 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:329:1: ( ( rule__MethodBody__Group__0 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:330:1: ( rule__MethodBody__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodBodyAccess().getGroup()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:331:1: ( rule__MethodBody__Group__0 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:331:2: rule__MethodBody__Group__0
            {
            pushFollow(FOLLOW_rule__MethodBody__Group__0_in_ruleMethodBody642);
            rule__MethodBody__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodBodyAccess().getGroup()); 
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
    // $ANTLR end "ruleMethodBody"


    // $ANTLR start "entryRuleExpression"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:343:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:344:1: ( ruleExpression EOF )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:345:1: ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression669);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression676); if (state.failed) return ;

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
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:352:1: ruleExpression : ( ( rule__Expression__Group__0 ) ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:356:2: ( ( ( rule__Expression__Group__0 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:357:1: ( ( rule__Expression__Group__0 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:357:1: ( ( rule__Expression__Group__0 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:358:1: ( rule__Expression__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getGroup()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:359:1: ( rule__Expression__Group__0 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:359:2: rule__Expression__Group__0
            {
            pushFollow(FOLLOW_rule__Expression__Group__0_in_ruleExpression702);
            rule__Expression__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getGroup()); 
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


    // $ANTLR start "entryRuleTerminalExpression"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:371:1: entryRuleTerminalExpression : ruleTerminalExpression EOF ;
    public final void entryRuleTerminalExpression() throws RecognitionException {
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:372:1: ( ruleTerminalExpression EOF )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:373:1: ruleTerminalExpression EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleTerminalExpression_in_entryRuleTerminalExpression729);
            ruleTerminalExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalExpression736); if (state.failed) return ;

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
    // $ANTLR end "entryRuleTerminalExpression"


    // $ANTLR start "ruleTerminalExpression"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:380:1: ruleTerminalExpression : ( ( rule__TerminalExpression__Alternatives ) ) ;
    public final void ruleTerminalExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:384:2: ( ( ( rule__TerminalExpression__Alternatives ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:385:1: ( ( rule__TerminalExpression__Alternatives ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:385:1: ( ( rule__TerminalExpression__Alternatives ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:386:1: ( rule__TerminalExpression__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExpressionAccess().getAlternatives()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:387:1: ( rule__TerminalExpression__Alternatives )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:387:2: rule__TerminalExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__TerminalExpression__Alternatives_in_ruleTerminalExpression762);
            rule__TerminalExpression__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExpressionAccess().getAlternatives()); 
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
    // $ANTLR end "ruleTerminalExpression"


    // $ANTLR start "entryRuleThis"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:399:1: entryRuleThis : ruleThis EOF ;
    public final void entryRuleThis() throws RecognitionException {
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:400:1: ( ruleThis EOF )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:401:1: ruleThis EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getThisRule()); 
            }
            pushFollow(FOLLOW_ruleThis_in_entryRuleThis789);
            ruleThis();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getThisRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleThis796); if (state.failed) return ;

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
    // $ANTLR end "entryRuleThis"


    // $ANTLR start "ruleThis"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:408:1: ruleThis : ( ( rule__This__VariableAssignment ) ) ;
    public final void ruleThis() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:412:2: ( ( ( rule__This__VariableAssignment ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:413:1: ( ( rule__This__VariableAssignment ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:413:1: ( ( rule__This__VariableAssignment ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:414:1: ( rule__This__VariableAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getThisAccess().getVariableAssignment()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:415:1: ( rule__This__VariableAssignment )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:415:2: rule__This__VariableAssignment
            {
            pushFollow(FOLLOW_rule__This__VariableAssignment_in_ruleThis822);
            rule__This__VariableAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getThisAccess().getVariableAssignment()); 
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
    // $ANTLR end "ruleThis"


    // $ANTLR start "entryRuleParamRef"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:427:1: entryRuleParamRef : ruleParamRef EOF ;
    public final void entryRuleParamRef() throws RecognitionException {
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:428:1: ( ruleParamRef EOF )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:429:1: ruleParamRef EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamRefRule()); 
            }
            pushFollow(FOLLOW_ruleParamRef_in_entryRuleParamRef849);
            ruleParamRef();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParamRefRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParamRef856); if (state.failed) return ;

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
    // $ANTLR end "entryRuleParamRef"


    // $ANTLR start "ruleParamRef"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:436:1: ruleParamRef : ( ( rule__ParamRef__ParameterAssignment ) ) ;
    public final void ruleParamRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:440:2: ( ( ( rule__ParamRef__ParameterAssignment ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:441:1: ( ( rule__ParamRef__ParameterAssignment ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:441:1: ( ( rule__ParamRef__ParameterAssignment ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:442:1: ( rule__ParamRef__ParameterAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamRefAccess().getParameterAssignment()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:443:1: ( rule__ParamRef__ParameterAssignment )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:443:2: rule__ParamRef__ParameterAssignment
            {
            pushFollow(FOLLOW_rule__ParamRef__ParameterAssignment_in_ruleParamRef882);
            rule__ParamRef__ParameterAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParamRefAccess().getParameterAssignment()); 
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
    // $ANTLR end "ruleParamRef"


    // $ANTLR start "entryRuleNew"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:455:1: entryRuleNew : ruleNew EOF ;
    public final void entryRuleNew() throws RecognitionException {
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:456:1: ( ruleNew EOF )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:457:1: ruleNew EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNewRule()); 
            }
            pushFollow(FOLLOW_ruleNew_in_entryRuleNew909);
            ruleNew();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNewRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNew916); if (state.failed) return ;

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
    // $ANTLR end "entryRuleNew"


    // $ANTLR start "ruleNew"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:464:1: ruleNew : ( ( rule__New__Group__0 ) ) ;
    public final void ruleNew() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:468:2: ( ( ( rule__New__Group__0 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:469:1: ( ( rule__New__Group__0 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:469:1: ( ( rule__New__Group__0 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:470:1: ( rule__New__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNewAccess().getGroup()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:471:1: ( rule__New__Group__0 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:471:2: rule__New__Group__0
            {
            pushFollow(FOLLOW_rule__New__Group__0_in_ruleNew942);
            rule__New__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNewAccess().getGroup()); 
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
    // $ANTLR end "ruleNew"


    // $ANTLR start "entryRuleCast"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:483:1: entryRuleCast : ruleCast EOF ;
    public final void entryRuleCast() throws RecognitionException {
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:484:1: ( ruleCast EOF )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:485:1: ruleCast EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCastRule()); 
            }
            pushFollow(FOLLOW_ruleCast_in_entryRuleCast969);
            ruleCast();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCastRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCast976); if (state.failed) return ;

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
    // $ANTLR end "entryRuleCast"


    // $ANTLR start "ruleCast"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:492:1: ruleCast : ( ( rule__Cast__Group__0 ) ) ;
    public final void ruleCast() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:496:2: ( ( ( rule__Cast__Group__0 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:497:1: ( ( rule__Cast__Group__0 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:497:1: ( ( rule__Cast__Group__0 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:498:1: ( rule__Cast__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCastAccess().getGroup()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:499:1: ( rule__Cast__Group__0 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:499:2: rule__Cast__Group__0
            {
            pushFollow(FOLLOW_rule__Cast__Group__0_in_ruleCast1002);
            rule__Cast__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCastAccess().getGroup()); 
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
    // $ANTLR end "ruleCast"


    // $ANTLR start "entryRuleParen"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:511:1: entryRuleParen : ruleParen EOF ;
    public final void entryRuleParen() throws RecognitionException {
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:512:1: ( ruleParen EOF )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:513:1: ruleParen EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParenRule()); 
            }
            pushFollow(FOLLOW_ruleParen_in_entryRuleParen1029);
            ruleParen();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParenRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParen1036); if (state.failed) return ;

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
    // $ANTLR end "entryRuleParen"


    // $ANTLR start "ruleParen"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:520:1: ruleParen : ( ( rule__Paren__Group__0 ) ) ;
    public final void ruleParen() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:524:2: ( ( ( rule__Paren__Group__0 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:525:1: ( ( rule__Paren__Group__0 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:525:1: ( ( rule__Paren__Group__0 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:526:1: ( rule__Paren__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParenAccess().getGroup()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:527:1: ( rule__Paren__Group__0 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:527:2: rule__Paren__Group__0
            {
            pushFollow(FOLLOW_rule__Paren__Group__0_in_ruleParen1062);
            rule__Paren__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParenAccess().getGroup()); 
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
    // $ANTLR end "ruleParen"


    // $ANTLR start "entryRuleConstant"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:539:1: entryRuleConstant : ruleConstant EOF ;
    public final void entryRuleConstant() throws RecognitionException {
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:540:1: ( ruleConstant EOF )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:541:1: ruleConstant EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantRule()); 
            }
            pushFollow(FOLLOW_ruleConstant_in_entryRuleConstant1089);
            ruleConstant();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstant1096); if (state.failed) return ;

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
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:548:1: ruleConstant : ( ( rule__Constant__Alternatives ) ) ;
    public final void ruleConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:552:2: ( ( ( rule__Constant__Alternatives ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:553:1: ( ( rule__Constant__Alternatives ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:553:1: ( ( rule__Constant__Alternatives ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:554:1: ( rule__Constant__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantAccess().getAlternatives()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:555:1: ( rule__Constant__Alternatives )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:555:2: rule__Constant__Alternatives
            {
            pushFollow(FOLLOW_rule__Constant__Alternatives_in_ruleConstant1122);
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
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:567:1: entryRuleStringConstant : ruleStringConstant EOF ;
    public final void entryRuleStringConstant() throws RecognitionException {
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:568:1: ( ruleStringConstant EOF )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:569:1: ruleStringConstant EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringConstantRule()); 
            }
            pushFollow(FOLLOW_ruleStringConstant_in_entryRuleStringConstant1149);
            ruleStringConstant();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringConstantRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringConstant1156); if (state.failed) return ;

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
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:576:1: ruleStringConstant : ( ( rule__StringConstant__ConstantAssignment ) ) ;
    public final void ruleStringConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:580:2: ( ( ( rule__StringConstant__ConstantAssignment ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:581:1: ( ( rule__StringConstant__ConstantAssignment ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:581:1: ( ( rule__StringConstant__ConstantAssignment ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:582:1: ( rule__StringConstant__ConstantAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringConstantAccess().getConstantAssignment()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:583:1: ( rule__StringConstant__ConstantAssignment )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:583:2: rule__StringConstant__ConstantAssignment
            {
            pushFollow(FOLLOW_rule__StringConstant__ConstantAssignment_in_ruleStringConstant1182);
            rule__StringConstant__ConstantAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringConstantAccess().getConstantAssignment()); 
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
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:595:1: entryRuleIntConstant : ruleIntConstant EOF ;
    public final void entryRuleIntConstant() throws RecognitionException {
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:596:1: ( ruleIntConstant EOF )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:597:1: ruleIntConstant EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntConstantRule()); 
            }
            pushFollow(FOLLOW_ruleIntConstant_in_entryRuleIntConstant1209);
            ruleIntConstant();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntConstantRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntConstant1216); if (state.failed) return ;

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
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:604:1: ruleIntConstant : ( ( rule__IntConstant__ConstantAssignment ) ) ;
    public final void ruleIntConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:608:2: ( ( ( rule__IntConstant__ConstantAssignment ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:609:1: ( ( rule__IntConstant__ConstantAssignment ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:609:1: ( ( rule__IntConstant__ConstantAssignment ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:610:1: ( rule__IntConstant__ConstantAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntConstantAccess().getConstantAssignment()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:611:1: ( rule__IntConstant__ConstantAssignment )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:611:2: rule__IntConstant__ConstantAssignment
            {
            pushFollow(FOLLOW_rule__IntConstant__ConstantAssignment_in_ruleIntConstant1242);
            rule__IntConstant__ConstantAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntConstantAccess().getConstantAssignment()); 
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


    // $ANTLR start "entryRuleBoolConstant"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:623:1: entryRuleBoolConstant : ruleBoolConstant EOF ;
    public final void entryRuleBoolConstant() throws RecognitionException {
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:624:1: ( ruleBoolConstant EOF )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:625:1: ruleBoolConstant EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBoolConstantRule()); 
            }
            pushFollow(FOLLOW_ruleBoolConstant_in_entryRuleBoolConstant1269);
            ruleBoolConstant();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBoolConstantRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoolConstant1276); if (state.failed) return ;

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
    // $ANTLR end "entryRuleBoolConstant"


    // $ANTLR start "ruleBoolConstant"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:632:1: ruleBoolConstant : ( ( rule__BoolConstant__ConstantAssignment ) ) ;
    public final void ruleBoolConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:636:2: ( ( ( rule__BoolConstant__ConstantAssignment ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:637:1: ( ( rule__BoolConstant__ConstantAssignment ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:637:1: ( ( rule__BoolConstant__ConstantAssignment ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:638:1: ( rule__BoolConstant__ConstantAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBoolConstantAccess().getConstantAssignment()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:639:1: ( rule__BoolConstant__ConstantAssignment )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:639:2: rule__BoolConstant__ConstantAssignment
            {
            pushFollow(FOLLOW_rule__BoolConstant__ConstantAssignment_in_ruleBoolConstant1302);
            rule__BoolConstant__ConstantAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBoolConstantAccess().getConstantAssignment()); 
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
    // $ANTLR end "ruleBoolConstant"


    // $ANTLR start "rule__Type__Alternatives"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:651:1: rule__Type__Alternatives : ( ( ruleBasicType ) | ( ruleClassType ) );
    public final void rule__Type__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:655:1: ( ( ruleBasicType ) | ( ruleClassType ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=11 && LA1_0<=13)) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_ID) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:656:1: ( ruleBasicType )
                    {
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:656:1: ( ruleBasicType )
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:657:1: ruleBasicType
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeAccess().getBasicTypeParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleBasicType_in_rule__Type__Alternatives1338);
                    ruleBasicType();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeAccess().getBasicTypeParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:662:6: ( ruleClassType )
                    {
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:662:6: ( ruleClassType )
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:663:1: ruleClassType
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeAccess().getClassTypeParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleClassType_in_rule__Type__Alternatives1355);
                    ruleClassType();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeAccess().getClassTypeParserRuleCall_1()); 
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
    // $ANTLR end "rule__Type__Alternatives"


    // $ANTLR start "rule__BasicType__BasicAlternatives_0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:673:1: rule__BasicType__BasicAlternatives_0 : ( ( 'int' ) | ( 'boolean' ) | ( 'String' ) );
    public final void rule__BasicType__BasicAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:677:1: ( ( 'int' ) | ( 'boolean' ) | ( 'String' ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 12:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:678:1: ( 'int' )
                    {
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:678:1: ( 'int' )
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:679:1: 'int'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBasicTypeAccess().getBasicIntKeyword_0_0()); 
                    }
                    match(input,11,FOLLOW_11_in_rule__BasicType__BasicAlternatives_01388); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBasicTypeAccess().getBasicIntKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:686:6: ( 'boolean' )
                    {
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:686:6: ( 'boolean' )
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:687:1: 'boolean'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBasicTypeAccess().getBasicBooleanKeyword_0_1()); 
                    }
                    match(input,12,FOLLOW_12_in_rule__BasicType__BasicAlternatives_01408); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBasicTypeAccess().getBasicBooleanKeyword_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:694:6: ( 'String' )
                    {
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:694:6: ( 'String' )
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:695:1: 'String'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBasicTypeAccess().getBasicStringKeyword_0_2()); 
                    }
                    match(input,13,FOLLOW_13_in_rule__BasicType__BasicAlternatives_01428); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBasicTypeAccess().getBasicStringKeyword_0_2()); 
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
    // $ANTLR end "rule__BasicType__BasicAlternatives_0"


    // $ANTLR start "rule__Member__Alternatives"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:707:1: rule__Member__Alternatives : ( ( ruleField ) | ( ruleMethod ) );
    public final void rule__Member__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:711:1: ( ( ruleField ) | ( ruleMethod ) )
            int alt3=2;
            switch ( input.LA(1) ) {
            case 11:
                {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==RULE_ID) ) {
                    int LA3_5 = input.LA(3);

                    if ( (LA3_5==21) ) {
                        alt3=2;
                    }
                    else if ( (LA3_5==20) ) {
                        alt3=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 5, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
                }
                break;
            case 12:
                {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==RULE_ID) ) {
                    int LA3_5 = input.LA(3);

                    if ( (LA3_5==21) ) {
                        alt3=2;
                    }
                    else if ( (LA3_5==20) ) {
                        alt3=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 5, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;
                }
                }
                break;
            case 13:
                {
                int LA3_3 = input.LA(2);

                if ( (LA3_3==RULE_ID) ) {
                    int LA3_5 = input.LA(3);

                    if ( (LA3_5==21) ) {
                        alt3=2;
                    }
                    else if ( (LA3_5==20) ) {
                        alt3=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 5, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                int LA3_4 = input.LA(2);

                if ( (LA3_4==RULE_ID) ) {
                    int LA3_5 = input.LA(3);

                    if ( (LA3_5==21) ) {
                        alt3=2;
                    }
                    else if ( (LA3_5==20) ) {
                        alt3=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 5, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 4, input);

                    throw nvae;
                }
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
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:712:1: ( ruleField )
                    {
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:712:1: ( ruleField )
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:713:1: ruleField
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMemberAccess().getFieldParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleField_in_rule__Member__Alternatives1462);
                    ruleField();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMemberAccess().getFieldParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:718:6: ( ruleMethod )
                    {
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:718:6: ( ruleMethod )
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:719:1: ruleMethod
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMemberAccess().getMethodParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleMethod_in_rule__Member__Alternatives1479);
                    ruleMethod();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMemberAccess().getMethodParserRuleCall_1()); 
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
    // $ANTLR end "rule__Member__Alternatives"


    // $ANTLR start "rule__TerminalExpression__Alternatives"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:730:1: rule__TerminalExpression__Alternatives : ( ( ruleThis ) | ( ruleParamRef ) | ( ruleNew ) | ( ( ruleCast ) ) | ( ruleConstant ) | ( ruleParen ) );
    public final void rule__TerminalExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:734:1: ( ( ruleThis ) | ( ruleParamRef ) | ( ruleNew ) | ( ( ruleCast ) ) | ( ruleConstant ) | ( ruleParen ) )
            int alt4=6;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:735:1: ( ruleThis )
                    {
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:735:1: ( ruleThis )
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:736:1: ruleThis
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExpressionAccess().getThisParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleThis_in_rule__TerminalExpression__Alternatives1512);
                    ruleThis();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalExpressionAccess().getThisParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:741:6: ( ruleParamRef )
                    {
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:741:6: ( ruleParamRef )
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:742:1: ruleParamRef
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExpressionAccess().getParamRefParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleParamRef_in_rule__TerminalExpression__Alternatives1529);
                    ruleParamRef();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalExpressionAccess().getParamRefParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:747:6: ( ruleNew )
                    {
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:747:6: ( ruleNew )
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:748:1: ruleNew
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExpressionAccess().getNewParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_ruleNew_in_rule__TerminalExpression__Alternatives1546);
                    ruleNew();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalExpressionAccess().getNewParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:753:6: ( ( ruleCast ) )
                    {
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:753:6: ( ( ruleCast ) )
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:754:1: ( ruleCast )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExpressionAccess().getCastParserRuleCall_3()); 
                    }
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:755:1: ( ruleCast )
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:755:3: ruleCast
                    {
                    pushFollow(FOLLOW_ruleCast_in_rule__TerminalExpression__Alternatives1564);
                    ruleCast();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalExpressionAccess().getCastParserRuleCall_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:759:6: ( ruleConstant )
                    {
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:759:6: ( ruleConstant )
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:760:1: ruleConstant
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExpressionAccess().getConstantParserRuleCall_4()); 
                    }
                    pushFollow(FOLLOW_ruleConstant_in_rule__TerminalExpression__Alternatives1582);
                    ruleConstant();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalExpressionAccess().getConstantParserRuleCall_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:765:6: ( ruleParen )
                    {
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:765:6: ( ruleParen )
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:766:1: ruleParen
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExpressionAccess().getParenParserRuleCall_5()); 
                    }
                    pushFollow(FOLLOW_ruleParen_in_rule__TerminalExpression__Alternatives1599);
                    ruleParen();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalExpressionAccess().getParenParserRuleCall_5()); 
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
    // $ANTLR end "rule__TerminalExpression__Alternatives"


    // $ANTLR start "rule__Constant__Alternatives"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:776:1: rule__Constant__Alternatives : ( ( ruleIntConstant ) | ( ruleBoolConstant ) | ( ruleStringConstant ) );
    public final void rule__Constant__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:780:1: ( ( ruleIntConstant ) | ( ruleBoolConstant ) | ( ruleStringConstant ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt5=1;
                }
                break;
            case 14:
            case 15:
                {
                alt5=2;
                }
                break;
            case RULE_STRING:
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
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:781:1: ( ruleIntConstant )
                    {
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:781:1: ( ruleIntConstant )
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:782:1: ruleIntConstant
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConstantAccess().getIntConstantParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleIntConstant_in_rule__Constant__Alternatives1631);
                    ruleIntConstant();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getConstantAccess().getIntConstantParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:787:6: ( ruleBoolConstant )
                    {
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:787:6: ( ruleBoolConstant )
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:788:1: ruleBoolConstant
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConstantAccess().getBoolConstantParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleBoolConstant_in_rule__Constant__Alternatives1648);
                    ruleBoolConstant();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getConstantAccess().getBoolConstantParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:793:6: ( ruleStringConstant )
                    {
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:793:6: ( ruleStringConstant )
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:794:1: ruleStringConstant
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConstantAccess().getStringConstantParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_ruleStringConstant_in_rule__Constant__Alternatives1665);
                    ruleStringConstant();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getConstantAccess().getStringConstantParserRuleCall_2()); 
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


    // $ANTLR start "rule__BoolConstant__ConstantAlternatives_0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:804:1: rule__BoolConstant__ConstantAlternatives_0 : ( ( 'true' ) | ( 'false' ) );
    public final void rule__BoolConstant__ConstantAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:808:1: ( ( 'true' ) | ( 'false' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==14) ) {
                alt6=1;
            }
            else if ( (LA6_0==15) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:809:1: ( 'true' )
                    {
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:809:1: ( 'true' )
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:810:1: 'true'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBoolConstantAccess().getConstantTrueKeyword_0_0()); 
                    }
                    match(input,14,FOLLOW_14_in_rule__BoolConstant__ConstantAlternatives_01698); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBoolConstantAccess().getConstantTrueKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:817:6: ( 'false' )
                    {
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:817:6: ( 'false' )
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:818:1: 'false'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBoolConstantAccess().getConstantFalseKeyword_0_1()); 
                    }
                    match(input,15,FOLLOW_15_in_rule__BoolConstant__ConstantAlternatives_01718); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBoolConstantAccess().getConstantFalseKeyword_0_1()); 
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
    // $ANTLR end "rule__BoolConstant__ConstantAlternatives_0"


    // $ANTLR start "rule__Program__Group__0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:832:1: rule__Program__Group__0 : rule__Program__Group__0__Impl rule__Program__Group__1 ;
    public final void rule__Program__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:836:1: ( rule__Program__Group__0__Impl rule__Program__Group__1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:837:2: rule__Program__Group__0__Impl rule__Program__Group__1
            {
            pushFollow(FOLLOW_rule__Program__Group__0__Impl_in_rule__Program__Group__01750);
            rule__Program__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Program__Group__1_in_rule__Program__Group__01753);
            rule__Program__Group__1();

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
    // $ANTLR end "rule__Program__Group__0"


    // $ANTLR start "rule__Program__Group__0__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:844:1: rule__Program__Group__0__Impl : ( ( rule__Program__ClassesAssignment_0 )* ) ;
    public final void rule__Program__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:848:1: ( ( ( rule__Program__ClassesAssignment_0 )* ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:849:1: ( ( rule__Program__ClassesAssignment_0 )* )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:849:1: ( ( rule__Program__ClassesAssignment_0 )* )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:850:1: ( rule__Program__ClassesAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getClassesAssignment_0()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:851:1: ( rule__Program__ClassesAssignment_0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==16) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:851:2: rule__Program__ClassesAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__Program__ClassesAssignment_0_in_rule__Program__Group__0__Impl1780);
            	    rule__Program__ClassesAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getClassesAssignment_0()); 
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
    // $ANTLR end "rule__Program__Group__0__Impl"


    // $ANTLR start "rule__Program__Group__1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:861:1: rule__Program__Group__1 : rule__Program__Group__1__Impl ;
    public final void rule__Program__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:865:1: ( rule__Program__Group__1__Impl )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:866:2: rule__Program__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Program__Group__1__Impl_in_rule__Program__Group__11811);
            rule__Program__Group__1__Impl();

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
    // $ANTLR end "rule__Program__Group__1"


    // $ANTLR start "rule__Program__Group__1__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:872:1: rule__Program__Group__1__Impl : ( ( rule__Program__MainAssignment_1 )? ) ;
    public final void rule__Program__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:876:1: ( ( ( rule__Program__MainAssignment_1 )? ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:877:1: ( ( rule__Program__MainAssignment_1 )? )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:877:1: ( ( rule__Program__MainAssignment_1 )? )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:878:1: ( rule__Program__MainAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getMainAssignment_1()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:879:1: ( rule__Program__MainAssignment_1 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_ID && LA8_0<=RULE_INT)||(LA8_0>=14 && LA8_0<=15)||LA8_0==21||(LA8_0>=26 && LA8_0<=27)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:879:2: rule__Program__MainAssignment_1
                    {
                    pushFollow(FOLLOW_rule__Program__MainAssignment_1_in_rule__Program__Group__1__Impl1838);
                    rule__Program__MainAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getMainAssignment_1()); 
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
    // $ANTLR end "rule__Program__Group__1__Impl"


    // $ANTLR start "rule__Class__Group__0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:893:1: rule__Class__Group__0 : rule__Class__Group__0__Impl rule__Class__Group__1 ;
    public final void rule__Class__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:897:1: ( rule__Class__Group__0__Impl rule__Class__Group__1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:898:2: rule__Class__Group__0__Impl rule__Class__Group__1
            {
            pushFollow(FOLLOW_rule__Class__Group__0__Impl_in_rule__Class__Group__01873);
            rule__Class__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Class__Group__1_in_rule__Class__Group__01876);
            rule__Class__Group__1();

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
    // $ANTLR end "rule__Class__Group__0"


    // $ANTLR start "rule__Class__Group__0__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:905:1: rule__Class__Group__0__Impl : ( 'class' ) ;
    public final void rule__Class__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:909:1: ( ( 'class' ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:910:1: ( 'class' )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:910:1: ( 'class' )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:911:1: 'class'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassAccess().getClassKeyword_0()); 
            }
            match(input,16,FOLLOW_16_in_rule__Class__Group__0__Impl1904); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassAccess().getClassKeyword_0()); 
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
    // $ANTLR end "rule__Class__Group__0__Impl"


    // $ANTLR start "rule__Class__Group__1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:924:1: rule__Class__Group__1 : rule__Class__Group__1__Impl rule__Class__Group__2 ;
    public final void rule__Class__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:928:1: ( rule__Class__Group__1__Impl rule__Class__Group__2 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:929:2: rule__Class__Group__1__Impl rule__Class__Group__2
            {
            pushFollow(FOLLOW_rule__Class__Group__1__Impl_in_rule__Class__Group__11935);
            rule__Class__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Class__Group__2_in_rule__Class__Group__11938);
            rule__Class__Group__2();

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
    // $ANTLR end "rule__Class__Group__1"


    // $ANTLR start "rule__Class__Group__1__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:936:1: rule__Class__Group__1__Impl : ( ( rule__Class__NameAssignment_1 ) ) ;
    public final void rule__Class__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:940:1: ( ( ( rule__Class__NameAssignment_1 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:941:1: ( ( rule__Class__NameAssignment_1 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:941:1: ( ( rule__Class__NameAssignment_1 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:942:1: ( rule__Class__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassAccess().getNameAssignment_1()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:943:1: ( rule__Class__NameAssignment_1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:943:2: rule__Class__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Class__NameAssignment_1_in_rule__Class__Group__1__Impl1965);
            rule__Class__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassAccess().getNameAssignment_1()); 
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
    // $ANTLR end "rule__Class__Group__1__Impl"


    // $ANTLR start "rule__Class__Group__2"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:953:1: rule__Class__Group__2 : rule__Class__Group__2__Impl rule__Class__Group__3 ;
    public final void rule__Class__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:957:1: ( rule__Class__Group__2__Impl rule__Class__Group__3 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:958:2: rule__Class__Group__2__Impl rule__Class__Group__3
            {
            pushFollow(FOLLOW_rule__Class__Group__2__Impl_in_rule__Class__Group__21995);
            rule__Class__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Class__Group__3_in_rule__Class__Group__21998);
            rule__Class__Group__3();

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
    // $ANTLR end "rule__Class__Group__2"


    // $ANTLR start "rule__Class__Group__2__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:965:1: rule__Class__Group__2__Impl : ( ( rule__Class__Group_2__0 )? ) ;
    public final void rule__Class__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:969:1: ( ( ( rule__Class__Group_2__0 )? ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:970:1: ( ( rule__Class__Group_2__0 )? )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:970:1: ( ( rule__Class__Group_2__0 )? )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:971:1: ( rule__Class__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassAccess().getGroup_2()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:972:1: ( rule__Class__Group_2__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:972:2: rule__Class__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Class__Group_2__0_in_rule__Class__Group__2__Impl2025);
                    rule__Class__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassAccess().getGroup_2()); 
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
    // $ANTLR end "rule__Class__Group__2__Impl"


    // $ANTLR start "rule__Class__Group__3"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:982:1: rule__Class__Group__3 : rule__Class__Group__3__Impl rule__Class__Group__4 ;
    public final void rule__Class__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:986:1: ( rule__Class__Group__3__Impl rule__Class__Group__4 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:987:2: rule__Class__Group__3__Impl rule__Class__Group__4
            {
            pushFollow(FOLLOW_rule__Class__Group__3__Impl_in_rule__Class__Group__32056);
            rule__Class__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Class__Group__4_in_rule__Class__Group__32059);
            rule__Class__Group__4();

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
    // $ANTLR end "rule__Class__Group__3"


    // $ANTLR start "rule__Class__Group__3__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:994:1: rule__Class__Group__3__Impl : ( '{' ) ;
    public final void rule__Class__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:998:1: ( ( '{' ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:999:1: ( '{' )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:999:1: ( '{' )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1000:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_3()); 
            }
            match(input,17,FOLLOW_17_in_rule__Class__Group__3__Impl2087); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_3()); 
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
    // $ANTLR end "rule__Class__Group__3__Impl"


    // $ANTLR start "rule__Class__Group__4"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1013:1: rule__Class__Group__4 : rule__Class__Group__4__Impl rule__Class__Group__5 ;
    public final void rule__Class__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1017:1: ( rule__Class__Group__4__Impl rule__Class__Group__5 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1018:2: rule__Class__Group__4__Impl rule__Class__Group__5
            {
            pushFollow(FOLLOW_rule__Class__Group__4__Impl_in_rule__Class__Group__42118);
            rule__Class__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Class__Group__5_in_rule__Class__Group__42121);
            rule__Class__Group__5();

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
    // $ANTLR end "rule__Class__Group__4"


    // $ANTLR start "rule__Class__Group__4__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1025:1: rule__Class__Group__4__Impl : ( ( rule__Class__MembersAssignment_4 )* ) ;
    public final void rule__Class__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1029:1: ( ( ( rule__Class__MembersAssignment_4 )* ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1030:1: ( ( rule__Class__MembersAssignment_4 )* )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1030:1: ( ( rule__Class__MembersAssignment_4 )* )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1031:1: ( rule__Class__MembersAssignment_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassAccess().getMembersAssignment_4()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1032:1: ( rule__Class__MembersAssignment_4 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID||(LA10_0>=11 && LA10_0<=13)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1032:2: rule__Class__MembersAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__Class__MembersAssignment_4_in_rule__Class__Group__4__Impl2148);
            	    rule__Class__MembersAssignment_4();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassAccess().getMembersAssignment_4()); 
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
    // $ANTLR end "rule__Class__Group__4__Impl"


    // $ANTLR start "rule__Class__Group__5"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1042:1: rule__Class__Group__5 : rule__Class__Group__5__Impl ;
    public final void rule__Class__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1046:1: ( rule__Class__Group__5__Impl )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1047:2: rule__Class__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__Class__Group__5__Impl_in_rule__Class__Group__52179);
            rule__Class__Group__5__Impl();

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
    // $ANTLR end "rule__Class__Group__5"


    // $ANTLR start "rule__Class__Group__5__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1053:1: rule__Class__Group__5__Impl : ( '}' ) ;
    public final void rule__Class__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1057:1: ( ( '}' ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1058:1: ( '}' )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1058:1: ( '}' )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1059:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,18,FOLLOW_18_in_rule__Class__Group__5__Impl2207); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassAccess().getRightCurlyBracketKeyword_5()); 
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
    // $ANTLR end "rule__Class__Group__5__Impl"


    // $ANTLR start "rule__Class__Group_2__0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1084:1: rule__Class__Group_2__0 : rule__Class__Group_2__0__Impl rule__Class__Group_2__1 ;
    public final void rule__Class__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1088:1: ( rule__Class__Group_2__0__Impl rule__Class__Group_2__1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1089:2: rule__Class__Group_2__0__Impl rule__Class__Group_2__1
            {
            pushFollow(FOLLOW_rule__Class__Group_2__0__Impl_in_rule__Class__Group_2__02250);
            rule__Class__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Class__Group_2__1_in_rule__Class__Group_2__02253);
            rule__Class__Group_2__1();

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
    // $ANTLR end "rule__Class__Group_2__0"


    // $ANTLR start "rule__Class__Group_2__0__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1096:1: rule__Class__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__Class__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1100:1: ( ( 'extends' ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1101:1: ( 'extends' )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1101:1: ( 'extends' )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1102:1: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassAccess().getExtendsKeyword_2_0()); 
            }
            match(input,19,FOLLOW_19_in_rule__Class__Group_2__0__Impl2281); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassAccess().getExtendsKeyword_2_0()); 
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
    // $ANTLR end "rule__Class__Group_2__0__Impl"


    // $ANTLR start "rule__Class__Group_2__1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1115:1: rule__Class__Group_2__1 : rule__Class__Group_2__1__Impl ;
    public final void rule__Class__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1119:1: ( rule__Class__Group_2__1__Impl )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1120:2: rule__Class__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Class__Group_2__1__Impl_in_rule__Class__Group_2__12312);
            rule__Class__Group_2__1__Impl();

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
    // $ANTLR end "rule__Class__Group_2__1"


    // $ANTLR start "rule__Class__Group_2__1__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1126:1: rule__Class__Group_2__1__Impl : ( ( rule__Class__SuperclassAssignment_2_1 ) ) ;
    public final void rule__Class__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1130:1: ( ( ( rule__Class__SuperclassAssignment_2_1 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1131:1: ( ( rule__Class__SuperclassAssignment_2_1 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1131:1: ( ( rule__Class__SuperclassAssignment_2_1 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1132:1: ( rule__Class__SuperclassAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassAccess().getSuperclassAssignment_2_1()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1133:1: ( rule__Class__SuperclassAssignment_2_1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1133:2: rule__Class__SuperclassAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Class__SuperclassAssignment_2_1_in_rule__Class__Group_2__1__Impl2339);
            rule__Class__SuperclassAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassAccess().getSuperclassAssignment_2_1()); 
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
    // $ANTLR end "rule__Class__Group_2__1__Impl"


    // $ANTLR start "rule__Field__Group__0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1147:1: rule__Field__Group__0 : rule__Field__Group__0__Impl rule__Field__Group__1 ;
    public final void rule__Field__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1151:1: ( rule__Field__Group__0__Impl rule__Field__Group__1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1152:2: rule__Field__Group__0__Impl rule__Field__Group__1
            {
            pushFollow(FOLLOW_rule__Field__Group__0__Impl_in_rule__Field__Group__02373);
            rule__Field__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Field__Group__1_in_rule__Field__Group__02376);
            rule__Field__Group__1();

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
    // $ANTLR end "rule__Field__Group__0"


    // $ANTLR start "rule__Field__Group__0__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1159:1: rule__Field__Group__0__Impl : ( ( rule__Field__TypeAssignment_0 ) ) ;
    public final void rule__Field__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1163:1: ( ( ( rule__Field__TypeAssignment_0 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1164:1: ( ( rule__Field__TypeAssignment_0 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1164:1: ( ( rule__Field__TypeAssignment_0 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1165:1: ( rule__Field__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getTypeAssignment_0()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1166:1: ( rule__Field__TypeAssignment_0 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1166:2: rule__Field__TypeAssignment_0
            {
            pushFollow(FOLLOW_rule__Field__TypeAssignment_0_in_rule__Field__Group__0__Impl2403);
            rule__Field__TypeAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getTypeAssignment_0()); 
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
    // $ANTLR end "rule__Field__Group__0__Impl"


    // $ANTLR start "rule__Field__Group__1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1176:1: rule__Field__Group__1 : rule__Field__Group__1__Impl rule__Field__Group__2 ;
    public final void rule__Field__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1180:1: ( rule__Field__Group__1__Impl rule__Field__Group__2 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1181:2: rule__Field__Group__1__Impl rule__Field__Group__2
            {
            pushFollow(FOLLOW_rule__Field__Group__1__Impl_in_rule__Field__Group__12433);
            rule__Field__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Field__Group__2_in_rule__Field__Group__12436);
            rule__Field__Group__2();

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
    // $ANTLR end "rule__Field__Group__1"


    // $ANTLR start "rule__Field__Group__1__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1188:1: rule__Field__Group__1__Impl : ( ( rule__Field__NameAssignment_1 ) ) ;
    public final void rule__Field__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1192:1: ( ( ( rule__Field__NameAssignment_1 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1193:1: ( ( rule__Field__NameAssignment_1 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1193:1: ( ( rule__Field__NameAssignment_1 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1194:1: ( rule__Field__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getNameAssignment_1()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1195:1: ( rule__Field__NameAssignment_1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1195:2: rule__Field__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Field__NameAssignment_1_in_rule__Field__Group__1__Impl2463);
            rule__Field__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getNameAssignment_1()); 
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
    // $ANTLR end "rule__Field__Group__1__Impl"


    // $ANTLR start "rule__Field__Group__2"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1205:1: rule__Field__Group__2 : rule__Field__Group__2__Impl ;
    public final void rule__Field__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1209:1: ( rule__Field__Group__2__Impl )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1210:2: rule__Field__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Field__Group__2__Impl_in_rule__Field__Group__22493);
            rule__Field__Group__2__Impl();

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
    // $ANTLR end "rule__Field__Group__2"


    // $ANTLR start "rule__Field__Group__2__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1216:1: rule__Field__Group__2__Impl : ( ';' ) ;
    public final void rule__Field__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1220:1: ( ( ';' ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1221:1: ( ';' )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1221:1: ( ';' )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1222:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getSemicolonKeyword_2()); 
            }
            match(input,20,FOLLOW_20_in_rule__Field__Group__2__Impl2521); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getSemicolonKeyword_2()); 
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
    // $ANTLR end "rule__Field__Group__2__Impl"


    // $ANTLR start "rule__Method__Group__0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1241:1: rule__Method__Group__0 : rule__Method__Group__0__Impl rule__Method__Group__1 ;
    public final void rule__Method__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1245:1: ( rule__Method__Group__0__Impl rule__Method__Group__1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1246:2: rule__Method__Group__0__Impl rule__Method__Group__1
            {
            pushFollow(FOLLOW_rule__Method__Group__0__Impl_in_rule__Method__Group__02558);
            rule__Method__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Method__Group__1_in_rule__Method__Group__02561);
            rule__Method__Group__1();

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
    // $ANTLR end "rule__Method__Group__0"


    // $ANTLR start "rule__Method__Group__0__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1253:1: rule__Method__Group__0__Impl : ( ( rule__Method__TypeAssignment_0 ) ) ;
    public final void rule__Method__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1257:1: ( ( ( rule__Method__TypeAssignment_0 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1258:1: ( ( rule__Method__TypeAssignment_0 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1258:1: ( ( rule__Method__TypeAssignment_0 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1259:1: ( rule__Method__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getTypeAssignment_0()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1260:1: ( rule__Method__TypeAssignment_0 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1260:2: rule__Method__TypeAssignment_0
            {
            pushFollow(FOLLOW_rule__Method__TypeAssignment_0_in_rule__Method__Group__0__Impl2588);
            rule__Method__TypeAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getTypeAssignment_0()); 
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
    // $ANTLR end "rule__Method__Group__0__Impl"


    // $ANTLR start "rule__Method__Group__1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1270:1: rule__Method__Group__1 : rule__Method__Group__1__Impl rule__Method__Group__2 ;
    public final void rule__Method__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1274:1: ( rule__Method__Group__1__Impl rule__Method__Group__2 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1275:2: rule__Method__Group__1__Impl rule__Method__Group__2
            {
            pushFollow(FOLLOW_rule__Method__Group__1__Impl_in_rule__Method__Group__12618);
            rule__Method__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Method__Group__2_in_rule__Method__Group__12621);
            rule__Method__Group__2();

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
    // $ANTLR end "rule__Method__Group__1"


    // $ANTLR start "rule__Method__Group__1__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1282:1: rule__Method__Group__1__Impl : ( ( rule__Method__NameAssignment_1 ) ) ;
    public final void rule__Method__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1286:1: ( ( ( rule__Method__NameAssignment_1 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1287:1: ( ( rule__Method__NameAssignment_1 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1287:1: ( ( rule__Method__NameAssignment_1 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1288:1: ( rule__Method__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getNameAssignment_1()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1289:1: ( rule__Method__NameAssignment_1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1289:2: rule__Method__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Method__NameAssignment_1_in_rule__Method__Group__1__Impl2648);
            rule__Method__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getNameAssignment_1()); 
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
    // $ANTLR end "rule__Method__Group__1__Impl"


    // $ANTLR start "rule__Method__Group__2"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1299:1: rule__Method__Group__2 : rule__Method__Group__2__Impl rule__Method__Group__3 ;
    public final void rule__Method__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1303:1: ( rule__Method__Group__2__Impl rule__Method__Group__3 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1304:2: rule__Method__Group__2__Impl rule__Method__Group__3
            {
            pushFollow(FOLLOW_rule__Method__Group__2__Impl_in_rule__Method__Group__22678);
            rule__Method__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Method__Group__3_in_rule__Method__Group__22681);
            rule__Method__Group__3();

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
    // $ANTLR end "rule__Method__Group__2"


    // $ANTLR start "rule__Method__Group__2__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1311:1: rule__Method__Group__2__Impl : ( '(' ) ;
    public final void rule__Method__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1315:1: ( ( '(' ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1316:1: ( '(' )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1316:1: ( '(' )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1317:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getLeftParenthesisKeyword_2()); 
            }
            match(input,21,FOLLOW_21_in_rule__Method__Group__2__Impl2709); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getLeftParenthesisKeyword_2()); 
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
    // $ANTLR end "rule__Method__Group__2__Impl"


    // $ANTLR start "rule__Method__Group__3"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1330:1: rule__Method__Group__3 : rule__Method__Group__3__Impl rule__Method__Group__4 ;
    public final void rule__Method__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1334:1: ( rule__Method__Group__3__Impl rule__Method__Group__4 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1335:2: rule__Method__Group__3__Impl rule__Method__Group__4
            {
            pushFollow(FOLLOW_rule__Method__Group__3__Impl_in_rule__Method__Group__32740);
            rule__Method__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Method__Group__4_in_rule__Method__Group__32743);
            rule__Method__Group__4();

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
    // $ANTLR end "rule__Method__Group__3"


    // $ANTLR start "rule__Method__Group__3__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1342:1: rule__Method__Group__3__Impl : ( ( rule__Method__Group_3__0 )? ) ;
    public final void rule__Method__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1346:1: ( ( ( rule__Method__Group_3__0 )? ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1347:1: ( ( rule__Method__Group_3__0 )? )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1347:1: ( ( rule__Method__Group_3__0 )? )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1348:1: ( rule__Method__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getGroup_3()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1349:1: ( rule__Method__Group_3__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID||(LA11_0>=11 && LA11_0<=13)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1349:2: rule__Method__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Method__Group_3__0_in_rule__Method__Group__3__Impl2770);
                    rule__Method__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getGroup_3()); 
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
    // $ANTLR end "rule__Method__Group__3__Impl"


    // $ANTLR start "rule__Method__Group__4"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1359:1: rule__Method__Group__4 : rule__Method__Group__4__Impl rule__Method__Group__5 ;
    public final void rule__Method__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1363:1: ( rule__Method__Group__4__Impl rule__Method__Group__5 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1364:2: rule__Method__Group__4__Impl rule__Method__Group__5
            {
            pushFollow(FOLLOW_rule__Method__Group__4__Impl_in_rule__Method__Group__42801);
            rule__Method__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Method__Group__5_in_rule__Method__Group__42804);
            rule__Method__Group__5();

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
    // $ANTLR end "rule__Method__Group__4"


    // $ANTLR start "rule__Method__Group__4__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1371:1: rule__Method__Group__4__Impl : ( ')' ) ;
    public final void rule__Method__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1375:1: ( ( ')' ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1376:1: ( ')' )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1376:1: ( ')' )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1377:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getRightParenthesisKeyword_4()); 
            }
            match(input,22,FOLLOW_22_in_rule__Method__Group__4__Impl2832); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getRightParenthesisKeyword_4()); 
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
    // $ANTLR end "rule__Method__Group__4__Impl"


    // $ANTLR start "rule__Method__Group__5"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1390:1: rule__Method__Group__5 : rule__Method__Group__5__Impl rule__Method__Group__6 ;
    public final void rule__Method__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1394:1: ( rule__Method__Group__5__Impl rule__Method__Group__6 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1395:2: rule__Method__Group__5__Impl rule__Method__Group__6
            {
            pushFollow(FOLLOW_rule__Method__Group__5__Impl_in_rule__Method__Group__52863);
            rule__Method__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Method__Group__6_in_rule__Method__Group__52866);
            rule__Method__Group__6();

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
    // $ANTLR end "rule__Method__Group__5"


    // $ANTLR start "rule__Method__Group__5__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1402:1: rule__Method__Group__5__Impl : ( '{' ) ;
    public final void rule__Method__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1406:1: ( ( '{' ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1407:1: ( '{' )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1407:1: ( '{' )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1408:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getLeftCurlyBracketKeyword_5()); 
            }
            match(input,17,FOLLOW_17_in_rule__Method__Group__5__Impl2894); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getLeftCurlyBracketKeyword_5()); 
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
    // $ANTLR end "rule__Method__Group__5__Impl"


    // $ANTLR start "rule__Method__Group__6"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1421:1: rule__Method__Group__6 : rule__Method__Group__6__Impl rule__Method__Group__7 ;
    public final void rule__Method__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1425:1: ( rule__Method__Group__6__Impl rule__Method__Group__7 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1426:2: rule__Method__Group__6__Impl rule__Method__Group__7
            {
            pushFollow(FOLLOW_rule__Method__Group__6__Impl_in_rule__Method__Group__62925);
            rule__Method__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Method__Group__7_in_rule__Method__Group__62928);
            rule__Method__Group__7();

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
    // $ANTLR end "rule__Method__Group__6"


    // $ANTLR start "rule__Method__Group__6__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1433:1: rule__Method__Group__6__Impl : ( ( rule__Method__BodyAssignment_6 ) ) ;
    public final void rule__Method__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1437:1: ( ( ( rule__Method__BodyAssignment_6 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1438:1: ( ( rule__Method__BodyAssignment_6 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1438:1: ( ( rule__Method__BodyAssignment_6 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1439:1: ( rule__Method__BodyAssignment_6 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getBodyAssignment_6()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1440:1: ( rule__Method__BodyAssignment_6 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1440:2: rule__Method__BodyAssignment_6
            {
            pushFollow(FOLLOW_rule__Method__BodyAssignment_6_in_rule__Method__Group__6__Impl2955);
            rule__Method__BodyAssignment_6();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getBodyAssignment_6()); 
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
    // $ANTLR end "rule__Method__Group__6__Impl"


    // $ANTLR start "rule__Method__Group__7"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1450:1: rule__Method__Group__7 : rule__Method__Group__7__Impl ;
    public final void rule__Method__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1454:1: ( rule__Method__Group__7__Impl )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1455:2: rule__Method__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__Method__Group__7__Impl_in_rule__Method__Group__72985);
            rule__Method__Group__7__Impl();

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
    // $ANTLR end "rule__Method__Group__7"


    // $ANTLR start "rule__Method__Group__7__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1461:1: rule__Method__Group__7__Impl : ( '}' ) ;
    public final void rule__Method__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1465:1: ( ( '}' ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1466:1: ( '}' )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1466:1: ( '}' )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1467:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getRightCurlyBracketKeyword_7()); 
            }
            match(input,18,FOLLOW_18_in_rule__Method__Group__7__Impl3013); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getRightCurlyBracketKeyword_7()); 
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
    // $ANTLR end "rule__Method__Group__7__Impl"


    // $ANTLR start "rule__Method__Group_3__0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1496:1: rule__Method__Group_3__0 : rule__Method__Group_3__0__Impl rule__Method__Group_3__1 ;
    public final void rule__Method__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1500:1: ( rule__Method__Group_3__0__Impl rule__Method__Group_3__1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1501:2: rule__Method__Group_3__0__Impl rule__Method__Group_3__1
            {
            pushFollow(FOLLOW_rule__Method__Group_3__0__Impl_in_rule__Method__Group_3__03060);
            rule__Method__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Method__Group_3__1_in_rule__Method__Group_3__03063);
            rule__Method__Group_3__1();

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
    // $ANTLR end "rule__Method__Group_3__0"


    // $ANTLR start "rule__Method__Group_3__0__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1508:1: rule__Method__Group_3__0__Impl : ( ( rule__Method__ParamsAssignment_3_0 ) ) ;
    public final void rule__Method__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1512:1: ( ( ( rule__Method__ParamsAssignment_3_0 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1513:1: ( ( rule__Method__ParamsAssignment_3_0 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1513:1: ( ( rule__Method__ParamsAssignment_3_0 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1514:1: ( rule__Method__ParamsAssignment_3_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getParamsAssignment_3_0()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1515:1: ( rule__Method__ParamsAssignment_3_0 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1515:2: rule__Method__ParamsAssignment_3_0
            {
            pushFollow(FOLLOW_rule__Method__ParamsAssignment_3_0_in_rule__Method__Group_3__0__Impl3090);
            rule__Method__ParamsAssignment_3_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getParamsAssignment_3_0()); 
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
    // $ANTLR end "rule__Method__Group_3__0__Impl"


    // $ANTLR start "rule__Method__Group_3__1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1525:1: rule__Method__Group_3__1 : rule__Method__Group_3__1__Impl ;
    public final void rule__Method__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1529:1: ( rule__Method__Group_3__1__Impl )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1530:2: rule__Method__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Method__Group_3__1__Impl_in_rule__Method__Group_3__13120);
            rule__Method__Group_3__1__Impl();

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
    // $ANTLR end "rule__Method__Group_3__1"


    // $ANTLR start "rule__Method__Group_3__1__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1536:1: rule__Method__Group_3__1__Impl : ( ( rule__Method__Group_3_1__0 )* ) ;
    public final void rule__Method__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1540:1: ( ( ( rule__Method__Group_3_1__0 )* ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1541:1: ( ( rule__Method__Group_3_1__0 )* )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1541:1: ( ( rule__Method__Group_3_1__0 )* )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1542:1: ( rule__Method__Group_3_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getGroup_3_1()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1543:1: ( rule__Method__Group_3_1__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==23) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1543:2: rule__Method__Group_3_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Method__Group_3_1__0_in_rule__Method__Group_3__1__Impl3147);
            	    rule__Method__Group_3_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getGroup_3_1()); 
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
    // $ANTLR end "rule__Method__Group_3__1__Impl"


    // $ANTLR start "rule__Method__Group_3_1__0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1557:1: rule__Method__Group_3_1__0 : rule__Method__Group_3_1__0__Impl rule__Method__Group_3_1__1 ;
    public final void rule__Method__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1561:1: ( rule__Method__Group_3_1__0__Impl rule__Method__Group_3_1__1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1562:2: rule__Method__Group_3_1__0__Impl rule__Method__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__Method__Group_3_1__0__Impl_in_rule__Method__Group_3_1__03182);
            rule__Method__Group_3_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Method__Group_3_1__1_in_rule__Method__Group_3_1__03185);
            rule__Method__Group_3_1__1();

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
    // $ANTLR end "rule__Method__Group_3_1__0"


    // $ANTLR start "rule__Method__Group_3_1__0__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1569:1: rule__Method__Group_3_1__0__Impl : ( ',' ) ;
    public final void rule__Method__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1573:1: ( ( ',' ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1574:1: ( ',' )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1574:1: ( ',' )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1575:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getCommaKeyword_3_1_0()); 
            }
            match(input,23,FOLLOW_23_in_rule__Method__Group_3_1__0__Impl3213); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getCommaKeyword_3_1_0()); 
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
    // $ANTLR end "rule__Method__Group_3_1__0__Impl"


    // $ANTLR start "rule__Method__Group_3_1__1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1588:1: rule__Method__Group_3_1__1 : rule__Method__Group_3_1__1__Impl ;
    public final void rule__Method__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1592:1: ( rule__Method__Group_3_1__1__Impl )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1593:2: rule__Method__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Method__Group_3_1__1__Impl_in_rule__Method__Group_3_1__13244);
            rule__Method__Group_3_1__1__Impl();

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
    // $ANTLR end "rule__Method__Group_3_1__1"


    // $ANTLR start "rule__Method__Group_3_1__1__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1599:1: rule__Method__Group_3_1__1__Impl : ( ( rule__Method__ParamsAssignment_3_1_1 ) ) ;
    public final void rule__Method__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1603:1: ( ( ( rule__Method__ParamsAssignment_3_1_1 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1604:1: ( ( rule__Method__ParamsAssignment_3_1_1 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1604:1: ( ( rule__Method__ParamsAssignment_3_1_1 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1605:1: ( rule__Method__ParamsAssignment_3_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getParamsAssignment_3_1_1()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1606:1: ( rule__Method__ParamsAssignment_3_1_1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1606:2: rule__Method__ParamsAssignment_3_1_1
            {
            pushFollow(FOLLOW_rule__Method__ParamsAssignment_3_1_1_in_rule__Method__Group_3_1__1__Impl3271);
            rule__Method__ParamsAssignment_3_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getParamsAssignment_3_1_1()); 
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
    // $ANTLR end "rule__Method__Group_3_1__1__Impl"


    // $ANTLR start "rule__Parameter__Group__0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1620:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1624:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1625:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
            {
            pushFollow(FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__03305);
            rule__Parameter__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__03308);
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
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1632:1: rule__Parameter__Group__0__Impl : ( ( rule__Parameter__TypeAssignment_0 ) ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1636:1: ( ( ( rule__Parameter__TypeAssignment_0 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1637:1: ( ( rule__Parameter__TypeAssignment_0 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1637:1: ( ( rule__Parameter__TypeAssignment_0 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1638:1: ( rule__Parameter__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getTypeAssignment_0()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1639:1: ( rule__Parameter__TypeAssignment_0 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1639:2: rule__Parameter__TypeAssignment_0
            {
            pushFollow(FOLLOW_rule__Parameter__TypeAssignment_0_in_rule__Parameter__Group__0__Impl3335);
            rule__Parameter__TypeAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getTypeAssignment_0()); 
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
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1649:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1653:1: ( rule__Parameter__Group__1__Impl )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1654:2: rule__Parameter__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__13365);
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
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1660:1: rule__Parameter__Group__1__Impl : ( ( rule__Parameter__NameAssignment_1 ) ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1664:1: ( ( ( rule__Parameter__NameAssignment_1 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1665:1: ( ( rule__Parameter__NameAssignment_1 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1665:1: ( ( rule__Parameter__NameAssignment_1 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1666:1: ( rule__Parameter__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getNameAssignment_1()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1667:1: ( rule__Parameter__NameAssignment_1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1667:2: rule__Parameter__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Parameter__NameAssignment_1_in_rule__Parameter__Group__1__Impl3392);
            rule__Parameter__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getNameAssignment_1()); 
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


    // $ANTLR start "rule__MethodBody__Group__0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1681:1: rule__MethodBody__Group__0 : rule__MethodBody__Group__0__Impl rule__MethodBody__Group__1 ;
    public final void rule__MethodBody__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1685:1: ( rule__MethodBody__Group__0__Impl rule__MethodBody__Group__1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1686:2: rule__MethodBody__Group__0__Impl rule__MethodBody__Group__1
            {
            pushFollow(FOLLOW_rule__MethodBody__Group__0__Impl_in_rule__MethodBody__Group__03426);
            rule__MethodBody__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MethodBody__Group__1_in_rule__MethodBody__Group__03429);
            rule__MethodBody__Group__1();

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
    // $ANTLR end "rule__MethodBody__Group__0"


    // $ANTLR start "rule__MethodBody__Group__0__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1693:1: rule__MethodBody__Group__0__Impl : ( 'return' ) ;
    public final void rule__MethodBody__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1697:1: ( ( 'return' ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1698:1: ( 'return' )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1698:1: ( 'return' )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1699:1: 'return'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodBodyAccess().getReturnKeyword_0()); 
            }
            match(input,24,FOLLOW_24_in_rule__MethodBody__Group__0__Impl3457); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodBodyAccess().getReturnKeyword_0()); 
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
    // $ANTLR end "rule__MethodBody__Group__0__Impl"


    // $ANTLR start "rule__MethodBody__Group__1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1712:1: rule__MethodBody__Group__1 : rule__MethodBody__Group__1__Impl rule__MethodBody__Group__2 ;
    public final void rule__MethodBody__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1716:1: ( rule__MethodBody__Group__1__Impl rule__MethodBody__Group__2 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1717:2: rule__MethodBody__Group__1__Impl rule__MethodBody__Group__2
            {
            pushFollow(FOLLOW_rule__MethodBody__Group__1__Impl_in_rule__MethodBody__Group__13488);
            rule__MethodBody__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MethodBody__Group__2_in_rule__MethodBody__Group__13491);
            rule__MethodBody__Group__2();

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
    // $ANTLR end "rule__MethodBody__Group__1"


    // $ANTLR start "rule__MethodBody__Group__1__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1724:1: rule__MethodBody__Group__1__Impl : ( ( rule__MethodBody__ExpressionAssignment_1 ) ) ;
    public final void rule__MethodBody__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1728:1: ( ( ( rule__MethodBody__ExpressionAssignment_1 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1729:1: ( ( rule__MethodBody__ExpressionAssignment_1 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1729:1: ( ( rule__MethodBody__ExpressionAssignment_1 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1730:1: ( rule__MethodBody__ExpressionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodBodyAccess().getExpressionAssignment_1()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1731:1: ( rule__MethodBody__ExpressionAssignment_1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1731:2: rule__MethodBody__ExpressionAssignment_1
            {
            pushFollow(FOLLOW_rule__MethodBody__ExpressionAssignment_1_in_rule__MethodBody__Group__1__Impl3518);
            rule__MethodBody__ExpressionAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodBodyAccess().getExpressionAssignment_1()); 
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
    // $ANTLR end "rule__MethodBody__Group__1__Impl"


    // $ANTLR start "rule__MethodBody__Group__2"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1741:1: rule__MethodBody__Group__2 : rule__MethodBody__Group__2__Impl ;
    public final void rule__MethodBody__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1745:1: ( rule__MethodBody__Group__2__Impl )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1746:2: rule__MethodBody__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__MethodBody__Group__2__Impl_in_rule__MethodBody__Group__23548);
            rule__MethodBody__Group__2__Impl();

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
    // $ANTLR end "rule__MethodBody__Group__2"


    // $ANTLR start "rule__MethodBody__Group__2__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1752:1: rule__MethodBody__Group__2__Impl : ( ';' ) ;
    public final void rule__MethodBody__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1756:1: ( ( ';' ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1757:1: ( ';' )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1757:1: ( ';' )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1758:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodBodyAccess().getSemicolonKeyword_2()); 
            }
            match(input,20,FOLLOW_20_in_rule__MethodBody__Group__2__Impl3576); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodBodyAccess().getSemicolonKeyword_2()); 
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
    // $ANTLR end "rule__MethodBody__Group__2__Impl"


    // $ANTLR start "rule__Expression__Group__0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1777:1: rule__Expression__Group__0 : rule__Expression__Group__0__Impl rule__Expression__Group__1 ;
    public final void rule__Expression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1781:1: ( rule__Expression__Group__0__Impl rule__Expression__Group__1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1782:2: rule__Expression__Group__0__Impl rule__Expression__Group__1
            {
            pushFollow(FOLLOW_rule__Expression__Group__0__Impl_in_rule__Expression__Group__03613);
            rule__Expression__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Expression__Group__1_in_rule__Expression__Group__03616);
            rule__Expression__Group__1();

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
    // $ANTLR end "rule__Expression__Group__0"


    // $ANTLR start "rule__Expression__Group__0__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1789:1: rule__Expression__Group__0__Impl : ( ruleTerminalExpression ) ;
    public final void rule__Expression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1793:1: ( ( ruleTerminalExpression ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1794:1: ( ruleTerminalExpression )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1794:1: ( ruleTerminalExpression )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1795:1: ruleTerminalExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getTerminalExpressionParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleTerminalExpression_in_rule__Expression__Group__0__Impl3643);
            ruleTerminalExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getTerminalExpressionParserRuleCall_0()); 
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
    // $ANTLR end "rule__Expression__Group__0__Impl"


    // $ANTLR start "rule__Expression__Group__1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1806:1: rule__Expression__Group__1 : rule__Expression__Group__1__Impl ;
    public final void rule__Expression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1810:1: ( rule__Expression__Group__1__Impl )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1811:2: rule__Expression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Expression__Group__1__Impl_in_rule__Expression__Group__13672);
            rule__Expression__Group__1__Impl();

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
    // $ANTLR end "rule__Expression__Group__1"


    // $ANTLR start "rule__Expression__Group__1__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1817:1: rule__Expression__Group__1__Impl : ( ( rule__Expression__Group_1__0 )* ) ;
    public final void rule__Expression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1821:1: ( ( ( rule__Expression__Group_1__0 )* ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1822:1: ( ( rule__Expression__Group_1__0 )* )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1822:1: ( ( rule__Expression__Group_1__0 )* )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1823:1: ( rule__Expression__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getGroup_1()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1824:1: ( rule__Expression__Group_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==25) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1824:2: rule__Expression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Expression__Group_1__0_in_rule__Expression__Group__1__Impl3699);
            	    rule__Expression__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getGroup_1()); 
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
    // $ANTLR end "rule__Expression__Group__1__Impl"


    // $ANTLR start "rule__Expression__Group_1__0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1838:1: rule__Expression__Group_1__0 : rule__Expression__Group_1__0__Impl ;
    public final void rule__Expression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1842:1: ( rule__Expression__Group_1__0__Impl )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1843:2: rule__Expression__Group_1__0__Impl
            {
            pushFollow(FOLLOW_rule__Expression__Group_1__0__Impl_in_rule__Expression__Group_1__03734);
            rule__Expression__Group_1__0__Impl();

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
    // $ANTLR end "rule__Expression__Group_1__0"


    // $ANTLR start "rule__Expression__Group_1__0__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1849:1: rule__Expression__Group_1__0__Impl : ( ( rule__Expression__Group_1_0__0 ) ) ;
    public final void rule__Expression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1853:1: ( ( ( rule__Expression__Group_1_0__0 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1854:1: ( ( rule__Expression__Group_1_0__0 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1854:1: ( ( rule__Expression__Group_1_0__0 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1855:1: ( rule__Expression__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getGroup_1_0()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1856:1: ( rule__Expression__Group_1_0__0 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1856:2: rule__Expression__Group_1_0__0
            {
            pushFollow(FOLLOW_rule__Expression__Group_1_0__0_in_rule__Expression__Group_1__0__Impl3761);
            rule__Expression__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getGroup_1_0()); 
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
    // $ANTLR end "rule__Expression__Group_1__0__Impl"


    // $ANTLR start "rule__Expression__Group_1_0__0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1868:1: rule__Expression__Group_1_0__0 : rule__Expression__Group_1_0__0__Impl rule__Expression__Group_1_0__1 ;
    public final void rule__Expression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1872:1: ( rule__Expression__Group_1_0__0__Impl rule__Expression__Group_1_0__1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1873:2: rule__Expression__Group_1_0__0__Impl rule__Expression__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__Expression__Group_1_0__0__Impl_in_rule__Expression__Group_1_0__03793);
            rule__Expression__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Expression__Group_1_0__1_in_rule__Expression__Group_1_0__03796);
            rule__Expression__Group_1_0__1();

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
    // $ANTLR end "rule__Expression__Group_1_0__0"


    // $ANTLR start "rule__Expression__Group_1_0__0__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1880:1: rule__Expression__Group_1_0__0__Impl : ( () ) ;
    public final void rule__Expression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1884:1: ( ( () ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1885:1: ( () )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1885:1: ( () )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1886:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getSelectionReceiverAction_1_0_0()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1887:1: ()
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1889:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getSelectionReceiverAction_1_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_1_0__0__Impl"


    // $ANTLR start "rule__Expression__Group_1_0__1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1899:1: rule__Expression__Group_1_0__1 : rule__Expression__Group_1_0__1__Impl rule__Expression__Group_1_0__2 ;
    public final void rule__Expression__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1903:1: ( rule__Expression__Group_1_0__1__Impl rule__Expression__Group_1_0__2 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1904:2: rule__Expression__Group_1_0__1__Impl rule__Expression__Group_1_0__2
            {
            pushFollow(FOLLOW_rule__Expression__Group_1_0__1__Impl_in_rule__Expression__Group_1_0__13854);
            rule__Expression__Group_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Expression__Group_1_0__2_in_rule__Expression__Group_1_0__13857);
            rule__Expression__Group_1_0__2();

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
    // $ANTLR end "rule__Expression__Group_1_0__1"


    // $ANTLR start "rule__Expression__Group_1_0__1__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1911:1: rule__Expression__Group_1_0__1__Impl : ( '.' ) ;
    public final void rule__Expression__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1915:1: ( ( '.' ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1916:1: ( '.' )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1916:1: ( '.' )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1917:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getFullStopKeyword_1_0_1()); 
            }
            match(input,25,FOLLOW_25_in_rule__Expression__Group_1_0__1__Impl3885); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getFullStopKeyword_1_0_1()); 
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
    // $ANTLR end "rule__Expression__Group_1_0__1__Impl"


    // $ANTLR start "rule__Expression__Group_1_0__2"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1930:1: rule__Expression__Group_1_0__2 : rule__Expression__Group_1_0__2__Impl rule__Expression__Group_1_0__3 ;
    public final void rule__Expression__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1934:1: ( rule__Expression__Group_1_0__2__Impl rule__Expression__Group_1_0__3 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1935:2: rule__Expression__Group_1_0__2__Impl rule__Expression__Group_1_0__3
            {
            pushFollow(FOLLOW_rule__Expression__Group_1_0__2__Impl_in_rule__Expression__Group_1_0__23916);
            rule__Expression__Group_1_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Expression__Group_1_0__3_in_rule__Expression__Group_1_0__23919);
            rule__Expression__Group_1_0__3();

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
    // $ANTLR end "rule__Expression__Group_1_0__2"


    // $ANTLR start "rule__Expression__Group_1_0__2__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1942:1: rule__Expression__Group_1_0__2__Impl : ( ( rule__Expression__MessageAssignment_1_0_2 ) ) ;
    public final void rule__Expression__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1946:1: ( ( ( rule__Expression__MessageAssignment_1_0_2 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1947:1: ( ( rule__Expression__MessageAssignment_1_0_2 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1947:1: ( ( rule__Expression__MessageAssignment_1_0_2 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1948:1: ( rule__Expression__MessageAssignment_1_0_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getMessageAssignment_1_0_2()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1949:1: ( rule__Expression__MessageAssignment_1_0_2 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1949:2: rule__Expression__MessageAssignment_1_0_2
            {
            pushFollow(FOLLOW_rule__Expression__MessageAssignment_1_0_2_in_rule__Expression__Group_1_0__2__Impl3946);
            rule__Expression__MessageAssignment_1_0_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getMessageAssignment_1_0_2()); 
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
    // $ANTLR end "rule__Expression__Group_1_0__2__Impl"


    // $ANTLR start "rule__Expression__Group_1_0__3"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1959:1: rule__Expression__Group_1_0__3 : rule__Expression__Group_1_0__3__Impl ;
    public final void rule__Expression__Group_1_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1963:1: ( rule__Expression__Group_1_0__3__Impl )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1964:2: rule__Expression__Group_1_0__3__Impl
            {
            pushFollow(FOLLOW_rule__Expression__Group_1_0__3__Impl_in_rule__Expression__Group_1_0__33976);
            rule__Expression__Group_1_0__3__Impl();

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
    // $ANTLR end "rule__Expression__Group_1_0__3"


    // $ANTLR start "rule__Expression__Group_1_0__3__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1970:1: rule__Expression__Group_1_0__3__Impl : ( ( rule__Expression__Group_1_0_3__0 )? ) ;
    public final void rule__Expression__Group_1_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1974:1: ( ( ( rule__Expression__Group_1_0_3__0 )? ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1975:1: ( ( rule__Expression__Group_1_0_3__0 )? )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1975:1: ( ( rule__Expression__Group_1_0_3__0 )? )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1976:1: ( rule__Expression__Group_1_0_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getGroup_1_0_3()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1977:1: ( rule__Expression__Group_1_0_3__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==21) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1977:2: rule__Expression__Group_1_0_3__0
                    {
                    pushFollow(FOLLOW_rule__Expression__Group_1_0_3__0_in_rule__Expression__Group_1_0__3__Impl4003);
                    rule__Expression__Group_1_0_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getGroup_1_0_3()); 
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
    // $ANTLR end "rule__Expression__Group_1_0__3__Impl"


    // $ANTLR start "rule__Expression__Group_1_0_3__0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1995:1: rule__Expression__Group_1_0_3__0 : rule__Expression__Group_1_0_3__0__Impl rule__Expression__Group_1_0_3__1 ;
    public final void rule__Expression__Group_1_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:1999:1: ( rule__Expression__Group_1_0_3__0__Impl rule__Expression__Group_1_0_3__1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2000:2: rule__Expression__Group_1_0_3__0__Impl rule__Expression__Group_1_0_3__1
            {
            pushFollow(FOLLOW_rule__Expression__Group_1_0_3__0__Impl_in_rule__Expression__Group_1_0_3__04042);
            rule__Expression__Group_1_0_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Expression__Group_1_0_3__1_in_rule__Expression__Group_1_0_3__04045);
            rule__Expression__Group_1_0_3__1();

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
    // $ANTLR end "rule__Expression__Group_1_0_3__0"


    // $ANTLR start "rule__Expression__Group_1_0_3__0__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2007:1: rule__Expression__Group_1_0_3__0__Impl : ( '(' ) ;
    public final void rule__Expression__Group_1_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2011:1: ( ( '(' ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2012:1: ( '(' )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2012:1: ( '(' )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2013:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getLeftParenthesisKeyword_1_0_3_0()); 
            }
            match(input,21,FOLLOW_21_in_rule__Expression__Group_1_0_3__0__Impl4073); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getLeftParenthesisKeyword_1_0_3_0()); 
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
    // $ANTLR end "rule__Expression__Group_1_0_3__0__Impl"


    // $ANTLR start "rule__Expression__Group_1_0_3__1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2026:1: rule__Expression__Group_1_0_3__1 : rule__Expression__Group_1_0_3__1__Impl rule__Expression__Group_1_0_3__2 ;
    public final void rule__Expression__Group_1_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2030:1: ( rule__Expression__Group_1_0_3__1__Impl rule__Expression__Group_1_0_3__2 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2031:2: rule__Expression__Group_1_0_3__1__Impl rule__Expression__Group_1_0_3__2
            {
            pushFollow(FOLLOW_rule__Expression__Group_1_0_3__1__Impl_in_rule__Expression__Group_1_0_3__14104);
            rule__Expression__Group_1_0_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Expression__Group_1_0_3__2_in_rule__Expression__Group_1_0_3__14107);
            rule__Expression__Group_1_0_3__2();

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
    // $ANTLR end "rule__Expression__Group_1_0_3__1"


    // $ANTLR start "rule__Expression__Group_1_0_3__1__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2038:1: rule__Expression__Group_1_0_3__1__Impl : ( ( rule__Expression__Group_1_0_3_1__0 )? ) ;
    public final void rule__Expression__Group_1_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2042:1: ( ( ( rule__Expression__Group_1_0_3_1__0 )? ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2043:1: ( ( rule__Expression__Group_1_0_3_1__0 )? )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2043:1: ( ( rule__Expression__Group_1_0_3_1__0 )? )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2044:1: ( rule__Expression__Group_1_0_3_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getGroup_1_0_3_1()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2045:1: ( rule__Expression__Group_1_0_3_1__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=RULE_ID && LA15_0<=RULE_INT)||(LA15_0>=14 && LA15_0<=15)||LA15_0==21||(LA15_0>=26 && LA15_0<=27)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2045:2: rule__Expression__Group_1_0_3_1__0
                    {
                    pushFollow(FOLLOW_rule__Expression__Group_1_0_3_1__0_in_rule__Expression__Group_1_0_3__1__Impl4134);
                    rule__Expression__Group_1_0_3_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getGroup_1_0_3_1()); 
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
    // $ANTLR end "rule__Expression__Group_1_0_3__1__Impl"


    // $ANTLR start "rule__Expression__Group_1_0_3__2"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2055:1: rule__Expression__Group_1_0_3__2 : rule__Expression__Group_1_0_3__2__Impl ;
    public final void rule__Expression__Group_1_0_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2059:1: ( rule__Expression__Group_1_0_3__2__Impl )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2060:2: rule__Expression__Group_1_0_3__2__Impl
            {
            pushFollow(FOLLOW_rule__Expression__Group_1_0_3__2__Impl_in_rule__Expression__Group_1_0_3__24165);
            rule__Expression__Group_1_0_3__2__Impl();

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
    // $ANTLR end "rule__Expression__Group_1_0_3__2"


    // $ANTLR start "rule__Expression__Group_1_0_3__2__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2066:1: rule__Expression__Group_1_0_3__2__Impl : ( ')' ) ;
    public final void rule__Expression__Group_1_0_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2070:1: ( ( ')' ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2071:1: ( ')' )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2071:1: ( ')' )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2072:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getRightParenthesisKeyword_1_0_3_2()); 
            }
            match(input,22,FOLLOW_22_in_rule__Expression__Group_1_0_3__2__Impl4193); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getRightParenthesisKeyword_1_0_3_2()); 
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
    // $ANTLR end "rule__Expression__Group_1_0_3__2__Impl"


    // $ANTLR start "rule__Expression__Group_1_0_3_1__0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2091:1: rule__Expression__Group_1_0_3_1__0 : rule__Expression__Group_1_0_3_1__0__Impl rule__Expression__Group_1_0_3_1__1 ;
    public final void rule__Expression__Group_1_0_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2095:1: ( rule__Expression__Group_1_0_3_1__0__Impl rule__Expression__Group_1_0_3_1__1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2096:2: rule__Expression__Group_1_0_3_1__0__Impl rule__Expression__Group_1_0_3_1__1
            {
            pushFollow(FOLLOW_rule__Expression__Group_1_0_3_1__0__Impl_in_rule__Expression__Group_1_0_3_1__04230);
            rule__Expression__Group_1_0_3_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Expression__Group_1_0_3_1__1_in_rule__Expression__Group_1_0_3_1__04233);
            rule__Expression__Group_1_0_3_1__1();

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
    // $ANTLR end "rule__Expression__Group_1_0_3_1__0"


    // $ANTLR start "rule__Expression__Group_1_0_3_1__0__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2103:1: rule__Expression__Group_1_0_3_1__0__Impl : ( ( rule__Expression__ArgsAssignment_1_0_3_1_0 ) ) ;
    public final void rule__Expression__Group_1_0_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2107:1: ( ( ( rule__Expression__ArgsAssignment_1_0_3_1_0 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2108:1: ( ( rule__Expression__ArgsAssignment_1_0_3_1_0 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2108:1: ( ( rule__Expression__ArgsAssignment_1_0_3_1_0 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2109:1: ( rule__Expression__ArgsAssignment_1_0_3_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getArgsAssignment_1_0_3_1_0()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2110:1: ( rule__Expression__ArgsAssignment_1_0_3_1_0 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2110:2: rule__Expression__ArgsAssignment_1_0_3_1_0
            {
            pushFollow(FOLLOW_rule__Expression__ArgsAssignment_1_0_3_1_0_in_rule__Expression__Group_1_0_3_1__0__Impl4260);
            rule__Expression__ArgsAssignment_1_0_3_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getArgsAssignment_1_0_3_1_0()); 
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
    // $ANTLR end "rule__Expression__Group_1_0_3_1__0__Impl"


    // $ANTLR start "rule__Expression__Group_1_0_3_1__1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2120:1: rule__Expression__Group_1_0_3_1__1 : rule__Expression__Group_1_0_3_1__1__Impl ;
    public final void rule__Expression__Group_1_0_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2124:1: ( rule__Expression__Group_1_0_3_1__1__Impl )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2125:2: rule__Expression__Group_1_0_3_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Expression__Group_1_0_3_1__1__Impl_in_rule__Expression__Group_1_0_3_1__14290);
            rule__Expression__Group_1_0_3_1__1__Impl();

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
    // $ANTLR end "rule__Expression__Group_1_0_3_1__1"


    // $ANTLR start "rule__Expression__Group_1_0_3_1__1__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2131:1: rule__Expression__Group_1_0_3_1__1__Impl : ( ( rule__Expression__Group_1_0_3_1_1__0 )* ) ;
    public final void rule__Expression__Group_1_0_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2135:1: ( ( ( rule__Expression__Group_1_0_3_1_1__0 )* ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2136:1: ( ( rule__Expression__Group_1_0_3_1_1__0 )* )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2136:1: ( ( rule__Expression__Group_1_0_3_1_1__0 )* )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2137:1: ( rule__Expression__Group_1_0_3_1_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getGroup_1_0_3_1_1()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2138:1: ( rule__Expression__Group_1_0_3_1_1__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==23) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2138:2: rule__Expression__Group_1_0_3_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Expression__Group_1_0_3_1_1__0_in_rule__Expression__Group_1_0_3_1__1__Impl4317);
            	    rule__Expression__Group_1_0_3_1_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getGroup_1_0_3_1_1()); 
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
    // $ANTLR end "rule__Expression__Group_1_0_3_1__1__Impl"


    // $ANTLR start "rule__Expression__Group_1_0_3_1_1__0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2152:1: rule__Expression__Group_1_0_3_1_1__0 : rule__Expression__Group_1_0_3_1_1__0__Impl rule__Expression__Group_1_0_3_1_1__1 ;
    public final void rule__Expression__Group_1_0_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2156:1: ( rule__Expression__Group_1_0_3_1_1__0__Impl rule__Expression__Group_1_0_3_1_1__1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2157:2: rule__Expression__Group_1_0_3_1_1__0__Impl rule__Expression__Group_1_0_3_1_1__1
            {
            pushFollow(FOLLOW_rule__Expression__Group_1_0_3_1_1__0__Impl_in_rule__Expression__Group_1_0_3_1_1__04352);
            rule__Expression__Group_1_0_3_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Expression__Group_1_0_3_1_1__1_in_rule__Expression__Group_1_0_3_1_1__04355);
            rule__Expression__Group_1_0_3_1_1__1();

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
    // $ANTLR end "rule__Expression__Group_1_0_3_1_1__0"


    // $ANTLR start "rule__Expression__Group_1_0_3_1_1__0__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2164:1: rule__Expression__Group_1_0_3_1_1__0__Impl : ( ',' ) ;
    public final void rule__Expression__Group_1_0_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2168:1: ( ( ',' ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2169:1: ( ',' )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2169:1: ( ',' )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2170:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getCommaKeyword_1_0_3_1_1_0()); 
            }
            match(input,23,FOLLOW_23_in_rule__Expression__Group_1_0_3_1_1__0__Impl4383); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getCommaKeyword_1_0_3_1_1_0()); 
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
    // $ANTLR end "rule__Expression__Group_1_0_3_1_1__0__Impl"


    // $ANTLR start "rule__Expression__Group_1_0_3_1_1__1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2183:1: rule__Expression__Group_1_0_3_1_1__1 : rule__Expression__Group_1_0_3_1_1__1__Impl ;
    public final void rule__Expression__Group_1_0_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2187:1: ( rule__Expression__Group_1_0_3_1_1__1__Impl )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2188:2: rule__Expression__Group_1_0_3_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Expression__Group_1_0_3_1_1__1__Impl_in_rule__Expression__Group_1_0_3_1_1__14414);
            rule__Expression__Group_1_0_3_1_1__1__Impl();

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
    // $ANTLR end "rule__Expression__Group_1_0_3_1_1__1"


    // $ANTLR start "rule__Expression__Group_1_0_3_1_1__1__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2194:1: rule__Expression__Group_1_0_3_1_1__1__Impl : ( ( rule__Expression__ArgsAssignment_1_0_3_1_1_1 ) ) ;
    public final void rule__Expression__Group_1_0_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2198:1: ( ( ( rule__Expression__ArgsAssignment_1_0_3_1_1_1 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2199:1: ( ( rule__Expression__ArgsAssignment_1_0_3_1_1_1 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2199:1: ( ( rule__Expression__ArgsAssignment_1_0_3_1_1_1 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2200:1: ( rule__Expression__ArgsAssignment_1_0_3_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getArgsAssignment_1_0_3_1_1_1()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2201:1: ( rule__Expression__ArgsAssignment_1_0_3_1_1_1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2201:2: rule__Expression__ArgsAssignment_1_0_3_1_1_1
            {
            pushFollow(FOLLOW_rule__Expression__ArgsAssignment_1_0_3_1_1_1_in_rule__Expression__Group_1_0_3_1_1__1__Impl4441);
            rule__Expression__ArgsAssignment_1_0_3_1_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getArgsAssignment_1_0_3_1_1_1()); 
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
    // $ANTLR end "rule__Expression__Group_1_0_3_1_1__1__Impl"


    // $ANTLR start "rule__New__Group__0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2215:1: rule__New__Group__0 : rule__New__Group__0__Impl rule__New__Group__1 ;
    public final void rule__New__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2219:1: ( rule__New__Group__0__Impl rule__New__Group__1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2220:2: rule__New__Group__0__Impl rule__New__Group__1
            {
            pushFollow(FOLLOW_rule__New__Group__0__Impl_in_rule__New__Group__04475);
            rule__New__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__New__Group__1_in_rule__New__Group__04478);
            rule__New__Group__1();

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
    // $ANTLR end "rule__New__Group__0"


    // $ANTLR start "rule__New__Group__0__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2227:1: rule__New__Group__0__Impl : ( 'new' ) ;
    public final void rule__New__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2231:1: ( ( 'new' ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2232:1: ( 'new' )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2232:1: ( 'new' )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2233:1: 'new'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNewAccess().getNewKeyword_0()); 
            }
            match(input,26,FOLLOW_26_in_rule__New__Group__0__Impl4506); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNewAccess().getNewKeyword_0()); 
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
    // $ANTLR end "rule__New__Group__0__Impl"


    // $ANTLR start "rule__New__Group__1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2246:1: rule__New__Group__1 : rule__New__Group__1__Impl rule__New__Group__2 ;
    public final void rule__New__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2250:1: ( rule__New__Group__1__Impl rule__New__Group__2 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2251:2: rule__New__Group__1__Impl rule__New__Group__2
            {
            pushFollow(FOLLOW_rule__New__Group__1__Impl_in_rule__New__Group__14537);
            rule__New__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__New__Group__2_in_rule__New__Group__14540);
            rule__New__Group__2();

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
    // $ANTLR end "rule__New__Group__1"


    // $ANTLR start "rule__New__Group__1__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2258:1: rule__New__Group__1__Impl : ( ( rule__New__TypeAssignment_1 ) ) ;
    public final void rule__New__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2262:1: ( ( ( rule__New__TypeAssignment_1 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2263:1: ( ( rule__New__TypeAssignment_1 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2263:1: ( ( rule__New__TypeAssignment_1 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2264:1: ( rule__New__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNewAccess().getTypeAssignment_1()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2265:1: ( rule__New__TypeAssignment_1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2265:2: rule__New__TypeAssignment_1
            {
            pushFollow(FOLLOW_rule__New__TypeAssignment_1_in_rule__New__Group__1__Impl4567);
            rule__New__TypeAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNewAccess().getTypeAssignment_1()); 
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
    // $ANTLR end "rule__New__Group__1__Impl"


    // $ANTLR start "rule__New__Group__2"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2275:1: rule__New__Group__2 : rule__New__Group__2__Impl rule__New__Group__3 ;
    public final void rule__New__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2279:1: ( rule__New__Group__2__Impl rule__New__Group__3 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2280:2: rule__New__Group__2__Impl rule__New__Group__3
            {
            pushFollow(FOLLOW_rule__New__Group__2__Impl_in_rule__New__Group__24597);
            rule__New__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__New__Group__3_in_rule__New__Group__24600);
            rule__New__Group__3();

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
    // $ANTLR end "rule__New__Group__2"


    // $ANTLR start "rule__New__Group__2__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2287:1: rule__New__Group__2__Impl : ( '(' ) ;
    public final void rule__New__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2291:1: ( ( '(' ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2292:1: ( '(' )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2292:1: ( '(' )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2293:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNewAccess().getLeftParenthesisKeyword_2()); 
            }
            match(input,21,FOLLOW_21_in_rule__New__Group__2__Impl4628); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNewAccess().getLeftParenthesisKeyword_2()); 
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
    // $ANTLR end "rule__New__Group__2__Impl"


    // $ANTLR start "rule__New__Group__3"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2306:1: rule__New__Group__3 : rule__New__Group__3__Impl rule__New__Group__4 ;
    public final void rule__New__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2310:1: ( rule__New__Group__3__Impl rule__New__Group__4 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2311:2: rule__New__Group__3__Impl rule__New__Group__4
            {
            pushFollow(FOLLOW_rule__New__Group__3__Impl_in_rule__New__Group__34659);
            rule__New__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__New__Group__4_in_rule__New__Group__34662);
            rule__New__Group__4();

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
    // $ANTLR end "rule__New__Group__3"


    // $ANTLR start "rule__New__Group__3__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2318:1: rule__New__Group__3__Impl : ( ( rule__New__Group_3__0 )? ) ;
    public final void rule__New__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2322:1: ( ( ( rule__New__Group_3__0 )? ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2323:1: ( ( rule__New__Group_3__0 )? )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2323:1: ( ( rule__New__Group_3__0 )? )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2324:1: ( rule__New__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNewAccess().getGroup_3()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2325:1: ( rule__New__Group_3__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=RULE_ID && LA17_0<=RULE_INT)||(LA17_0>=14 && LA17_0<=15)||LA17_0==21||(LA17_0>=26 && LA17_0<=27)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2325:2: rule__New__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__New__Group_3__0_in_rule__New__Group__3__Impl4689);
                    rule__New__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNewAccess().getGroup_3()); 
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
    // $ANTLR end "rule__New__Group__3__Impl"


    // $ANTLR start "rule__New__Group__4"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2335:1: rule__New__Group__4 : rule__New__Group__4__Impl ;
    public final void rule__New__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2339:1: ( rule__New__Group__4__Impl )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2340:2: rule__New__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__New__Group__4__Impl_in_rule__New__Group__44720);
            rule__New__Group__4__Impl();

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
    // $ANTLR end "rule__New__Group__4"


    // $ANTLR start "rule__New__Group__4__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2346:1: rule__New__Group__4__Impl : ( ')' ) ;
    public final void rule__New__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2350:1: ( ( ')' ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2351:1: ( ')' )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2351:1: ( ')' )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2352:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNewAccess().getRightParenthesisKeyword_4()); 
            }
            match(input,22,FOLLOW_22_in_rule__New__Group__4__Impl4748); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNewAccess().getRightParenthesisKeyword_4()); 
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
    // $ANTLR end "rule__New__Group__4__Impl"


    // $ANTLR start "rule__New__Group_3__0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2375:1: rule__New__Group_3__0 : rule__New__Group_3__0__Impl rule__New__Group_3__1 ;
    public final void rule__New__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2379:1: ( rule__New__Group_3__0__Impl rule__New__Group_3__1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2380:2: rule__New__Group_3__0__Impl rule__New__Group_3__1
            {
            pushFollow(FOLLOW_rule__New__Group_3__0__Impl_in_rule__New__Group_3__04789);
            rule__New__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__New__Group_3__1_in_rule__New__Group_3__04792);
            rule__New__Group_3__1();

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
    // $ANTLR end "rule__New__Group_3__0"


    // $ANTLR start "rule__New__Group_3__0__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2387:1: rule__New__Group_3__0__Impl : ( ( rule__New__ArgsAssignment_3_0 ) ) ;
    public final void rule__New__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2391:1: ( ( ( rule__New__ArgsAssignment_3_0 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2392:1: ( ( rule__New__ArgsAssignment_3_0 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2392:1: ( ( rule__New__ArgsAssignment_3_0 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2393:1: ( rule__New__ArgsAssignment_3_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNewAccess().getArgsAssignment_3_0()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2394:1: ( rule__New__ArgsAssignment_3_0 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2394:2: rule__New__ArgsAssignment_3_0
            {
            pushFollow(FOLLOW_rule__New__ArgsAssignment_3_0_in_rule__New__Group_3__0__Impl4819);
            rule__New__ArgsAssignment_3_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNewAccess().getArgsAssignment_3_0()); 
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
    // $ANTLR end "rule__New__Group_3__0__Impl"


    // $ANTLR start "rule__New__Group_3__1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2404:1: rule__New__Group_3__1 : rule__New__Group_3__1__Impl ;
    public final void rule__New__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2408:1: ( rule__New__Group_3__1__Impl )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2409:2: rule__New__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__New__Group_3__1__Impl_in_rule__New__Group_3__14849);
            rule__New__Group_3__1__Impl();

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
    // $ANTLR end "rule__New__Group_3__1"


    // $ANTLR start "rule__New__Group_3__1__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2415:1: rule__New__Group_3__1__Impl : ( ( rule__New__Group_3_1__0 )* ) ;
    public final void rule__New__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2419:1: ( ( ( rule__New__Group_3_1__0 )* ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2420:1: ( ( rule__New__Group_3_1__0 )* )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2420:1: ( ( rule__New__Group_3_1__0 )* )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2421:1: ( rule__New__Group_3_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNewAccess().getGroup_3_1()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2422:1: ( rule__New__Group_3_1__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==23) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2422:2: rule__New__Group_3_1__0
            	    {
            	    pushFollow(FOLLOW_rule__New__Group_3_1__0_in_rule__New__Group_3__1__Impl4876);
            	    rule__New__Group_3_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNewAccess().getGroup_3_1()); 
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
    // $ANTLR end "rule__New__Group_3__1__Impl"


    // $ANTLR start "rule__New__Group_3_1__0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2436:1: rule__New__Group_3_1__0 : rule__New__Group_3_1__0__Impl rule__New__Group_3_1__1 ;
    public final void rule__New__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2440:1: ( rule__New__Group_3_1__0__Impl rule__New__Group_3_1__1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2441:2: rule__New__Group_3_1__0__Impl rule__New__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__New__Group_3_1__0__Impl_in_rule__New__Group_3_1__04911);
            rule__New__Group_3_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__New__Group_3_1__1_in_rule__New__Group_3_1__04914);
            rule__New__Group_3_1__1();

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
    // $ANTLR end "rule__New__Group_3_1__0"


    // $ANTLR start "rule__New__Group_3_1__0__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2448:1: rule__New__Group_3_1__0__Impl : ( ',' ) ;
    public final void rule__New__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2452:1: ( ( ',' ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2453:1: ( ',' )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2453:1: ( ',' )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2454:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNewAccess().getCommaKeyword_3_1_0()); 
            }
            match(input,23,FOLLOW_23_in_rule__New__Group_3_1__0__Impl4942); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNewAccess().getCommaKeyword_3_1_0()); 
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
    // $ANTLR end "rule__New__Group_3_1__0__Impl"


    // $ANTLR start "rule__New__Group_3_1__1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2467:1: rule__New__Group_3_1__1 : rule__New__Group_3_1__1__Impl ;
    public final void rule__New__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2471:1: ( rule__New__Group_3_1__1__Impl )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2472:2: rule__New__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_rule__New__Group_3_1__1__Impl_in_rule__New__Group_3_1__14973);
            rule__New__Group_3_1__1__Impl();

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
    // $ANTLR end "rule__New__Group_3_1__1"


    // $ANTLR start "rule__New__Group_3_1__1__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2478:1: rule__New__Group_3_1__1__Impl : ( ( rule__New__ArgsAssignment_3_1_1 ) ) ;
    public final void rule__New__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2482:1: ( ( ( rule__New__ArgsAssignment_3_1_1 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2483:1: ( ( rule__New__ArgsAssignment_3_1_1 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2483:1: ( ( rule__New__ArgsAssignment_3_1_1 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2484:1: ( rule__New__ArgsAssignment_3_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNewAccess().getArgsAssignment_3_1_1()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2485:1: ( rule__New__ArgsAssignment_3_1_1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2485:2: rule__New__ArgsAssignment_3_1_1
            {
            pushFollow(FOLLOW_rule__New__ArgsAssignment_3_1_1_in_rule__New__Group_3_1__1__Impl5000);
            rule__New__ArgsAssignment_3_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNewAccess().getArgsAssignment_3_1_1()); 
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
    // $ANTLR end "rule__New__Group_3_1__1__Impl"


    // $ANTLR start "rule__Cast__Group__0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2499:1: rule__Cast__Group__0 : rule__Cast__Group__0__Impl rule__Cast__Group__1 ;
    public final void rule__Cast__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2503:1: ( rule__Cast__Group__0__Impl rule__Cast__Group__1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2504:2: rule__Cast__Group__0__Impl rule__Cast__Group__1
            {
            pushFollow(FOLLOW_rule__Cast__Group__0__Impl_in_rule__Cast__Group__05034);
            rule__Cast__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Cast__Group__1_in_rule__Cast__Group__05037);
            rule__Cast__Group__1();

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
    // $ANTLR end "rule__Cast__Group__0"


    // $ANTLR start "rule__Cast__Group__0__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2511:1: rule__Cast__Group__0__Impl : ( '(' ) ;
    public final void rule__Cast__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2515:1: ( ( '(' ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2516:1: ( '(' )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2516:1: ( '(' )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2517:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCastAccess().getLeftParenthesisKeyword_0()); 
            }
            match(input,21,FOLLOW_21_in_rule__Cast__Group__0__Impl5065); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCastAccess().getLeftParenthesisKeyword_0()); 
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
    // $ANTLR end "rule__Cast__Group__0__Impl"


    // $ANTLR start "rule__Cast__Group__1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2530:1: rule__Cast__Group__1 : rule__Cast__Group__1__Impl rule__Cast__Group__2 ;
    public final void rule__Cast__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2534:1: ( rule__Cast__Group__1__Impl rule__Cast__Group__2 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2535:2: rule__Cast__Group__1__Impl rule__Cast__Group__2
            {
            pushFollow(FOLLOW_rule__Cast__Group__1__Impl_in_rule__Cast__Group__15096);
            rule__Cast__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Cast__Group__2_in_rule__Cast__Group__15099);
            rule__Cast__Group__2();

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
    // $ANTLR end "rule__Cast__Group__1"


    // $ANTLR start "rule__Cast__Group__1__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2542:1: rule__Cast__Group__1__Impl : ( ( rule__Cast__TypeAssignment_1 ) ) ;
    public final void rule__Cast__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2546:1: ( ( ( rule__Cast__TypeAssignment_1 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2547:1: ( ( rule__Cast__TypeAssignment_1 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2547:1: ( ( rule__Cast__TypeAssignment_1 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2548:1: ( rule__Cast__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCastAccess().getTypeAssignment_1()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2549:1: ( rule__Cast__TypeAssignment_1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2549:2: rule__Cast__TypeAssignment_1
            {
            pushFollow(FOLLOW_rule__Cast__TypeAssignment_1_in_rule__Cast__Group__1__Impl5126);
            rule__Cast__TypeAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCastAccess().getTypeAssignment_1()); 
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
    // $ANTLR end "rule__Cast__Group__1__Impl"


    // $ANTLR start "rule__Cast__Group__2"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2559:1: rule__Cast__Group__2 : rule__Cast__Group__2__Impl rule__Cast__Group__3 ;
    public final void rule__Cast__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2563:1: ( rule__Cast__Group__2__Impl rule__Cast__Group__3 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2564:2: rule__Cast__Group__2__Impl rule__Cast__Group__3
            {
            pushFollow(FOLLOW_rule__Cast__Group__2__Impl_in_rule__Cast__Group__25156);
            rule__Cast__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Cast__Group__3_in_rule__Cast__Group__25159);
            rule__Cast__Group__3();

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
    // $ANTLR end "rule__Cast__Group__2"


    // $ANTLR start "rule__Cast__Group__2__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2571:1: rule__Cast__Group__2__Impl : ( ')' ) ;
    public final void rule__Cast__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2575:1: ( ( ')' ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2576:1: ( ')' )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2576:1: ( ')' )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2577:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCastAccess().getRightParenthesisKeyword_2()); 
            }
            match(input,22,FOLLOW_22_in_rule__Cast__Group__2__Impl5187); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCastAccess().getRightParenthesisKeyword_2()); 
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
    // $ANTLR end "rule__Cast__Group__2__Impl"


    // $ANTLR start "rule__Cast__Group__3"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2590:1: rule__Cast__Group__3 : rule__Cast__Group__3__Impl ;
    public final void rule__Cast__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2594:1: ( rule__Cast__Group__3__Impl )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2595:2: rule__Cast__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Cast__Group__3__Impl_in_rule__Cast__Group__35218);
            rule__Cast__Group__3__Impl();

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
    // $ANTLR end "rule__Cast__Group__3"


    // $ANTLR start "rule__Cast__Group__3__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2601:1: rule__Cast__Group__3__Impl : ( ( rule__Cast__ExpressionAssignment_3 ) ) ;
    public final void rule__Cast__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2605:1: ( ( ( rule__Cast__ExpressionAssignment_3 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2606:1: ( ( rule__Cast__ExpressionAssignment_3 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2606:1: ( ( rule__Cast__ExpressionAssignment_3 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2607:1: ( rule__Cast__ExpressionAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCastAccess().getExpressionAssignment_3()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2608:1: ( rule__Cast__ExpressionAssignment_3 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2608:2: rule__Cast__ExpressionAssignment_3
            {
            pushFollow(FOLLOW_rule__Cast__ExpressionAssignment_3_in_rule__Cast__Group__3__Impl5245);
            rule__Cast__ExpressionAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCastAccess().getExpressionAssignment_3()); 
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
    // $ANTLR end "rule__Cast__Group__3__Impl"


    // $ANTLR start "rule__Paren__Group__0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2626:1: rule__Paren__Group__0 : rule__Paren__Group__0__Impl rule__Paren__Group__1 ;
    public final void rule__Paren__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2630:1: ( rule__Paren__Group__0__Impl rule__Paren__Group__1 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2631:2: rule__Paren__Group__0__Impl rule__Paren__Group__1
            {
            pushFollow(FOLLOW_rule__Paren__Group__0__Impl_in_rule__Paren__Group__05283);
            rule__Paren__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Paren__Group__1_in_rule__Paren__Group__05286);
            rule__Paren__Group__1();

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
    // $ANTLR end "rule__Paren__Group__0"


    // $ANTLR start "rule__Paren__Group__0__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2638:1: rule__Paren__Group__0__Impl : ( '(' ) ;
    public final void rule__Paren__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2642:1: ( ( '(' ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2643:1: ( '(' )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2643:1: ( '(' )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2644:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParenAccess().getLeftParenthesisKeyword_0()); 
            }
            match(input,21,FOLLOW_21_in_rule__Paren__Group__0__Impl5314); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParenAccess().getLeftParenthesisKeyword_0()); 
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
    // $ANTLR end "rule__Paren__Group__0__Impl"


    // $ANTLR start "rule__Paren__Group__1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2657:1: rule__Paren__Group__1 : rule__Paren__Group__1__Impl rule__Paren__Group__2 ;
    public final void rule__Paren__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2661:1: ( rule__Paren__Group__1__Impl rule__Paren__Group__2 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2662:2: rule__Paren__Group__1__Impl rule__Paren__Group__2
            {
            pushFollow(FOLLOW_rule__Paren__Group__1__Impl_in_rule__Paren__Group__15345);
            rule__Paren__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Paren__Group__2_in_rule__Paren__Group__15348);
            rule__Paren__Group__2();

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
    // $ANTLR end "rule__Paren__Group__1"


    // $ANTLR start "rule__Paren__Group__1__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2669:1: rule__Paren__Group__1__Impl : ( ruleExpression ) ;
    public final void rule__Paren__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2673:1: ( ( ruleExpression ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2674:1: ( ruleExpression )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2674:1: ( ruleExpression )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2675:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParenAccess().getExpressionParserRuleCall_1()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_rule__Paren__Group__1__Impl5375);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParenAccess().getExpressionParserRuleCall_1()); 
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
    // $ANTLR end "rule__Paren__Group__1__Impl"


    // $ANTLR start "rule__Paren__Group__2"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2686:1: rule__Paren__Group__2 : rule__Paren__Group__2__Impl ;
    public final void rule__Paren__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2690:1: ( rule__Paren__Group__2__Impl )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2691:2: rule__Paren__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Paren__Group__2__Impl_in_rule__Paren__Group__25404);
            rule__Paren__Group__2__Impl();

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
    // $ANTLR end "rule__Paren__Group__2"


    // $ANTLR start "rule__Paren__Group__2__Impl"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2697:1: rule__Paren__Group__2__Impl : ( ')' ) ;
    public final void rule__Paren__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2701:1: ( ( ')' ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2702:1: ( ')' )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2702:1: ( ')' )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2703:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParenAccess().getRightParenthesisKeyword_2()); 
            }
            match(input,22,FOLLOW_22_in_rule__Paren__Group__2__Impl5432); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParenAccess().getRightParenthesisKeyword_2()); 
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
    // $ANTLR end "rule__Paren__Group__2__Impl"


    // $ANTLR start "rule__Program__ClassesAssignment_0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2723:1: rule__Program__ClassesAssignment_0 : ( ruleClass ) ;
    public final void rule__Program__ClassesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2727:1: ( ( ruleClass ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2728:1: ( ruleClass )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2728:1: ( ruleClass )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2729:1: ruleClass
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getClassesClassParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleClass_in_rule__Program__ClassesAssignment_05474);
            ruleClass();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getClassesClassParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__Program__ClassesAssignment_0"


    // $ANTLR start "rule__Program__MainAssignment_1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2738:1: rule__Program__MainAssignment_1 : ( ruleExpression ) ;
    public final void rule__Program__MainAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2742:1: ( ( ruleExpression ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2743:1: ( ruleExpression )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2743:1: ( ruleExpression )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2744:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getMainExpressionParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_rule__Program__MainAssignment_15505);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getMainExpressionParserRuleCall_1_0()); 
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
    // $ANTLR end "rule__Program__MainAssignment_1"


    // $ANTLR start "rule__BasicType__BasicAssignment"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2753:1: rule__BasicType__BasicAssignment : ( ( rule__BasicType__BasicAlternatives_0 ) ) ;
    public final void rule__BasicType__BasicAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2757:1: ( ( ( rule__BasicType__BasicAlternatives_0 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2758:1: ( ( rule__BasicType__BasicAlternatives_0 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2758:1: ( ( rule__BasicType__BasicAlternatives_0 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2759:1: ( rule__BasicType__BasicAlternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBasicTypeAccess().getBasicAlternatives_0()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2760:1: ( rule__BasicType__BasicAlternatives_0 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2760:2: rule__BasicType__BasicAlternatives_0
            {
            pushFollow(FOLLOW_rule__BasicType__BasicAlternatives_0_in_rule__BasicType__BasicAssignment5536);
            rule__BasicType__BasicAlternatives_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBasicTypeAccess().getBasicAlternatives_0()); 
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
    // $ANTLR end "rule__BasicType__BasicAssignment"


    // $ANTLR start "rule__ClassType__ClassrefAssignment"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2769:1: rule__ClassType__ClassrefAssignment : ( ( RULE_ID ) ) ;
    public final void rule__ClassType__ClassrefAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2773:1: ( ( ( RULE_ID ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2774:1: ( ( RULE_ID ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2774:1: ( ( RULE_ID ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2775:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassTypeAccess().getClassrefClassCrossReference_0()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2776:1: ( RULE_ID )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2777:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassTypeAccess().getClassrefClassIDTerminalRuleCall_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ClassType__ClassrefAssignment5573); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassTypeAccess().getClassrefClassIDTerminalRuleCall_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassTypeAccess().getClassrefClassCrossReference_0()); 
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
    // $ANTLR end "rule__ClassType__ClassrefAssignment"


    // $ANTLR start "rule__Class__NameAssignment_1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2788:1: rule__Class__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Class__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2792:1: ( ( RULE_ID ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2793:1: ( RULE_ID )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2793:1: ( RULE_ID )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2794:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Class__NameAssignment_15608); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassAccess().getNameIDTerminalRuleCall_1_0()); 
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
    // $ANTLR end "rule__Class__NameAssignment_1"


    // $ANTLR start "rule__Class__SuperclassAssignment_2_1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2803:1: rule__Class__SuperclassAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Class__SuperclassAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2807:1: ( ( ( RULE_ID ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2808:1: ( ( RULE_ID ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2808:1: ( ( RULE_ID ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2809:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassAccess().getSuperclassClassCrossReference_2_1_0()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2810:1: ( RULE_ID )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2811:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassAccess().getSuperclassClassIDTerminalRuleCall_2_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Class__SuperclassAssignment_2_15643); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassAccess().getSuperclassClassIDTerminalRuleCall_2_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassAccess().getSuperclassClassCrossReference_2_1_0()); 
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
    // $ANTLR end "rule__Class__SuperclassAssignment_2_1"


    // $ANTLR start "rule__Class__MembersAssignment_4"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2822:1: rule__Class__MembersAssignment_4 : ( ruleMember ) ;
    public final void rule__Class__MembersAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2826:1: ( ( ruleMember ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2827:1: ( ruleMember )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2827:1: ( ruleMember )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2828:1: ruleMember
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassAccess().getMembersMemberParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_ruleMember_in_rule__Class__MembersAssignment_45678);
            ruleMember();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassAccess().getMembersMemberParserRuleCall_4_0()); 
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
    // $ANTLR end "rule__Class__MembersAssignment_4"


    // $ANTLR start "rule__Field__TypeAssignment_0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2837:1: rule__Field__TypeAssignment_0 : ( ruleType ) ;
    public final void rule__Field__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2841:1: ( ( ruleType ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2842:1: ( ruleType )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2842:1: ( ruleType )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2843:1: ruleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getTypeTypeParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleType_in_rule__Field__TypeAssignment_05709);
            ruleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getTypeTypeParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__Field__TypeAssignment_0"


    // $ANTLR start "rule__Field__NameAssignment_1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2852:1: rule__Field__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Field__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2856:1: ( ( RULE_ID ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2857:1: ( RULE_ID )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2857:1: ( RULE_ID )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2858:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Field__NameAssignment_15740); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getNameIDTerminalRuleCall_1_0()); 
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
    // $ANTLR end "rule__Field__NameAssignment_1"


    // $ANTLR start "rule__Method__TypeAssignment_0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2867:1: rule__Method__TypeAssignment_0 : ( ruleType ) ;
    public final void rule__Method__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2871:1: ( ( ruleType ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2872:1: ( ruleType )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2872:1: ( ruleType )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2873:1: ruleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getTypeTypeParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleType_in_rule__Method__TypeAssignment_05771);
            ruleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getTypeTypeParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__Method__TypeAssignment_0"


    // $ANTLR start "rule__Method__NameAssignment_1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2882:1: rule__Method__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Method__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2886:1: ( ( RULE_ID ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2887:1: ( RULE_ID )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2887:1: ( RULE_ID )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2888:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Method__NameAssignment_15802); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getNameIDTerminalRuleCall_1_0()); 
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
    // $ANTLR end "rule__Method__NameAssignment_1"


    // $ANTLR start "rule__Method__ParamsAssignment_3_0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2897:1: rule__Method__ParamsAssignment_3_0 : ( ruleParameter ) ;
    public final void rule__Method__ParamsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2901:1: ( ( ruleParameter ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2902:1: ( ruleParameter )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2902:1: ( ruleParameter )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2903:1: ruleParameter
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getParamsParameterParserRuleCall_3_0_0()); 
            }
            pushFollow(FOLLOW_ruleParameter_in_rule__Method__ParamsAssignment_3_05833);
            ruleParameter();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getParamsParameterParserRuleCall_3_0_0()); 
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
    // $ANTLR end "rule__Method__ParamsAssignment_3_0"


    // $ANTLR start "rule__Method__ParamsAssignment_3_1_1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2912:1: rule__Method__ParamsAssignment_3_1_1 : ( ruleParameter ) ;
    public final void rule__Method__ParamsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2916:1: ( ( ruleParameter ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2917:1: ( ruleParameter )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2917:1: ( ruleParameter )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2918:1: ruleParameter
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getParamsParameterParserRuleCall_3_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleParameter_in_rule__Method__ParamsAssignment_3_1_15864);
            ruleParameter();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getParamsParameterParserRuleCall_3_1_1_0()); 
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
    // $ANTLR end "rule__Method__ParamsAssignment_3_1_1"


    // $ANTLR start "rule__Method__BodyAssignment_6"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2927:1: rule__Method__BodyAssignment_6 : ( ruleMethodBody ) ;
    public final void rule__Method__BodyAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2931:1: ( ( ruleMethodBody ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2932:1: ( ruleMethodBody )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2932:1: ( ruleMethodBody )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2933:1: ruleMethodBody
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodAccess().getBodyMethodBodyParserRuleCall_6_0()); 
            }
            pushFollow(FOLLOW_ruleMethodBody_in_rule__Method__BodyAssignment_65895);
            ruleMethodBody();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodAccess().getBodyMethodBodyParserRuleCall_6_0()); 
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
    // $ANTLR end "rule__Method__BodyAssignment_6"


    // $ANTLR start "rule__Parameter__TypeAssignment_0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2942:1: rule__Parameter__TypeAssignment_0 : ( ruleType ) ;
    public final void rule__Parameter__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2946:1: ( ( ruleType ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2947:1: ( ruleType )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2947:1: ( ruleType )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2948:1: ruleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleType_in_rule__Parameter__TypeAssignment_05926);
            ruleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__Parameter__TypeAssignment_0"


    // $ANTLR start "rule__Parameter__NameAssignment_1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2957:1: rule__Parameter__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Parameter__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2961:1: ( ( RULE_ID ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2962:1: ( RULE_ID )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2962:1: ( RULE_ID )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2963:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Parameter__NameAssignment_15957); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_1_0()); 
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
    // $ANTLR end "rule__Parameter__NameAssignment_1"


    // $ANTLR start "rule__MethodBody__ExpressionAssignment_1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2972:1: rule__MethodBody__ExpressionAssignment_1 : ( ruleExpression ) ;
    public final void rule__MethodBody__ExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2976:1: ( ( ruleExpression ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2977:1: ( ruleExpression )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2977:1: ( ruleExpression )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2978:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMethodBodyAccess().getExpressionExpressionParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_rule__MethodBody__ExpressionAssignment_15988);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMethodBodyAccess().getExpressionExpressionParserRuleCall_1_0()); 
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
    // $ANTLR end "rule__MethodBody__ExpressionAssignment_1"


    // $ANTLR start "rule__Expression__MessageAssignment_1_0_2"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2987:1: rule__Expression__MessageAssignment_1_0_2 : ( ( RULE_ID ) ) ;
    public final void rule__Expression__MessageAssignment_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2991:1: ( ( ( RULE_ID ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2992:1: ( ( RULE_ID ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2992:1: ( ( RULE_ID ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2993:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getMessageMemberCrossReference_1_0_2_0()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2994:1: ( RULE_ID )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:2995:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getMessageMemberIDTerminalRuleCall_1_0_2_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Expression__MessageAssignment_1_0_26023); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getMessageMemberIDTerminalRuleCall_1_0_2_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getMessageMemberCrossReference_1_0_2_0()); 
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
    // $ANTLR end "rule__Expression__MessageAssignment_1_0_2"


    // $ANTLR start "rule__Expression__ArgsAssignment_1_0_3_1_0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3006:1: rule__Expression__ArgsAssignment_1_0_3_1_0 : ( ruleExpression ) ;
    public final void rule__Expression__ArgsAssignment_1_0_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3010:1: ( ( ruleExpression ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3011:1: ( ruleExpression )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3011:1: ( ruleExpression )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3012:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getArgsExpressionParserRuleCall_1_0_3_1_0_0()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_rule__Expression__ArgsAssignment_1_0_3_1_06058);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getArgsExpressionParserRuleCall_1_0_3_1_0_0()); 
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
    // $ANTLR end "rule__Expression__ArgsAssignment_1_0_3_1_0"


    // $ANTLR start "rule__Expression__ArgsAssignment_1_0_3_1_1_1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3021:1: rule__Expression__ArgsAssignment_1_0_3_1_1_1 : ( ruleExpression ) ;
    public final void rule__Expression__ArgsAssignment_1_0_3_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3025:1: ( ( ruleExpression ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3026:1: ( ruleExpression )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3026:1: ( ruleExpression )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3027:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpressionAccess().getArgsExpressionParserRuleCall_1_0_3_1_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_rule__Expression__ArgsAssignment_1_0_3_1_1_16089);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpressionAccess().getArgsExpressionParserRuleCall_1_0_3_1_1_1_0()); 
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
    // $ANTLR end "rule__Expression__ArgsAssignment_1_0_3_1_1_1"


    // $ANTLR start "rule__This__VariableAssignment"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3036:1: rule__This__VariableAssignment : ( ( 'this' ) ) ;
    public final void rule__This__VariableAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3040:1: ( ( ( 'this' ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3041:1: ( ( 'this' ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3041:1: ( ( 'this' ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3042:1: ( 'this' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getThisAccess().getVariableThisKeyword_0()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3043:1: ( 'this' )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3044:1: 'this'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getThisAccess().getVariableThisKeyword_0()); 
            }
            match(input,27,FOLLOW_27_in_rule__This__VariableAssignment6125); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getThisAccess().getVariableThisKeyword_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getThisAccess().getVariableThisKeyword_0()); 
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
    // $ANTLR end "rule__This__VariableAssignment"


    // $ANTLR start "rule__ParamRef__ParameterAssignment"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3059:1: rule__ParamRef__ParameterAssignment : ( ( RULE_ID ) ) ;
    public final void rule__ParamRef__ParameterAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3063:1: ( ( ( RULE_ID ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3064:1: ( ( RULE_ID ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3064:1: ( ( RULE_ID ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3065:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamRefAccess().getParameterParameterCrossReference_0()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3066:1: ( RULE_ID )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3067:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamRefAccess().getParameterParameterIDTerminalRuleCall_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ParamRef__ParameterAssignment6168); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParamRefAccess().getParameterParameterIDTerminalRuleCall_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParamRefAccess().getParameterParameterCrossReference_0()); 
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
    // $ANTLR end "rule__ParamRef__ParameterAssignment"


    // $ANTLR start "rule__New__TypeAssignment_1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3078:1: rule__New__TypeAssignment_1 : ( ruleClassType ) ;
    public final void rule__New__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3082:1: ( ( ruleClassType ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3083:1: ( ruleClassType )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3083:1: ( ruleClassType )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3084:1: ruleClassType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNewAccess().getTypeClassTypeParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleClassType_in_rule__New__TypeAssignment_16203);
            ruleClassType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNewAccess().getTypeClassTypeParserRuleCall_1_0()); 
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
    // $ANTLR end "rule__New__TypeAssignment_1"


    // $ANTLR start "rule__New__ArgsAssignment_3_0"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3093:1: rule__New__ArgsAssignment_3_0 : ( ruleExpression ) ;
    public final void rule__New__ArgsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3097:1: ( ( ruleExpression ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3098:1: ( ruleExpression )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3098:1: ( ruleExpression )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3099:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNewAccess().getArgsExpressionParserRuleCall_3_0_0()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_rule__New__ArgsAssignment_3_06234);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNewAccess().getArgsExpressionParserRuleCall_3_0_0()); 
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
    // $ANTLR end "rule__New__ArgsAssignment_3_0"


    // $ANTLR start "rule__New__ArgsAssignment_3_1_1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3108:1: rule__New__ArgsAssignment_3_1_1 : ( ruleExpression ) ;
    public final void rule__New__ArgsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3112:1: ( ( ruleExpression ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3113:1: ( ruleExpression )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3113:1: ( ruleExpression )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3114:1: ruleExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNewAccess().getArgsExpressionParserRuleCall_3_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_rule__New__ArgsAssignment_3_1_16265);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNewAccess().getArgsExpressionParserRuleCall_3_1_1_0()); 
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
    // $ANTLR end "rule__New__ArgsAssignment_3_1_1"


    // $ANTLR start "rule__Cast__TypeAssignment_1"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3123:1: rule__Cast__TypeAssignment_1 : ( ruleClassType ) ;
    public final void rule__Cast__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3127:1: ( ( ruleClassType ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3128:1: ( ruleClassType )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3128:1: ( ruleClassType )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3129:1: ruleClassType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCastAccess().getTypeClassTypeParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleClassType_in_rule__Cast__TypeAssignment_16296);
            ruleClassType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCastAccess().getTypeClassTypeParserRuleCall_1_0()); 
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
    // $ANTLR end "rule__Cast__TypeAssignment_1"


    // $ANTLR start "rule__Cast__ExpressionAssignment_3"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3138:1: rule__Cast__ExpressionAssignment_3 : ( ruleTerminalExpression ) ;
    public final void rule__Cast__ExpressionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3142:1: ( ( ruleTerminalExpression ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3143:1: ( ruleTerminalExpression )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3143:1: ( ruleTerminalExpression )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3144:1: ruleTerminalExpression
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCastAccess().getExpressionTerminalExpressionParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleTerminalExpression_in_rule__Cast__ExpressionAssignment_36327);
            ruleTerminalExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCastAccess().getExpressionTerminalExpressionParserRuleCall_3_0()); 
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
    // $ANTLR end "rule__Cast__ExpressionAssignment_3"


    // $ANTLR start "rule__StringConstant__ConstantAssignment"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3153:1: rule__StringConstant__ConstantAssignment : ( RULE_STRING ) ;
    public final void rule__StringConstant__ConstantAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3157:1: ( ( RULE_STRING ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3158:1: ( RULE_STRING )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3158:1: ( RULE_STRING )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3159:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringConstantAccess().getConstantSTRINGTerminalRuleCall_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringConstant__ConstantAssignment6358); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringConstantAccess().getConstantSTRINGTerminalRuleCall_0()); 
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
    // $ANTLR end "rule__StringConstant__ConstantAssignment"


    // $ANTLR start "rule__IntConstant__ConstantAssignment"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3168:1: rule__IntConstant__ConstantAssignment : ( RULE_INT ) ;
    public final void rule__IntConstant__ConstantAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3172:1: ( ( RULE_INT ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3173:1: ( RULE_INT )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3173:1: ( RULE_INT )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3174:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntConstantAccess().getConstantINTTerminalRuleCall_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__IntConstant__ConstantAssignment6389); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntConstantAccess().getConstantINTTerminalRuleCall_0()); 
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
    // $ANTLR end "rule__IntConstant__ConstantAssignment"


    // $ANTLR start "rule__BoolConstant__ConstantAssignment"
    // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3183:1: rule__BoolConstant__ConstantAssignment : ( ( rule__BoolConstant__ConstantAlternatives_0 ) ) ;
    public final void rule__BoolConstant__ConstantAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3187:1: ( ( ( rule__BoolConstant__ConstantAlternatives_0 ) ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3188:1: ( ( rule__BoolConstant__ConstantAlternatives_0 ) )
            {
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3188:1: ( ( rule__BoolConstant__ConstantAlternatives_0 ) )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3189:1: ( rule__BoolConstant__ConstantAlternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBoolConstantAccess().getConstantAlternatives_0()); 
            }
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3190:1: ( rule__BoolConstant__ConstantAlternatives_0 )
            // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:3190:2: rule__BoolConstant__ConstantAlternatives_0
            {
            pushFollow(FOLLOW_rule__BoolConstant__ConstantAlternatives_0_in_rule__BoolConstant__ConstantAssignment6420);
            rule__BoolConstant__ConstantAlternatives_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBoolConstantAccess().getConstantAlternatives_0()); 
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
    // $ANTLR end "rule__BoolConstant__ConstantAssignment"

    // $ANTLR start synpred8_InternalFJ
    public final void synpred8_InternalFJ_fragment() throws RecognitionException {   
        // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:753:6: ( ( ( ruleCast ) ) )
        // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:753:6: ( ( ruleCast ) )
        {
        // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:753:6: ( ( ruleCast ) )
        // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:754:1: ( ruleCast )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getTerminalExpressionAccess().getCastParserRuleCall_3()); 
        }
        // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:755:1: ( ruleCast )
        // ../it.xsemantics.example.fj.ui/src-gen/it/xsemantics/example/fj/ui/contentassist/antlr/internal/InternalFJ.g:755:3: ruleCast
        {
        pushFollow(FOLLOW_ruleCast_in_synpred8_InternalFJ1564);
        ruleCast();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred8_InternalFJ

    // Delegated rules

    public final boolean synpred8_InternalFJ() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalFJ_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\13\uffff";
    static final String DFA4_eofS =
        "\13\uffff";
    static final String DFA4_minS =
        "\1\4\3\uffff\1\0\6\uffff";
    static final String DFA4_maxS =
        "\1\33\3\uffff\1\0\6\uffff";
    static final String DFA4_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\5\3\uffff\1\4\1\6";
    static final String DFA4_specialS =
        "\4\uffff\1\0\6\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\2\2\5\7\uffff\2\5\5\uffff\1\4\4\uffff\1\3\1\1",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "730:1: rule__TerminalExpression__Alternatives : ( ( ruleThis ) | ( ruleParamRef ) | ( ruleNew ) | ( ( ruleCast ) ) | ( ruleConstant ) | ( ruleParen ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA4_4 = input.LA(1);

                         
                        int index4_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalFJ()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index4_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 4, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleProgram_in_entryRuleProgram67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProgram74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Program__Group__0_in_ruleProgram100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType127 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Alternatives_in_ruleType160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicType_in_entryRuleBasicType187 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBasicType194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicType__BasicAssignment_in_ruleBasicType220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassType_in_entryRuleClassType247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassType254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClassType__ClassrefAssignment_in_ruleClassType280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClass_in_entryRuleClass307 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClass314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Class__Group__0_in_ruleClass340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMember_in_entryRuleMember367 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMember374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Member__Alternatives_in_ruleMember400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleField_in_entryRuleField427 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleField434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Field__Group__0_in_ruleField460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethod_in_entryRuleMethod487 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethod494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Method__Group__0_in_ruleMethod520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter547 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__0_in_ruleParameter580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodBody_in_entryRuleMethodBody609 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodBody616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodBody__Group__0_in_ruleMethodBody642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression669 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__Group__0_in_ruleExpression702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalExpression_in_entryRuleTerminalExpression729 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalExpression736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpression__Alternatives_in_ruleTerminalExpression762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThis_in_entryRuleThis789 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleThis796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__This__VariableAssignment_in_ruleThis822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamRef_in_entryRuleParamRef849 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParamRef856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParamRef__ParameterAssignment_in_ruleParamRef882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNew_in_entryRuleNew909 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNew916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__New__Group__0_in_ruleNew942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCast_in_entryRuleCast969 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCast976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Cast__Group__0_in_ruleCast1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParen_in_entryRuleParen1029 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParen1036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paren__Group__0_in_ruleParen1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_entryRuleConstant1089 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstant1096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Alternatives_in_ruleConstant1122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringConstant_in_entryRuleStringConstant1149 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringConstant1156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringConstant__ConstantAssignment_in_ruleStringConstant1182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntConstant_in_entryRuleIntConstant1209 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntConstant1216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntConstant__ConstantAssignment_in_ruleIntConstant1242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoolConstant_in_entryRuleBoolConstant1269 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoolConstant1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BoolConstant__ConstantAssignment_in_ruleBoolConstant1302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicType_in_rule__Type__Alternatives1338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassType_in_rule__Type__Alternatives1355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__BasicType__BasicAlternatives_01388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__BasicType__BasicAlternatives_01408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__BasicType__BasicAlternatives_01428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleField_in_rule__Member__Alternatives1462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethod_in_rule__Member__Alternatives1479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThis_in_rule__TerminalExpression__Alternatives1512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamRef_in_rule__TerminalExpression__Alternatives1529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNew_in_rule__TerminalExpression__Alternatives1546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCast_in_rule__TerminalExpression__Alternatives1564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_rule__TerminalExpression__Alternatives1582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParen_in_rule__TerminalExpression__Alternatives1599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntConstant_in_rule__Constant__Alternatives1631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoolConstant_in_rule__Constant__Alternatives1648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringConstant_in_rule__Constant__Alternatives1665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__BoolConstant__ConstantAlternatives_01698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__BoolConstant__ConstantAlternatives_01718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Program__Group__0__Impl_in_rule__Program__Group__01750 = new BitSet(new long[]{0x000000000C20C070L});
    public static final BitSet FOLLOW_rule__Program__Group__1_in_rule__Program__Group__01753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Program__ClassesAssignment_0_in_rule__Program__Group__0__Impl1780 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__Program__Group__1__Impl_in_rule__Program__Group__11811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Program__MainAssignment_1_in_rule__Program__Group__1__Impl1838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Class__Group__0__Impl_in_rule__Class__Group__01873 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Class__Group__1_in_rule__Class__Group__01876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Class__Group__0__Impl1904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Class__Group__1__Impl_in_rule__Class__Group__11935 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_rule__Class__Group__2_in_rule__Class__Group__11938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Class__NameAssignment_1_in_rule__Class__Group__1__Impl1965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Class__Group__2__Impl_in_rule__Class__Group__21995 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_rule__Class__Group__3_in_rule__Class__Group__21998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Class__Group_2__0_in_rule__Class__Group__2__Impl2025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Class__Group__3__Impl_in_rule__Class__Group__32056 = new BitSet(new long[]{0x0000000000043810L});
    public static final BitSet FOLLOW_rule__Class__Group__4_in_rule__Class__Group__32059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Class__Group__3__Impl2087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Class__Group__4__Impl_in_rule__Class__Group__42118 = new BitSet(new long[]{0x0000000000043810L});
    public static final BitSet FOLLOW_rule__Class__Group__5_in_rule__Class__Group__42121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Class__MembersAssignment_4_in_rule__Class__Group__4__Impl2148 = new BitSet(new long[]{0x0000000000003812L});
    public static final BitSet FOLLOW_rule__Class__Group__5__Impl_in_rule__Class__Group__52179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Class__Group__5__Impl2207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Class__Group_2__0__Impl_in_rule__Class__Group_2__02250 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Class__Group_2__1_in_rule__Class__Group_2__02253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Class__Group_2__0__Impl2281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Class__Group_2__1__Impl_in_rule__Class__Group_2__12312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Class__SuperclassAssignment_2_1_in_rule__Class__Group_2__1__Impl2339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Field__Group__0__Impl_in_rule__Field__Group__02373 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Field__Group__1_in_rule__Field__Group__02376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Field__TypeAssignment_0_in_rule__Field__Group__0__Impl2403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Field__Group__1__Impl_in_rule__Field__Group__12433 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Field__Group__2_in_rule__Field__Group__12436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Field__NameAssignment_1_in_rule__Field__Group__1__Impl2463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Field__Group__2__Impl_in_rule__Field__Group__22493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Field__Group__2__Impl2521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Method__Group__0__Impl_in_rule__Method__Group__02558 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Method__Group__1_in_rule__Method__Group__02561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Method__TypeAssignment_0_in_rule__Method__Group__0__Impl2588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Method__Group__1__Impl_in_rule__Method__Group__12618 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__Method__Group__2_in_rule__Method__Group__12621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Method__NameAssignment_1_in_rule__Method__Group__1__Impl2648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Method__Group__2__Impl_in_rule__Method__Group__22678 = new BitSet(new long[]{0x0000000000403810L});
    public static final BitSet FOLLOW_rule__Method__Group__3_in_rule__Method__Group__22681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Method__Group__2__Impl2709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Method__Group__3__Impl_in_rule__Method__Group__32740 = new BitSet(new long[]{0x0000000000403810L});
    public static final BitSet FOLLOW_rule__Method__Group__4_in_rule__Method__Group__32743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Method__Group_3__0_in_rule__Method__Group__3__Impl2770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Method__Group__4__Impl_in_rule__Method__Group__42801 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Method__Group__5_in_rule__Method__Group__42804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Method__Group__4__Impl2832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Method__Group__5__Impl_in_rule__Method__Group__52863 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__Method__Group__6_in_rule__Method__Group__52866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Method__Group__5__Impl2894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Method__Group__6__Impl_in_rule__Method__Group__62925 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Method__Group__7_in_rule__Method__Group__62928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Method__BodyAssignment_6_in_rule__Method__Group__6__Impl2955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Method__Group__7__Impl_in_rule__Method__Group__72985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Method__Group__7__Impl3013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Method__Group_3__0__Impl_in_rule__Method__Group_3__03060 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__Method__Group_3__1_in_rule__Method__Group_3__03063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Method__ParamsAssignment_3_0_in_rule__Method__Group_3__0__Impl3090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Method__Group_3__1__Impl_in_rule__Method__Group_3__13120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Method__Group_3_1__0_in_rule__Method__Group_3__1__Impl3147 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_rule__Method__Group_3_1__0__Impl_in_rule__Method__Group_3_1__03182 = new BitSet(new long[]{0x0000000000003810L});
    public static final BitSet FOLLOW_rule__Method__Group_3_1__1_in_rule__Method__Group_3_1__03185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Method__Group_3_1__0__Impl3213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Method__Group_3_1__1__Impl_in_rule__Method__Group_3_1__13244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Method__ParamsAssignment_3_1_1_in_rule__Method__Group_3_1__1__Impl3271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__03305 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__03308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__TypeAssignment_0_in_rule__Parameter__Group__0__Impl3335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__13365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__NameAssignment_1_in_rule__Parameter__Group__1__Impl3392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodBody__Group__0__Impl_in_rule__MethodBody__Group__03426 = new BitSet(new long[]{0x000000000C20C070L});
    public static final BitSet FOLLOW_rule__MethodBody__Group__1_in_rule__MethodBody__Group__03429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__MethodBody__Group__0__Impl3457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodBody__Group__1__Impl_in_rule__MethodBody__Group__13488 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__MethodBody__Group__2_in_rule__MethodBody__Group__13491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodBody__ExpressionAssignment_1_in_rule__MethodBody__Group__1__Impl3518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodBody__Group__2__Impl_in_rule__MethodBody__Group__23548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__MethodBody__Group__2__Impl3576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__Group__0__Impl_in_rule__Expression__Group__03613 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__Expression__Group__1_in_rule__Expression__Group__03616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalExpression_in_rule__Expression__Group__0__Impl3643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__Group__1__Impl_in_rule__Expression__Group__13672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__Group_1__0_in_rule__Expression__Group__1__Impl3699 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_rule__Expression__Group_1__0__Impl_in_rule__Expression__Group_1__03734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__Group_1_0__0_in_rule__Expression__Group_1__0__Impl3761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__Group_1_0__0__Impl_in_rule__Expression__Group_1_0__03793 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__Expression__Group_1_0__1_in_rule__Expression__Group_1_0__03796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__Group_1_0__1__Impl_in_rule__Expression__Group_1_0__13854 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Expression__Group_1_0__2_in_rule__Expression__Group_1_0__13857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Expression__Group_1_0__1__Impl3885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__Group_1_0__2__Impl_in_rule__Expression__Group_1_0__23916 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__Expression__Group_1_0__3_in_rule__Expression__Group_1_0__23919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__MessageAssignment_1_0_2_in_rule__Expression__Group_1_0__2__Impl3946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__Group_1_0__3__Impl_in_rule__Expression__Group_1_0__33976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__Group_1_0_3__0_in_rule__Expression__Group_1_0__3__Impl4003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__Group_1_0_3__0__Impl_in_rule__Expression__Group_1_0_3__04042 = new BitSet(new long[]{0x000000000C60C070L});
    public static final BitSet FOLLOW_rule__Expression__Group_1_0_3__1_in_rule__Expression__Group_1_0_3__04045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Expression__Group_1_0_3__0__Impl4073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__Group_1_0_3__1__Impl_in_rule__Expression__Group_1_0_3__14104 = new BitSet(new long[]{0x000000000C60C070L});
    public static final BitSet FOLLOW_rule__Expression__Group_1_0_3__2_in_rule__Expression__Group_1_0_3__14107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__Group_1_0_3_1__0_in_rule__Expression__Group_1_0_3__1__Impl4134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__Group_1_0_3__2__Impl_in_rule__Expression__Group_1_0_3__24165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Expression__Group_1_0_3__2__Impl4193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__Group_1_0_3_1__0__Impl_in_rule__Expression__Group_1_0_3_1__04230 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__Expression__Group_1_0_3_1__1_in_rule__Expression__Group_1_0_3_1__04233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__ArgsAssignment_1_0_3_1_0_in_rule__Expression__Group_1_0_3_1__0__Impl4260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__Group_1_0_3_1__1__Impl_in_rule__Expression__Group_1_0_3_1__14290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__Group_1_0_3_1_1__0_in_rule__Expression__Group_1_0_3_1__1__Impl4317 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_rule__Expression__Group_1_0_3_1_1__0__Impl_in_rule__Expression__Group_1_0_3_1_1__04352 = new BitSet(new long[]{0x000000000C20C070L});
    public static final BitSet FOLLOW_rule__Expression__Group_1_0_3_1_1__1_in_rule__Expression__Group_1_0_3_1_1__04355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Expression__Group_1_0_3_1_1__0__Impl4383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__Group_1_0_3_1_1__1__Impl_in_rule__Expression__Group_1_0_3_1_1__14414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__ArgsAssignment_1_0_3_1_1_1_in_rule__Expression__Group_1_0_3_1_1__1__Impl4441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__New__Group__0__Impl_in_rule__New__Group__04475 = new BitSet(new long[]{0x0000000000003810L});
    public static final BitSet FOLLOW_rule__New__Group__1_in_rule__New__Group__04478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__New__Group__0__Impl4506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__New__Group__1__Impl_in_rule__New__Group__14537 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__New__Group__2_in_rule__New__Group__14540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__New__TypeAssignment_1_in_rule__New__Group__1__Impl4567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__New__Group__2__Impl_in_rule__New__Group__24597 = new BitSet(new long[]{0x000000000C60C070L});
    public static final BitSet FOLLOW_rule__New__Group__3_in_rule__New__Group__24600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__New__Group__2__Impl4628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__New__Group__3__Impl_in_rule__New__Group__34659 = new BitSet(new long[]{0x000000000C60C070L});
    public static final BitSet FOLLOW_rule__New__Group__4_in_rule__New__Group__34662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__New__Group_3__0_in_rule__New__Group__3__Impl4689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__New__Group__4__Impl_in_rule__New__Group__44720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__New__Group__4__Impl4748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__New__Group_3__0__Impl_in_rule__New__Group_3__04789 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__New__Group_3__1_in_rule__New__Group_3__04792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__New__ArgsAssignment_3_0_in_rule__New__Group_3__0__Impl4819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__New__Group_3__1__Impl_in_rule__New__Group_3__14849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__New__Group_3_1__0_in_rule__New__Group_3__1__Impl4876 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_rule__New__Group_3_1__0__Impl_in_rule__New__Group_3_1__04911 = new BitSet(new long[]{0x000000000C20C070L});
    public static final BitSet FOLLOW_rule__New__Group_3_1__1_in_rule__New__Group_3_1__04914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__New__Group_3_1__0__Impl4942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__New__Group_3_1__1__Impl_in_rule__New__Group_3_1__14973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__New__ArgsAssignment_3_1_1_in_rule__New__Group_3_1__1__Impl5000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Cast__Group__0__Impl_in_rule__Cast__Group__05034 = new BitSet(new long[]{0x0000000000003810L});
    public static final BitSet FOLLOW_rule__Cast__Group__1_in_rule__Cast__Group__05037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Cast__Group__0__Impl5065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Cast__Group__1__Impl_in_rule__Cast__Group__15096 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__Cast__Group__2_in_rule__Cast__Group__15099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Cast__TypeAssignment_1_in_rule__Cast__Group__1__Impl5126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Cast__Group__2__Impl_in_rule__Cast__Group__25156 = new BitSet(new long[]{0x000000000C20C070L});
    public static final BitSet FOLLOW_rule__Cast__Group__3_in_rule__Cast__Group__25159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Cast__Group__2__Impl5187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Cast__Group__3__Impl_in_rule__Cast__Group__35218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Cast__ExpressionAssignment_3_in_rule__Cast__Group__3__Impl5245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paren__Group__0__Impl_in_rule__Paren__Group__05283 = new BitSet(new long[]{0x000000000C20C070L});
    public static final BitSet FOLLOW_rule__Paren__Group__1_in_rule__Paren__Group__05286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Paren__Group__0__Impl5314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paren__Group__1__Impl_in_rule__Paren__Group__15345 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__Paren__Group__2_in_rule__Paren__Group__15348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__Paren__Group__1__Impl5375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Paren__Group__2__Impl_in_rule__Paren__Group__25404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Paren__Group__2__Impl5432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClass_in_rule__Program__ClassesAssignment_05474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__Program__MainAssignment_15505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicType__BasicAlternatives_0_in_rule__BasicType__BasicAssignment5536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ClassType__ClassrefAssignment5573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Class__NameAssignment_15608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Class__SuperclassAssignment_2_15643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMember_in_rule__Class__MembersAssignment_45678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_rule__Field__TypeAssignment_05709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Field__NameAssignment_15740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_rule__Method__TypeAssignment_05771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Method__NameAssignment_15802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_rule__Method__ParamsAssignment_3_05833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_rule__Method__ParamsAssignment_3_1_15864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodBody_in_rule__Method__BodyAssignment_65895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_rule__Parameter__TypeAssignment_05926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Parameter__NameAssignment_15957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__MethodBody__ExpressionAssignment_15988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Expression__MessageAssignment_1_0_26023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__Expression__ArgsAssignment_1_0_3_1_06058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__Expression__ArgsAssignment_1_0_3_1_1_16089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__This__VariableAssignment6125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ParamRef__ParameterAssignment6168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassType_in_rule__New__TypeAssignment_16203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__New__ArgsAssignment_3_06234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__New__ArgsAssignment_3_1_16265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassType_in_rule__Cast__TypeAssignment_16296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalExpression_in_rule__Cast__ExpressionAssignment_36327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringConstant__ConstantAssignment6358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__IntConstant__ConstantAssignment6389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BoolConstant__ConstantAlternatives_0_in_rule__BoolConstant__ConstantAssignment6420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCast_in_synpred8_InternalFJ1564 = new BitSet(new long[]{0x0000000000000002L});

}