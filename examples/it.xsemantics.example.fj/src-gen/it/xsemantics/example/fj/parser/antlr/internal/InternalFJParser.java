package it.xsemantics.example.fj.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import it.xsemantics.example.fj.services.FJGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalFJParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'int'", "'boolean'", "'String'", "'class'", "'extends'", "'{'", "'}'", "';'", "'('", "','", "')'", "'return'", "'.'", "'this'", "'new'", "'true'", "'false'"
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
    public String getGrammarFileName() { return "../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g"; }



     	private FJGrammarAccess grammarAccess;
     	
        public InternalFJParser(TokenStream input, FJGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Program";	
       	}
       	
       	@Override
       	protected FJGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleProgram"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:67:1: entryRuleProgram returns [EObject current=null] : iv_ruleProgram= ruleProgram EOF ;
    public final EObject entryRuleProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgram = null;


        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:68:2: (iv_ruleProgram= ruleProgram EOF )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:69:2: iv_ruleProgram= ruleProgram EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProgramRule()); 
            }
            pushFollow(FOLLOW_ruleProgram_in_entryRuleProgram75);
            iv_ruleProgram=ruleProgram();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProgram; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleProgram85); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgram"


    // $ANTLR start "ruleProgram"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:76:1: ruleProgram returns [EObject current=null] : ( ( (lv_classes_0_0= ruleClass ) )* ( (lv_main_1_0= ruleExpression ) )? ) ;
    public final EObject ruleProgram() throws RecognitionException {
        EObject current = null;

        EObject lv_classes_0_0 = null;

        EObject lv_main_1_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:79:28: ( ( ( (lv_classes_0_0= ruleClass ) )* ( (lv_main_1_0= ruleExpression ) )? ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:80:1: ( ( (lv_classes_0_0= ruleClass ) )* ( (lv_main_1_0= ruleExpression ) )? )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:80:1: ( ( (lv_classes_0_0= ruleClass ) )* ( (lv_main_1_0= ruleExpression ) )? )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:80:2: ( (lv_classes_0_0= ruleClass ) )* ( (lv_main_1_0= ruleExpression ) )?
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:80:2: ( (lv_classes_0_0= ruleClass ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:81:1: (lv_classes_0_0= ruleClass )
            	    {
            	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:81:1: (lv_classes_0_0= ruleClass )
            	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:82:3: lv_classes_0_0= ruleClass
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProgramAccess().getClassesClassParserRuleCall_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleClass_in_ruleProgram131);
            	    lv_classes_0_0=ruleClass();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProgramRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"classes",
            	              		lv_classes_0_0, 
            	              		"Class");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:98:3: ( (lv_main_1_0= ruleExpression ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=RULE_ID && LA2_0<=RULE_INT)||LA2_0==19||(LA2_0>=24 && LA2_0<=27)) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:99:1: (lv_main_1_0= ruleExpression )
                    {
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:99:1: (lv_main_1_0= ruleExpression )
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:100:3: lv_main_1_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getProgramAccess().getMainExpressionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleProgram153);
                    lv_main_1_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getProgramRule());
                      	        }
                             		set(
                             			current, 
                             			"main",
                              		lv_main_1_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleType"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:124:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:125:2: (iv_ruleType= ruleType EOF )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:126:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_ruleType_in_entryRuleType190);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleType200); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:133:1: ruleType returns [EObject current=null] : (this_BasicType_0= ruleBasicType | this_ClassType_1= ruleClassType ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_BasicType_0 = null;

        EObject this_ClassType_1 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:136:28: ( (this_BasicType_0= ruleBasicType | this_ClassType_1= ruleClassType ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:137:1: (this_BasicType_0= ruleBasicType | this_ClassType_1= ruleClassType )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:137:1: (this_BasicType_0= ruleBasicType | this_ClassType_1= ruleClassType )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=11 && LA3_0<=13)) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:138:5: this_BasicType_0= ruleBasicType
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAccess().getBasicTypeParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBasicType_in_ruleType247);
                    this_BasicType_0=ruleBasicType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BasicType_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:148:5: this_ClassType_1= ruleClassType
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAccess().getClassTypeParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleClassType_in_ruleType274);
                    this_ClassType_1=ruleClassType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ClassType_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleBasicType"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:164:1: entryRuleBasicType returns [EObject current=null] : iv_ruleBasicType= ruleBasicType EOF ;
    public final EObject entryRuleBasicType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicType = null;


        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:165:2: (iv_ruleBasicType= ruleBasicType EOF )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:166:2: iv_ruleBasicType= ruleBasicType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBasicTypeRule()); 
            }
            pushFollow(FOLLOW_ruleBasicType_in_entryRuleBasicType309);
            iv_ruleBasicType=ruleBasicType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBasicType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBasicType319); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBasicType"


    // $ANTLR start "ruleBasicType"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:173:1: ruleBasicType returns [EObject current=null] : ( ( (lv_basic_0_1= 'int' | lv_basic_0_2= 'boolean' | lv_basic_0_3= 'String' ) ) ) ;
    public final EObject ruleBasicType() throws RecognitionException {
        EObject current = null;

        Token lv_basic_0_1=null;
        Token lv_basic_0_2=null;
        Token lv_basic_0_3=null;

         enterRule(); 
            
        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:176:28: ( ( ( (lv_basic_0_1= 'int' | lv_basic_0_2= 'boolean' | lv_basic_0_3= 'String' ) ) ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:177:1: ( ( (lv_basic_0_1= 'int' | lv_basic_0_2= 'boolean' | lv_basic_0_3= 'String' ) ) )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:177:1: ( ( (lv_basic_0_1= 'int' | lv_basic_0_2= 'boolean' | lv_basic_0_3= 'String' ) ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:178:1: ( (lv_basic_0_1= 'int' | lv_basic_0_2= 'boolean' | lv_basic_0_3= 'String' ) )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:178:1: ( (lv_basic_0_1= 'int' | lv_basic_0_2= 'boolean' | lv_basic_0_3= 'String' ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:179:1: (lv_basic_0_1= 'int' | lv_basic_0_2= 'boolean' | lv_basic_0_3= 'String' )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:179:1: (lv_basic_0_1= 'int' | lv_basic_0_2= 'boolean' | lv_basic_0_3= 'String' )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt4=1;
                }
                break;
            case 12:
                {
                alt4=2;
                }
                break;
            case 13:
                {
                alt4=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:180:3: lv_basic_0_1= 'int'
                    {
                    lv_basic_0_1=(Token)match(input,11,FOLLOW_11_in_ruleBasicType363); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_basic_0_1, grammarAccess.getBasicTypeAccess().getBasicIntKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBasicTypeRule());
                      	        }
                             		setWithLastConsumed(current, "basic", lv_basic_0_1, null);
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:192:8: lv_basic_0_2= 'boolean'
                    {
                    lv_basic_0_2=(Token)match(input,12,FOLLOW_12_in_ruleBasicType392); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_basic_0_2, grammarAccess.getBasicTypeAccess().getBasicBooleanKeyword_0_1());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBasicTypeRule());
                      	        }
                             		setWithLastConsumed(current, "basic", lv_basic_0_2, null);
                      	    
                    }

                    }
                    break;
                case 3 :
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:204:8: lv_basic_0_3= 'String'
                    {
                    lv_basic_0_3=(Token)match(input,13,FOLLOW_13_in_ruleBasicType421); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_basic_0_3, grammarAccess.getBasicTypeAccess().getBasicStringKeyword_0_2());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBasicTypeRule());
                      	        }
                             		setWithLastConsumed(current, "basic", lv_basic_0_3, null);
                      	    
                    }

                    }
                    break;

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBasicType"


    // $ANTLR start "entryRuleClassType"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:227:1: entryRuleClassType returns [EObject current=null] : iv_ruleClassType= ruleClassType EOF ;
    public final EObject entryRuleClassType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassType = null;


        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:228:2: (iv_ruleClassType= ruleClassType EOF )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:229:2: iv_ruleClassType= ruleClassType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClassTypeRule()); 
            }
            pushFollow(FOLLOW_ruleClassType_in_entryRuleClassType472);
            iv_ruleClassType=ruleClassType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClassType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassType482); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassType"


    // $ANTLR start "ruleClassType"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:236:1: ruleClassType returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleClassType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:239:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:240:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:240:1: ( (otherlv_0= RULE_ID ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:241:1: (otherlv_0= RULE_ID )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:241:1: (otherlv_0= RULE_ID )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:242:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getClassTypeRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleClassType526); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getClassTypeAccess().getClassrefClassCrossReference_0()); 
              	
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassType"


    // $ANTLR start "entryRuleClass"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:261:1: entryRuleClass returns [EObject current=null] : iv_ruleClass= ruleClass EOF ;
    public final EObject entryRuleClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClass = null;


        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:262:2: (iv_ruleClass= ruleClass EOF )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:263:2: iv_ruleClass= ruleClass EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClassRule()); 
            }
            pushFollow(FOLLOW_ruleClass_in_entryRuleClass561);
            iv_ruleClass=ruleClass();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClass; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleClass571); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClass"


    // $ANTLR start "ruleClass"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:270:1: ruleClass returns [EObject current=null] : (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_members_5_0= ruleMember ) )* otherlv_6= '}' ) ;
    public final EObject ruleClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_members_5_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:273:28: ( (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_members_5_0= ruleMember ) )* otherlv_6= '}' ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:274:1: (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_members_5_0= ruleMember ) )* otherlv_6= '}' )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:274:1: (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_members_5_0= ruleMember ) )* otherlv_6= '}' )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:274:3: otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_members_5_0= ruleMember ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleClass608); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getClassAccess().getClassKeyword_0());
                  
            }
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:278:1: ( (lv_name_1_0= RULE_ID ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:279:1: (lv_name_1_0= RULE_ID )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:279:1: (lv_name_1_0= RULE_ID )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:280:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleClass625); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getClassAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getClassRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:296:2: (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:296:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleClass643); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getClassAccess().getExtendsKeyword_2_0());
                          
                    }
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:300:1: ( (otherlv_3= RULE_ID ) )
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:301:1: (otherlv_3= RULE_ID )
                    {
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:301:1: (otherlv_3= RULE_ID )
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:302:3: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getClassRule());
                      	        }
                              
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleClass663); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_3, grammarAccess.getClassAccess().getSuperclassClassCrossReference_2_1_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleClass677); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:317:1: ( (lv_members_5_0= ruleMember ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID||(LA6_0>=11 && LA6_0<=13)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:318:1: (lv_members_5_0= ruleMember )
            	    {
            	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:318:1: (lv_members_5_0= ruleMember )
            	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:319:3: lv_members_5_0= ruleMember
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getClassAccess().getMembersMemberParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMember_in_ruleClass698);
            	    lv_members_5_0=ruleMember();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getClassRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"members",
            	              		lv_members_5_0, 
            	              		"Member");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleClass711); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getClassAccess().getRightCurlyBracketKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClass"


    // $ANTLR start "entryRuleMember"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:347:1: entryRuleMember returns [EObject current=null] : iv_ruleMember= ruleMember EOF ;
    public final EObject entryRuleMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMember = null;


        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:348:2: (iv_ruleMember= ruleMember EOF )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:349:2: iv_ruleMember= ruleMember EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMemberRule()); 
            }
            pushFollow(FOLLOW_ruleMember_in_entryRuleMember747);
            iv_ruleMember=ruleMember();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMember; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMember757); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMember"


    // $ANTLR start "ruleMember"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:356:1: ruleMember returns [EObject current=null] : (this_Field_0= ruleField | this_Method_1= ruleMethod ) ;
    public final EObject ruleMember() throws RecognitionException {
        EObject current = null;

        EObject this_Field_0 = null;

        EObject this_Method_1 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:359:28: ( (this_Field_0= ruleField | this_Method_1= ruleMethod ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:360:1: (this_Field_0= ruleField | this_Method_1= ruleMethod )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:360:1: (this_Field_0= ruleField | this_Method_1= ruleMethod )
            int alt7=2;
            switch ( input.LA(1) ) {
            case 11:
                {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_ID) ) {
                    int LA7_5 = input.LA(3);

                    if ( (LA7_5==19) ) {
                        alt7=2;
                    }
                    else if ( (LA7_5==18) ) {
                        alt7=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 5, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
                }
                break;
            case 12:
                {
                int LA7_2 = input.LA(2);

                if ( (LA7_2==RULE_ID) ) {
                    int LA7_5 = input.LA(3);

                    if ( (LA7_5==19) ) {
                        alt7=2;
                    }
                    else if ( (LA7_5==18) ) {
                        alt7=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 5, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 2, input);

                    throw nvae;
                }
                }
                break;
            case 13:
                {
                int LA7_3 = input.LA(2);

                if ( (LA7_3==RULE_ID) ) {
                    int LA7_5 = input.LA(3);

                    if ( (LA7_5==19) ) {
                        alt7=2;
                    }
                    else if ( (LA7_5==18) ) {
                        alt7=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 5, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                int LA7_4 = input.LA(2);

                if ( (LA7_4==RULE_ID) ) {
                    int LA7_5 = input.LA(3);

                    if ( (LA7_5==19) ) {
                        alt7=2;
                    }
                    else if ( (LA7_5==18) ) {
                        alt7=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 5, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 4, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:361:5: this_Field_0= ruleField
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMemberAccess().getFieldParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleField_in_ruleMember804);
                    this_Field_0=ruleField();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Field_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:371:5: this_Method_1= ruleMethod
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMemberAccess().getMethodParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleMethod_in_ruleMember831);
                    this_Method_1=ruleMethod();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Method_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMember"


    // $ANTLR start "entryRuleField"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:387:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:388:2: (iv_ruleField= ruleField EOF )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:389:2: iv_ruleField= ruleField EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFieldRule()); 
            }
            pushFollow(FOLLOW_ruleField_in_entryRuleField866);
            iv_ruleField=ruleField();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleField; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleField876); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleField"


    // $ANTLR start "ruleField"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:396:1: ruleField returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleField() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_type_0_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:399:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:400:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:400:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:400:2: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:400:2: ( (lv_type_0_0= ruleType ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:401:1: (lv_type_0_0= ruleType )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:401:1: (lv_type_0_0= ruleType )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:402:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFieldAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleField922);
            lv_type_0_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFieldRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_0_0, 
                      		"Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:418:2: ( (lv_name_1_0= RULE_ID ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:419:1: (lv_name_1_0= RULE_ID )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:419:1: (lv_name_1_0= RULE_ID )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:420:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleField939); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getFieldAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFieldRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleField956); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFieldAccess().getSemicolonKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleField"


    // $ANTLR start "entryRuleMethod"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:448:1: entryRuleMethod returns [EObject current=null] : iv_ruleMethod= ruleMethod EOF ;
    public final EObject entryRuleMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethod = null;


        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:449:2: (iv_ruleMethod= ruleMethod EOF )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:450:2: iv_ruleMethod= ruleMethod EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMethodRule()); 
            }
            pushFollow(FOLLOW_ruleMethod_in_entryRuleMethod992);
            iv_ruleMethod=ruleMethod();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMethod; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethod1002); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMethod"


    // $ANTLR start "ruleMethod"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:457:1: ruleMethod returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= '{' ( (lv_body_8_0= ruleMethodBody ) ) otherlv_9= '}' ) ;
    public final EObject ruleMethod() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_type_0_0 = null;

        EObject lv_params_3_0 = null;

        EObject lv_params_5_0 = null;

        EObject lv_body_8_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:460:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= '{' ( (lv_body_8_0= ruleMethodBody ) ) otherlv_9= '}' ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:461:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= '{' ( (lv_body_8_0= ruleMethodBody ) ) otherlv_9= '}' )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:461:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= '{' ( (lv_body_8_0= ruleMethodBody ) ) otherlv_9= '}' )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:461:2: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= '{' ( (lv_body_8_0= ruleMethodBody ) ) otherlv_9= '}'
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:461:2: ( (lv_type_0_0= ruleType ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:462:1: (lv_type_0_0= ruleType )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:462:1: (lv_type_0_0= ruleType )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:463:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMethodAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleMethod1048);
            lv_type_0_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMethodRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_0_0, 
                      		"Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:479:2: ( (lv_name_1_0= RULE_ID ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:480:1: (lv_name_1_0= RULE_ID )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:480:1: (lv_name_1_0= RULE_ID )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:481:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMethod1065); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getMethodAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getMethodRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleMethod1082); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getMethodAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:501:1: ( ( (lv_params_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParameter ) ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID||(LA9_0>=11 && LA9_0<=13)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:501:2: ( (lv_params_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParameter ) ) )*
                    {
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:501:2: ( (lv_params_3_0= ruleParameter ) )
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:502:1: (lv_params_3_0= ruleParameter )
                    {
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:502:1: (lv_params_3_0= ruleParameter )
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:503:3: lv_params_3_0= ruleParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMethodAccess().getParamsParameterParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleParameter_in_ruleMethod1104);
                    lv_params_3_0=ruleParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMethodRule());
                      	        }
                             		add(
                             			current, 
                             			"params",
                              		lv_params_3_0, 
                              		"Parameter");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:519:2: (otherlv_4= ',' ( (lv_params_5_0= ruleParameter ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==20) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:519:4: otherlv_4= ',' ( (lv_params_5_0= ruleParameter ) )
                    	    {
                    	    otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleMethod1117); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getMethodAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:523:1: ( (lv_params_5_0= ruleParameter ) )
                    	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:524:1: (lv_params_5_0= ruleParameter )
                    	    {
                    	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:524:1: (lv_params_5_0= ruleParameter )
                    	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:525:3: lv_params_5_0= ruleParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getMethodAccess().getParamsParameterParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleParameter_in_ruleMethod1138);
                    	    lv_params_5_0=ruleParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getMethodRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"params",
                    	              		lv_params_5_0, 
                    	              		"Parameter");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,21,FOLLOW_21_in_ruleMethod1154); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getMethodAccess().getRightParenthesisKeyword_4());
                  
            }
            otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleMethod1166); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getMethodAccess().getLeftCurlyBracketKeyword_5());
                  
            }
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:549:1: ( (lv_body_8_0= ruleMethodBody ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:550:1: (lv_body_8_0= ruleMethodBody )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:550:1: (lv_body_8_0= ruleMethodBody )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:551:3: lv_body_8_0= ruleMethodBody
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMethodAccess().getBodyMethodBodyParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMethodBody_in_ruleMethod1187);
            lv_body_8_0=ruleMethodBody();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMethodRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_8_0, 
                      		"MethodBody");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_9=(Token)match(input,17,FOLLOW_17_in_ruleMethod1199); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getMethodAccess().getRightCurlyBracketKeyword_7());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMethod"


    // $ANTLR start "entryRuleParameter"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:579:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:580:2: (iv_ruleParameter= ruleParameter EOF )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:581:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter1235);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter1245); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:588:1: ruleParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_type_0_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:591:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:592:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:592:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:592:2: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:592:2: ( (lv_type_0_0= ruleType ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:593:1: (lv_type_0_0= ruleType )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:593:1: (lv_type_0_0= ruleType )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:594:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleParameter1291);
            lv_type_0_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getParameterRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_0_0, 
                      		"Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:610:2: ( (lv_name_1_0= RULE_ID ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:611:1: (lv_name_1_0= RULE_ID )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:611:1: (lv_name_1_0= RULE_ID )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:612:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParameter1308); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getParameterRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleMethodBody"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:638:1: entryRuleMethodBody returns [EObject current=null] : iv_ruleMethodBody= ruleMethodBody EOF ;
    public final EObject entryRuleMethodBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodBody = null;


        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:639:2: (iv_ruleMethodBody= ruleMethodBody EOF )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:640:2: iv_ruleMethodBody= ruleMethodBody EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMethodBodyRule()); 
            }
            pushFollow(FOLLOW_ruleMethodBody_in_entryRuleMethodBody1351);
            iv_ruleMethodBody=ruleMethodBody();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMethodBody; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodBody1361); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMethodBody"


    // $ANTLR start "ruleMethodBody"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:647:1: ruleMethodBody returns [EObject current=null] : (otherlv_0= 'return' ( (lv_expression_1_0= ruleExpression ) ) otherlv_2= ';' ) ;
    public final EObject ruleMethodBody() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_expression_1_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:650:28: ( (otherlv_0= 'return' ( (lv_expression_1_0= ruleExpression ) ) otherlv_2= ';' ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:651:1: (otherlv_0= 'return' ( (lv_expression_1_0= ruleExpression ) ) otherlv_2= ';' )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:651:1: (otherlv_0= 'return' ( (lv_expression_1_0= ruleExpression ) ) otherlv_2= ';' )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:651:3: otherlv_0= 'return' ( (lv_expression_1_0= ruleExpression ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleMethodBody1398); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMethodBodyAccess().getReturnKeyword_0());
                  
            }
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:655:1: ( (lv_expression_1_0= ruleExpression ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:656:1: (lv_expression_1_0= ruleExpression )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:656:1: (lv_expression_1_0= ruleExpression )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:657:3: lv_expression_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMethodBodyAccess().getExpressionExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleMethodBody1419);
            lv_expression_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMethodBodyRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_1_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleMethodBody1431); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getMethodBodyAccess().getSemicolonKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMethodBody"


    // $ANTLR start "entryRuleExpression"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:685:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:686:2: (iv_ruleExpression= ruleExpression EOF )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:687:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression1467);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression1477); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:694:1: ruleExpression returns [EObject current=null] : (this_TerminalExpression_0= ruleTerminalExpression ( ( ( () '.' ( ( RULE_ID ) ) ( '(' ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )? ')' )? ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )? ) )* ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject this_TerminalExpression_0 = null;

        EObject lv_args_5_0 = null;

        EObject lv_args_7_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:697:28: ( (this_TerminalExpression_0= ruleTerminalExpression ( ( ( () '.' ( ( RULE_ID ) ) ( '(' ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )? ')' )? ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )? ) )* ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:698:1: (this_TerminalExpression_0= ruleTerminalExpression ( ( ( () '.' ( ( RULE_ID ) ) ( '(' ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )? ')' )? ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )? ) )* )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:698:1: (this_TerminalExpression_0= ruleTerminalExpression ( ( ( () '.' ( ( RULE_ID ) ) ( '(' ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )? ')' )? ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )? ) )* )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:699:5: this_TerminalExpression_0= ruleTerminalExpression ( ( ( () '.' ( ( RULE_ID ) ) ( '(' ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )? ')' )? ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )? ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExpressionAccess().getTerminalExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleTerminalExpression_in_ruleExpression1524);
            this_TerminalExpression_0=ruleTerminalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_TerminalExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:707:1: ( ( ( () '.' ( ( RULE_ID ) ) ( '(' ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )? ')' )? ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )? ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==23) && (synpred1_InternalFJ())) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:707:2: ( ( () '.' ( ( RULE_ID ) ) ( '(' ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )? ')' )? ) )=> ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )? )
            	    {
            	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:725:7: ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )? )
            	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:725:8: () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '(' ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )?
            	    {
            	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:725:8: ()
            	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:726:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getExpressionAccess().getSelectionReceiverAction_1_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleExpression1608); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getExpressionAccess().getFullStopKeyword_1_0_1());
            	          
            	    }
            	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:735:1: ( (otherlv_3= RULE_ID ) )
            	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:736:1: (otherlv_3= RULE_ID )
            	    {
            	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:736:1: (otherlv_3= RULE_ID )
            	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:737:3: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getExpressionRule());
            	      	        }
            	              
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExpression1628); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		newLeafNode(otherlv_3, grammarAccess.getExpressionAccess().getMessageMemberCrossReference_1_0_2_0()); 
            	      	
            	    }

            	    }


            	    }

            	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:748:2: (otherlv_4= '(' ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )?
            	    int alt12=2;
            	    int LA12_0 = input.LA(1);

            	    if ( (LA12_0==19) ) {
            	        alt12=1;
            	    }
            	    switch (alt12) {
            	        case 1 :
            	            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:748:4: otherlv_4= '(' ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')'
            	            {
            	            otherlv_4=(Token)match(input,19,FOLLOW_19_in_ruleExpression1641); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_4, grammarAccess.getExpressionAccess().getLeftParenthesisKeyword_1_0_3_0());
            	                  
            	            }
            	            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:752:1: ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )?
            	            int alt11=2;
            	            int LA11_0 = input.LA(1);

            	            if ( ((LA11_0>=RULE_ID && LA11_0<=RULE_INT)||LA11_0==19||(LA11_0>=24 && LA11_0<=27)) ) {
            	                alt11=1;
            	            }
            	            switch (alt11) {
            	                case 1 :
            	                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:752:2: ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )*
            	                    {
            	                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:752:2: ( (lv_args_5_0= ruleExpression ) )
            	                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:753:1: (lv_args_5_0= ruleExpression )
            	                    {
            	                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:753:1: (lv_args_5_0= ruleExpression )
            	                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:754:3: lv_args_5_0= ruleExpression
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getExpressionAccess().getArgsExpressionParserRuleCall_1_0_3_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleExpression_in_ruleExpression1663);
            	                    lv_args_5_0=ruleExpression();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      	        if (current==null) {
            	                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
            	                      	        }
            	                             		add(
            	                             			current, 
            	                             			"args",
            	                              		lv_args_5_0, 
            	                              		"Expression");
            	                      	        afterParserOrEnumRuleCall();
            	                      	    
            	                    }

            	                    }


            	                    }

            	                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:770:2: (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )*
            	                    loop10:
            	                    do {
            	                        int alt10=2;
            	                        int LA10_0 = input.LA(1);

            	                        if ( (LA10_0==20) ) {
            	                            alt10=1;
            	                        }


            	                        switch (alt10) {
            	                    	case 1 :
            	                    	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:770:4: otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) )
            	                    	    {
            	                    	    otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleExpression1676); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	          	newLeafNode(otherlv_6, grammarAccess.getExpressionAccess().getCommaKeyword_1_0_3_1_1_0());
            	                    	          
            	                    	    }
            	                    	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:774:1: ( (lv_args_7_0= ruleExpression ) )
            	                    	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:775:1: (lv_args_7_0= ruleExpression )
            	                    	    {
            	                    	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:775:1: (lv_args_7_0= ruleExpression )
            	                    	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:776:3: lv_args_7_0= ruleExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {
            	                    	       
            	                    	      	        newCompositeNode(grammarAccess.getExpressionAccess().getArgsExpressionParserRuleCall_1_0_3_1_1_1_0()); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_ruleExpression_in_ruleExpression1697);
            	                    	    lv_args_7_0=ruleExpression();

            	                    	    state._fsp--;
            	                    	    if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      	        if (current==null) {
            	                    	      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
            	                    	      	        }
            	                    	             		add(
            	                    	             			current, 
            	                    	             			"args",
            	                    	              		lv_args_7_0, 
            	                    	              		"Expression");
            	                    	      	        afterParserOrEnumRuleCall();
            	                    	      	    
            	                    	    }

            	                    	    }


            	                    	    }


            	                    	    }
            	                    	    break;

            	                    	default :
            	                    	    break loop10;
            	                        }
            	                    } while (true);


            	                    }
            	                    break;

            	            }

            	            otherlv_8=(Token)match(input,21,FOLLOW_21_in_ruleExpression1713); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_8, grammarAccess.getExpressionAccess().getRightParenthesisKeyword_1_0_3_2());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleTerminalExpression"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:804:1: entryRuleTerminalExpression returns [EObject current=null] : iv_ruleTerminalExpression= ruleTerminalExpression EOF ;
    public final EObject entryRuleTerminalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalExpression = null;


        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:805:2: (iv_ruleTerminalExpression= ruleTerminalExpression EOF )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:806:2: iv_ruleTerminalExpression= ruleTerminalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTerminalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleTerminalExpression_in_entryRuleTerminalExpression1754);
            iv_ruleTerminalExpression=ruleTerminalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTerminalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalExpression1764); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminalExpression"


    // $ANTLR start "ruleTerminalExpression"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:813:1: ruleTerminalExpression returns [EObject current=null] : (this_This_0= ruleThis | this_ParamRef_1= ruleParamRef | this_New_2= ruleNew | ( ( ruleCast )=>this_Cast_3= ruleCast ) | this_Constant_4= ruleConstant | this_Paren_5= ruleParen ) ;
    public final EObject ruleTerminalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_This_0 = null;

        EObject this_ParamRef_1 = null;

        EObject this_New_2 = null;

        EObject this_Cast_3 = null;

        EObject this_Constant_4 = null;

        EObject this_Paren_5 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:816:28: ( (this_This_0= ruleThis | this_ParamRef_1= ruleParamRef | this_New_2= ruleNew | ( ( ruleCast )=>this_Cast_3= ruleCast ) | this_Constant_4= ruleConstant | this_Paren_5= ruleParen ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:817:1: (this_This_0= ruleThis | this_ParamRef_1= ruleParamRef | this_New_2= ruleNew | ( ( ruleCast )=>this_Cast_3= ruleCast ) | this_Constant_4= ruleConstant | this_Paren_5= ruleParen )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:817:1: (this_This_0= ruleThis | this_ParamRef_1= ruleParamRef | this_New_2= ruleNew | ( ( ruleCast )=>this_Cast_3= ruleCast ) | this_Constant_4= ruleConstant | this_Paren_5= ruleParen )
            int alt14=6;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:818:5: this_This_0= ruleThis
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTerminalExpressionAccess().getThisParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleThis_in_ruleTerminalExpression1811);
                    this_This_0=ruleThis();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_This_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:828:5: this_ParamRef_1= ruleParamRef
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTerminalExpressionAccess().getParamRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleParamRef_in_ruleTerminalExpression1838);
                    this_ParamRef_1=ruleParamRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ParamRef_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:838:5: this_New_2= ruleNew
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTerminalExpressionAccess().getNewParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleNew_in_ruleTerminalExpression1865);
                    this_New_2=ruleNew();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_New_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:847:6: ( ( ruleCast )=>this_Cast_3= ruleCast )
                    {
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:847:6: ( ( ruleCast )=>this_Cast_3= ruleCast )
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:847:7: ( ruleCast )=>this_Cast_3= ruleCast
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTerminalExpressionAccess().getCastParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleCast_in_ruleTerminalExpression1898);
                    this_Cast_3=ruleCast();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Cast_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:858:5: this_Constant_4= ruleConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTerminalExpressionAccess().getConstantParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleConstant_in_ruleTerminalExpression1926);
                    this_Constant_4=ruleConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Constant_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:868:5: this_Paren_5= ruleParen
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTerminalExpressionAccess().getParenParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleParen_in_ruleTerminalExpression1953);
                    this_Paren_5=ruleParen();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Paren_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminalExpression"


    // $ANTLR start "entryRuleThis"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:884:1: entryRuleThis returns [EObject current=null] : iv_ruleThis= ruleThis EOF ;
    public final EObject entryRuleThis() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThis = null;


        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:885:2: (iv_ruleThis= ruleThis EOF )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:886:2: iv_ruleThis= ruleThis EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getThisRule()); 
            }
            pushFollow(FOLLOW_ruleThis_in_entryRuleThis1988);
            iv_ruleThis=ruleThis();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleThis; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleThis1998); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleThis"


    // $ANTLR start "ruleThis"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:893:1: ruleThis returns [EObject current=null] : ( (lv_variable_0_0= 'this' ) ) ;
    public final EObject ruleThis() throws RecognitionException {
        EObject current = null;

        Token lv_variable_0_0=null;

         enterRule(); 
            
        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:896:28: ( ( (lv_variable_0_0= 'this' ) ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:897:1: ( (lv_variable_0_0= 'this' ) )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:897:1: ( (lv_variable_0_0= 'this' ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:898:1: (lv_variable_0_0= 'this' )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:898:1: (lv_variable_0_0= 'this' )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:899:3: lv_variable_0_0= 'this'
            {
            lv_variable_0_0=(Token)match(input,24,FOLLOW_24_in_ruleThis2040); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_variable_0_0, grammarAccess.getThisAccess().getVariableThisKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getThisRule());
              	        }
                     		setWithLastConsumed(current, "variable", lv_variable_0_0, "this");
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleThis"


    // $ANTLR start "entryRuleParamRef"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:920:1: entryRuleParamRef returns [EObject current=null] : iv_ruleParamRef= ruleParamRef EOF ;
    public final EObject entryRuleParamRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParamRef = null;


        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:921:2: (iv_ruleParamRef= ruleParamRef EOF )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:922:2: iv_ruleParamRef= ruleParamRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParamRefRule()); 
            }
            pushFollow(FOLLOW_ruleParamRef_in_entryRuleParamRef2088);
            iv_ruleParamRef=ruleParamRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParamRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParamRef2098); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParamRef"


    // $ANTLR start "ruleParamRef"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:929:1: ruleParamRef returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleParamRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:932:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:933:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:933:1: ( (otherlv_0= RULE_ID ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:934:1: (otherlv_0= RULE_ID )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:934:1: (otherlv_0= RULE_ID )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:935:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getParamRefRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParamRef2142); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getParamRefAccess().getParameterParameterCrossReference_0()); 
              	
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParamRef"


    // $ANTLR start "entryRuleNew"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:954:1: entryRuleNew returns [EObject current=null] : iv_ruleNew= ruleNew EOF ;
    public final EObject entryRuleNew() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNew = null;


        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:955:2: (iv_ruleNew= ruleNew EOF )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:956:2: iv_ruleNew= ruleNew EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNewRule()); 
            }
            pushFollow(FOLLOW_ruleNew_in_entryRuleNew2177);
            iv_ruleNew=ruleNew();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNew; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNew2187); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNew"


    // $ANTLR start "ruleNew"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:963:1: ruleNew returns [EObject current=null] : (otherlv_0= 'new' ( (lv_type_1_0= ruleClassType ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) ;
    public final EObject ruleNew() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_type_1_0 = null;

        EObject lv_args_3_0 = null;

        EObject lv_args_5_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:966:28: ( (otherlv_0= 'new' ( (lv_type_1_0= ruleClassType ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:967:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleClassType ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:967:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleClassType ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:967:3: otherlv_0= 'new' ( (lv_type_1_0= ruleClassType ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleNew2224); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getNewAccess().getNewKeyword_0());
                  
            }
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:971:1: ( (lv_type_1_0= ruleClassType ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:972:1: (lv_type_1_0= ruleClassType )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:972:1: (lv_type_1_0= ruleClassType )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:973:3: lv_type_1_0= ruleClassType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNewAccess().getTypeClassTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleClassType_in_ruleNew2245);
            lv_type_1_0=ruleClassType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNewRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_1_0, 
                      		"ClassType");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleNew2257); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getNewAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:993:1: ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=RULE_ID && LA16_0<=RULE_INT)||LA16_0==19||(LA16_0>=24 && LA16_0<=27)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:993:2: ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    {
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:993:2: ( (lv_args_3_0= ruleExpression ) )
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:994:1: (lv_args_3_0= ruleExpression )
                    {
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:994:1: (lv_args_3_0= ruleExpression )
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:995:3: lv_args_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNewAccess().getArgsExpressionParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleNew2279);
                    lv_args_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNewRule());
                      	        }
                             		add(
                             			current, 
                             			"args",
                              		lv_args_3_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1011:2: (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==20) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1011:4: otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleNew2292); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getNewAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1015:1: ( (lv_args_5_0= ruleExpression ) )
                    	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1016:1: (lv_args_5_0= ruleExpression )
                    	    {
                    	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1016:1: (lv_args_5_0= ruleExpression )
                    	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1017:3: lv_args_5_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getNewAccess().getArgsExpressionParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleExpression_in_ruleNew2313);
                    	    lv_args_5_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getNewRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"args",
                    	              		lv_args_5_0, 
                    	              		"Expression");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,21,FOLLOW_21_in_ruleNew2329); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getNewAccess().getRightParenthesisKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNew"


    // $ANTLR start "entryRuleCast"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1045:1: entryRuleCast returns [EObject current=null] : iv_ruleCast= ruleCast EOF ;
    public final EObject entryRuleCast() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCast = null;


        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1046:2: (iv_ruleCast= ruleCast EOF )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1047:2: iv_ruleCast= ruleCast EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCastRule()); 
            }
            pushFollow(FOLLOW_ruleCast_in_entryRuleCast2365);
            iv_ruleCast=ruleCast();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCast; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCast2375); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCast"


    // $ANTLR start "ruleCast"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1054:1: ruleCast returns [EObject current=null] : (otherlv_0= '(' ( (lv_type_1_0= ruleClassType ) ) otherlv_2= ')' ( (lv_expression_3_0= ruleTerminalExpression ) ) ) ;
    public final EObject ruleCast() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_type_1_0 = null;

        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1057:28: ( (otherlv_0= '(' ( (lv_type_1_0= ruleClassType ) ) otherlv_2= ')' ( (lv_expression_3_0= ruleTerminalExpression ) ) ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1058:1: (otherlv_0= '(' ( (lv_type_1_0= ruleClassType ) ) otherlv_2= ')' ( (lv_expression_3_0= ruleTerminalExpression ) ) )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1058:1: (otherlv_0= '(' ( (lv_type_1_0= ruleClassType ) ) otherlv_2= ')' ( (lv_expression_3_0= ruleTerminalExpression ) ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1058:3: otherlv_0= '(' ( (lv_type_1_0= ruleClassType ) ) otherlv_2= ')' ( (lv_expression_3_0= ruleTerminalExpression ) )
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleCast2412); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getCastAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1062:1: ( (lv_type_1_0= ruleClassType ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1063:1: (lv_type_1_0= ruleClassType )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1063:1: (lv_type_1_0= ruleClassType )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1064:3: lv_type_1_0= ruleClassType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCastAccess().getTypeClassTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleClassType_in_ruleCast2433);
            lv_type_1_0=ruleClassType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCastRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_1_0, 
                      		"ClassType");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleCast2445); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getCastAccess().getRightParenthesisKeyword_2());
                  
            }
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1084:1: ( (lv_expression_3_0= ruleTerminalExpression ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1085:1: (lv_expression_3_0= ruleTerminalExpression )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1085:1: (lv_expression_3_0= ruleTerminalExpression )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1086:3: lv_expression_3_0= ruleTerminalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCastAccess().getExpressionTerminalExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTerminalExpression_in_ruleCast2466);
            lv_expression_3_0=ruleTerminalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCastRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_3_0, 
                      		"TerminalExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCast"


    // $ANTLR start "entryRuleParen"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1110:1: entryRuleParen returns [EObject current=null] : iv_ruleParen= ruleParen EOF ;
    public final EObject entryRuleParen() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParen = null;


        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1111:2: (iv_ruleParen= ruleParen EOF )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1112:2: iv_ruleParen= ruleParen EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParenRule()); 
            }
            pushFollow(FOLLOW_ruleParen_in_entryRuleParen2502);
            iv_ruleParen=ruleParen();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParen; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParen2512); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParen"


    // $ANTLR start "ruleParen"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1119:1: ruleParen returns [EObject current=null] : (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) ;
    public final EObject ruleParen() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Expression_1 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1122:28: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1123:1: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1123:1: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1123:3: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleParen2549); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getParenAccess().getLeftParenthesisKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getParenAccess().getExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleParen2571);
            this_Expression_1=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Expression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleParen2582); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getParenAccess().getRightParenthesisKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParen"


    // $ANTLR start "entryRuleConstant"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1148:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1149:2: (iv_ruleConstant= ruleConstant EOF )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1150:2: iv_ruleConstant= ruleConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantRule()); 
            }
            pushFollow(FOLLOW_ruleConstant_in_entryRuleConstant2618);
            iv_ruleConstant=ruleConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstant; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstant2628); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1157:1: ruleConstant returns [EObject current=null] : (this_IntConstant_0= ruleIntConstant | this_BoolConstant_1= ruleBoolConstant | this_StringConstant_2= ruleStringConstant ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        EObject this_IntConstant_0 = null;

        EObject this_BoolConstant_1 = null;

        EObject this_StringConstant_2 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1160:28: ( (this_IntConstant_0= ruleIntConstant | this_BoolConstant_1= ruleBoolConstant | this_StringConstant_2= ruleStringConstant ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1161:1: (this_IntConstant_0= ruleIntConstant | this_BoolConstant_1= ruleBoolConstant | this_StringConstant_2= ruleStringConstant )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1161:1: (this_IntConstant_0= ruleIntConstant | this_BoolConstant_1= ruleBoolConstant | this_StringConstant_2= ruleStringConstant )
            int alt17=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt17=1;
                }
                break;
            case 26:
            case 27:
                {
                alt17=2;
                }
                break;
            case RULE_STRING:
                {
                alt17=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1162:5: this_IntConstant_0= ruleIntConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstantAccess().getIntConstantParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleIntConstant_in_ruleConstant2675);
                    this_IntConstant_0=ruleIntConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_IntConstant_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1172:5: this_BoolConstant_1= ruleBoolConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstantAccess().getBoolConstantParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBoolConstant_in_ruleConstant2702);
                    this_BoolConstant_1=ruleBoolConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BoolConstant_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1182:5: this_StringConstant_2= ruleStringConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstantAccess().getStringConstantParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleStringConstant_in_ruleConstant2729);
                    this_StringConstant_2=ruleStringConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_StringConstant_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleStringConstant"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1198:1: entryRuleStringConstant returns [EObject current=null] : iv_ruleStringConstant= ruleStringConstant EOF ;
    public final EObject entryRuleStringConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringConstant = null;


        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1199:2: (iv_ruleStringConstant= ruleStringConstant EOF )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1200:2: iv_ruleStringConstant= ruleStringConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringConstantRule()); 
            }
            pushFollow(FOLLOW_ruleStringConstant_in_entryRuleStringConstant2764);
            iv_ruleStringConstant=ruleStringConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringConstant; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringConstant2774); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringConstant"


    // $ANTLR start "ruleStringConstant"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1207:1: ruleStringConstant returns [EObject current=null] : ( (lv_constant_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringConstant() throws RecognitionException {
        EObject current = null;

        Token lv_constant_0_0=null;

         enterRule(); 
            
        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1210:28: ( ( (lv_constant_0_0= RULE_STRING ) ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1211:1: ( (lv_constant_0_0= RULE_STRING ) )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1211:1: ( (lv_constant_0_0= RULE_STRING ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1212:1: (lv_constant_0_0= RULE_STRING )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1212:1: (lv_constant_0_0= RULE_STRING )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1213:3: lv_constant_0_0= RULE_STRING
            {
            lv_constant_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringConstant2815); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_constant_0_0, grammarAccess.getStringConstantAccess().getConstantSTRINGTerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getStringConstantRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"constant",
                      		lv_constant_0_0, 
                      		"STRING");
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringConstant"


    // $ANTLR start "entryRuleIntConstant"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1237:1: entryRuleIntConstant returns [EObject current=null] : iv_ruleIntConstant= ruleIntConstant EOF ;
    public final EObject entryRuleIntConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntConstant = null;


        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1238:2: (iv_ruleIntConstant= ruleIntConstant EOF )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1239:2: iv_ruleIntConstant= ruleIntConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntConstantRule()); 
            }
            pushFollow(FOLLOW_ruleIntConstant_in_entryRuleIntConstant2855);
            iv_ruleIntConstant=ruleIntConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntConstant; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntConstant2865); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntConstant"


    // $ANTLR start "ruleIntConstant"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1246:1: ruleIntConstant returns [EObject current=null] : ( (lv_constant_0_0= RULE_INT ) ) ;
    public final EObject ruleIntConstant() throws RecognitionException {
        EObject current = null;

        Token lv_constant_0_0=null;

         enterRule(); 
            
        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1249:28: ( ( (lv_constant_0_0= RULE_INT ) ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1250:1: ( (lv_constant_0_0= RULE_INT ) )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1250:1: ( (lv_constant_0_0= RULE_INT ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1251:1: (lv_constant_0_0= RULE_INT )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1251:1: (lv_constant_0_0= RULE_INT )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1252:3: lv_constant_0_0= RULE_INT
            {
            lv_constant_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIntConstant2906); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_constant_0_0, grammarAccess.getIntConstantAccess().getConstantINTTerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getIntConstantRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"constant",
                      		lv_constant_0_0, 
                      		"INT");
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntConstant"


    // $ANTLR start "entryRuleBoolConstant"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1276:1: entryRuleBoolConstant returns [EObject current=null] : iv_ruleBoolConstant= ruleBoolConstant EOF ;
    public final EObject entryRuleBoolConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolConstant = null;


        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1277:2: (iv_ruleBoolConstant= ruleBoolConstant EOF )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1278:2: iv_ruleBoolConstant= ruleBoolConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBoolConstantRule()); 
            }
            pushFollow(FOLLOW_ruleBoolConstant_in_entryRuleBoolConstant2946);
            iv_ruleBoolConstant=ruleBoolConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBoolConstant; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoolConstant2956); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoolConstant"


    // $ANTLR start "ruleBoolConstant"
    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1285:1: ruleBoolConstant returns [EObject current=null] : ( ( (lv_constant_0_1= 'true' | lv_constant_0_2= 'false' ) ) ) ;
    public final EObject ruleBoolConstant() throws RecognitionException {
        EObject current = null;

        Token lv_constant_0_1=null;
        Token lv_constant_0_2=null;

         enterRule(); 
            
        try {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1288:28: ( ( ( (lv_constant_0_1= 'true' | lv_constant_0_2= 'false' ) ) ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1289:1: ( ( (lv_constant_0_1= 'true' | lv_constant_0_2= 'false' ) ) )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1289:1: ( ( (lv_constant_0_1= 'true' | lv_constant_0_2= 'false' ) ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1290:1: ( (lv_constant_0_1= 'true' | lv_constant_0_2= 'false' ) )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1290:1: ( (lv_constant_0_1= 'true' | lv_constant_0_2= 'false' ) )
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1291:1: (lv_constant_0_1= 'true' | lv_constant_0_2= 'false' )
            {
            // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1291:1: (lv_constant_0_1= 'true' | lv_constant_0_2= 'false' )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==26) ) {
                alt18=1;
            }
            else if ( (LA18_0==27) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1292:3: lv_constant_0_1= 'true'
                    {
                    lv_constant_0_1=(Token)match(input,26,FOLLOW_26_in_ruleBoolConstant3000); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_constant_0_1, grammarAccess.getBoolConstantAccess().getConstantTrueKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBoolConstantRule());
                      	        }
                             		setWithLastConsumed(current, "constant", lv_constant_0_1, null);
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:1304:8: lv_constant_0_2= 'false'
                    {
                    lv_constant_0_2=(Token)match(input,27,FOLLOW_27_in_ruleBoolConstant3029); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_constant_0_2, grammarAccess.getBoolConstantAccess().getConstantFalseKeyword_0_1());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBoolConstantRule());
                      	        }
                             		setWithLastConsumed(current, "constant", lv_constant_0_2, null);
                      	    
                    }

                    }
                    break;

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolConstant"

    // $ANTLR start synpred1_InternalFJ
    public final void synpred1_InternalFJ_fragment() throws RecognitionException {   
        // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:707:2: ( ( () '.' ( ( RULE_ID ) ) ( '(' ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )? ')' )? ) )
        // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:707:3: ( () '.' ( ( RULE_ID ) ) ( '(' ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )? ')' )? )
        {
        // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:707:3: ( () '.' ( ( RULE_ID ) ) ( '(' ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )? ')' )? )
        // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:707:4: () '.' ( ( RULE_ID ) ) ( '(' ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )? ')' )?
        {
        // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:707:4: ()
        // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:708:1: 
        {
        }

        match(input,23,FOLLOW_23_in_synpred1_InternalFJ1539); if (state.failed) return ;
        // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:709:1: ( ( RULE_ID ) )
        // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:710:1: ( RULE_ID )
        {
        // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:710:1: ( RULE_ID )
        // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:711:2: RULE_ID
        {
        match(input,RULE_ID,FOLLOW_RULE_ID_in_synpred1_InternalFJ1547); if (state.failed) return ;

        }


        }

        // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:714:2: ( '(' ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )? ')' )?
        int alt21=2;
        int LA21_0 = input.LA(1);

        if ( (LA21_0==19) ) {
            alt21=1;
        }
        switch (alt21) {
            case 1 :
                // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:714:4: '(' ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )? ')'
                {
                match(input,19,FOLLOW_19_in_synpred1_InternalFJ1555); if (state.failed) return ;
                // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:715:1: ( ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )* )?
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=RULE_ID && LA20_0<=RULE_INT)||LA20_0==19||(LA20_0>=24 && LA20_0<=27)) ) {
                    alt20=1;
                }
                switch (alt20) {
                    case 1 :
                        // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:715:2: ( ( ruleExpression ) ) ( ',' ( ( ruleExpression ) ) )*
                        {
                        // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:715:2: ( ( ruleExpression ) )
                        // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:716:1: ( ruleExpression )
                        {
                        // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:716:1: ( ruleExpression )
                        // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:717:1: ruleExpression
                        {
                        pushFollow(FOLLOW_ruleExpression_in_synpred1_InternalFJ1563);
                        ruleExpression();

                        state._fsp--;
                        if (state.failed) return ;

                        }


                        }

                        // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:719:2: ( ',' ( ( ruleExpression ) ) )*
                        loop19:
                        do {
                            int alt19=2;
                            int LA19_0 = input.LA(1);

                            if ( (LA19_0==20) ) {
                                alt19=1;
                            }


                            switch (alt19) {
                        	case 1 :
                        	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:719:4: ',' ( ( ruleExpression ) )
                        	    {
                        	    match(input,20,FOLLOW_20_in_synpred1_InternalFJ1570); if (state.failed) return ;
                        	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:720:1: ( ( ruleExpression ) )
                        	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:721:1: ( ruleExpression )
                        	    {
                        	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:721:1: ( ruleExpression )
                        	    // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:722:1: ruleExpression
                        	    {
                        	    pushFollow(FOLLOW_ruleExpression_in_synpred1_InternalFJ1577);
                        	    ruleExpression();

                        	    state._fsp--;
                        	    if (state.failed) return ;

                        	    }


                        	    }


                        	    }
                        	    break;

                        	default :
                        	    break loop19;
                            }
                        } while (true);


                        }
                        break;

                }

                match(input,21,FOLLOW_21_in_synpred1_InternalFJ1587); if (state.failed) return ;

                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred1_InternalFJ

    // $ANTLR start synpred2_InternalFJ
    public final void synpred2_InternalFJ_fragment() throws RecognitionException {   
        // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:847:7: ( ruleCast )
        // ../it.xsemantics.example.fj/src-gen/it/xsemantics/example/fj/parser/antlr/internal/InternalFJ.g:847:9: ruleCast
        {
        pushFollow(FOLLOW_ruleCast_in_synpred2_InternalFJ1882);
        ruleCast();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_InternalFJ

    // Delegated rules

    public final boolean synpred2_InternalFJ() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalFJ_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalFJ() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalFJ_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\13\uffff";
    static final String DFA14_eofS =
        "\13\uffff";
    static final String DFA14_minS =
        "\1\4\3\uffff\1\0\6\uffff";
    static final String DFA14_maxS =
        "\1\33\3\uffff\1\0\6\uffff";
    static final String DFA14_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\5\3\uffff\1\4\1\6";
    static final String DFA14_specialS =
        "\4\uffff\1\0\6\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\2\2\5\14\uffff\1\4\4\uffff\1\1\1\3\2\5",
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

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "817:1: (this_This_0= ruleThis | this_ParamRef_1= ruleParamRef | this_New_2= ruleNew | ( ( ruleCast )=>this_Cast_3= ruleCast ) | this_Constant_4= ruleConstant | this_Paren_5= ruleParen )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_4 = input.LA(1);

                         
                        int index14_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalFJ()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index14_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleProgram_in_entryRuleProgram75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProgram85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClass_in_ruleProgram131 = new BitSet(new long[]{0x000000000F084072L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleProgram153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType190 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicType_in_ruleType247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassType_in_ruleType274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicType_in_entryRuleBasicType309 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBasicType319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleBasicType363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleBasicType392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleBasicType421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassType_in_entryRuleClassType472 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassType482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleClassType526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClass_in_entryRuleClass561 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClass571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleClass608 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleClass625 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_ruleClass643 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleClass663 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleClass677 = new BitSet(new long[]{0x0000000000023810L});
    public static final BitSet FOLLOW_ruleMember_in_ruleClass698 = new BitSet(new long[]{0x0000000000023810L});
    public static final BitSet FOLLOW_17_in_ruleClass711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMember_in_entryRuleMember747 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMember757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleField_in_ruleMember804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethod_in_ruleMember831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleField_in_entryRuleField866 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleField876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleField922 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleField939 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleField956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethod_in_entryRuleMethod992 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethod1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleMethod1048 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMethod1065 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleMethod1082 = new BitSet(new long[]{0x0000000000203810L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleMethod1104 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_ruleMethod1117 = new BitSet(new long[]{0x0000000000003810L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleMethod1138 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_21_in_ruleMethod1154 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleMethod1166 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleMethodBody_in_ruleMethod1187 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleMethod1199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter1235 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter1245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleParameter1291 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParameter1308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodBody_in_entryRuleMethodBody1351 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodBody1361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleMethodBody1398 = new BitSet(new long[]{0x000000000F080070L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleMethodBody1419 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleMethodBody1431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression1467 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression1477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalExpression_in_ruleExpression1524 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleExpression1608 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExpression1628 = new BitSet(new long[]{0x0000000000880002L});
    public static final BitSet FOLLOW_19_in_ruleExpression1641 = new BitSet(new long[]{0x000000000F280070L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpression1663 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_ruleExpression1676 = new BitSet(new long[]{0x000000000F080070L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpression1697 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_21_in_ruleExpression1713 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_ruleTerminalExpression_in_entryRuleTerminalExpression1754 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalExpression1764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThis_in_ruleTerminalExpression1811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamRef_in_ruleTerminalExpression1838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNew_in_ruleTerminalExpression1865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCast_in_ruleTerminalExpression1898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_ruleTerminalExpression1926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParen_in_ruleTerminalExpression1953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThis_in_entryRuleThis1988 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleThis1998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleThis2040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamRef_in_entryRuleParamRef2088 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParamRef2098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParamRef2142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNew_in_entryRuleNew2177 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNew2187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleNew2224 = new BitSet(new long[]{0x0000000000003810L});
    public static final BitSet FOLLOW_ruleClassType_in_ruleNew2245 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleNew2257 = new BitSet(new long[]{0x000000000F280070L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleNew2279 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_ruleNew2292 = new BitSet(new long[]{0x000000000F080070L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleNew2313 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_21_in_ruleNew2329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCast_in_entryRuleCast2365 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCast2375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleCast2412 = new BitSet(new long[]{0x0000000000003810L});
    public static final BitSet FOLLOW_ruleClassType_in_ruleCast2433 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleCast2445 = new BitSet(new long[]{0x000000000F080070L});
    public static final BitSet FOLLOW_ruleTerminalExpression_in_ruleCast2466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParen_in_entryRuleParen2502 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParen2512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleParen2549 = new BitSet(new long[]{0x000000000F080070L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleParen2571 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleParen2582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_entryRuleConstant2618 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstant2628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntConstant_in_ruleConstant2675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoolConstant_in_ruleConstant2702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringConstant_in_ruleConstant2729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringConstant_in_entryRuleStringConstant2764 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringConstant2774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringConstant2815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntConstant_in_entryRuleIntConstant2855 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntConstant2865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIntConstant2906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoolConstant_in_entryRuleBoolConstant2946 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoolConstant2956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleBoolConstant3000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleBoolConstant3029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_synpred1_InternalFJ1539 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_synpred1_InternalFJ1547 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_synpred1_InternalFJ1555 = new BitSet(new long[]{0x000000000F280070L});
    public static final BitSet FOLLOW_ruleExpression_in_synpred1_InternalFJ1563 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_synpred1_InternalFJ1570 = new BitSet(new long[]{0x000000000F080070L});
    public static final BitSet FOLLOW_ruleExpression_in_synpred1_InternalFJ1577 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_21_in_synpred1_InternalFJ1587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCast_in_synpred2_InternalFJ1882 = new BitSet(new long[]{0x0000000000000002L});

}