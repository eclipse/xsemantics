package it.xsemantics.example.lambda.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import it.xsemantics.example.lambda.services.LambdaGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalLambdaParser extends AbstractInternalAntlrParser {
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
    public String getGrammarFileName() { return "../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g"; }



     	private LambdaGrammarAccess grammarAccess;
     	
        public InternalLambdaParser(TokenStream input, LambdaGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Program";	
       	}
       	
       	@Override
       	protected LambdaGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleProgram"
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:67:1: entryRuleProgram returns [EObject current=null] : iv_ruleProgram= ruleProgram EOF ;
    public final EObject entryRuleProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgram = null;


        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:68:2: (iv_ruleProgram= ruleProgram EOF )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:69:2: iv_ruleProgram= ruleProgram EOF
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
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:76:1: ruleProgram returns [EObject current=null] : ( (lv_term_0_0= ruleTerm ) ) ;
    public final EObject ruleProgram() throws RecognitionException {
        EObject current = null;

        EObject lv_term_0_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:79:28: ( ( (lv_term_0_0= ruleTerm ) ) )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:80:1: ( (lv_term_0_0= ruleTerm ) )
            {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:80:1: ( (lv_term_0_0= ruleTerm ) )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:81:1: (lv_term_0_0= ruleTerm )
            {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:81:1: (lv_term_0_0= ruleTerm )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:82:3: lv_term_0_0= ruleTerm
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getProgramAccess().getTermTermParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTerm_in_ruleProgram130);
            lv_term_0_0=ruleTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getProgramRule());
              	        }
                     		set(
                     			current, 
                     			"term",
                      		lv_term_0_0, 
                      		"Term");
              	        afterParserOrEnumRuleCall();
              	    
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
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleTerm"
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:106:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:107:2: (iv_ruleTerm= ruleTerm EOF )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:108:2: iv_ruleTerm= ruleTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTermRule()); 
            }
            pushFollow(FOLLOW_ruleTerm_in_entryRuleTerm165);
            iv_ruleTerm=ruleTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerm175); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:115:1: ruleTerm returns [EObject current=null] : (this_TerminalTerm_0= ruleTerminalTerm ( ( ( () ( ( ruleTerminalTerm ) ) ) )=> ( () ( (lv_arg_2_0= ruleTerminalTerm ) ) ) )* ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalTerm_0 = null;

        EObject lv_arg_2_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:118:28: ( (this_TerminalTerm_0= ruleTerminalTerm ( ( ( () ( ( ruleTerminalTerm ) ) ) )=> ( () ( (lv_arg_2_0= ruleTerminalTerm ) ) ) )* ) )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:119:1: (this_TerminalTerm_0= ruleTerminalTerm ( ( ( () ( ( ruleTerminalTerm ) ) ) )=> ( () ( (lv_arg_2_0= ruleTerminalTerm ) ) ) )* )
            {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:119:1: (this_TerminalTerm_0= ruleTerminalTerm ( ( ( () ( ( ruleTerminalTerm ) ) ) )=> ( () ( (lv_arg_2_0= ruleTerminalTerm ) ) ) )* )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:120:5: this_TerminalTerm_0= ruleTerminalTerm ( ( ( () ( ( ruleTerminalTerm ) ) ) )=> ( () ( (lv_arg_2_0= ruleTerminalTerm ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getTermAccess().getTerminalTermParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleTerminalTerm_in_ruleTerm222);
            this_TerminalTerm_0=ruleTerminalTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_TerminalTerm_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:128:1: ( ( ( () ( ( ruleTerminalTerm ) ) ) )=> ( () ( (lv_arg_2_0= ruleTerminalTerm ) ) ) )*
            loop1:
            do {
                int alt1=2;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:128:2: ( ( () ( ( ruleTerminalTerm ) ) ) )=> ( () ( (lv_arg_2_0= ruleTerminalTerm ) ) )
            	    {
            	    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:133:6: ( () ( (lv_arg_2_0= ruleTerminalTerm ) ) )
            	    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:133:7: () ( (lv_arg_2_0= ruleTerminalTerm ) )
            	    {
            	    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:133:7: ()
            	    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:134:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getTermAccess().getApplicationFunAction_1_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:139:2: ( (lv_arg_2_0= ruleTerminalTerm ) )
            	    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:140:1: (lv_arg_2_0= ruleTerminalTerm )
            	    {
            	    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:140:1: (lv_arg_2_0= ruleTerminalTerm )
            	    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:141:3: lv_arg_2_0= ruleTerminalTerm
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTermAccess().getArgTerminalTermParserRuleCall_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTerminalTerm_in_ruleTerm270);
            	    lv_arg_2_0=ruleTerminalTerm();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTermRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"arg",
            	              		lv_arg_2_0, 
            	              		"TerminalTerm");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
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
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleTerminalTerm"
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:165:1: entryRuleTerminalTerm returns [EObject current=null] : iv_ruleTerminalTerm= ruleTerminalTerm EOF ;
    public final EObject entryRuleTerminalTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalTerm = null;


        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:166:2: (iv_ruleTerminalTerm= ruleTerminalTerm EOF )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:167:2: iv_ruleTerminalTerm= ruleTerminalTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTerminalTermRule()); 
            }
            pushFollow(FOLLOW_ruleTerminalTerm_in_entryRuleTerminalTerm309);
            iv_ruleTerminalTerm=ruleTerminalTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTerminalTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalTerm319); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTerminalTerm"


    // $ANTLR start "ruleTerminalTerm"
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:174:1: ruleTerminalTerm returns [EObject current=null] : ( (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' ) | this_Constant_3= ruleConstant | this_Arithmetics_4= ruleArithmetics | this_Variable_5= ruleVariable | this_Abstraction_6= ruleAbstraction ) ;
    public final EObject ruleTerminalTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Term_1 = null;

        EObject this_Constant_3 = null;

        EObject this_Arithmetics_4 = null;

        EObject this_Variable_5 = null;

        EObject this_Abstraction_6 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:177:28: ( ( (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' ) | this_Constant_3= ruleConstant | this_Arithmetics_4= ruleArithmetics | this_Variable_5= ruleVariable | this_Abstraction_6= ruleAbstraction ) )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:178:1: ( (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' ) | this_Constant_3= ruleConstant | this_Arithmetics_4= ruleArithmetics | this_Variable_5= ruleVariable | this_Abstraction_6= ruleAbstraction )
            {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:178:1: ( (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' ) | this_Constant_3= ruleConstant | this_Arithmetics_4= ruleArithmetics | this_Variable_5= ruleVariable | this_Abstraction_6= ruleAbstraction )
            int alt2=5;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case RULE_STRING:
            case RULE_INT:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            case RULE_ID:
                {
                alt2=4;
                }
                break;
            case 14:
                {
                alt2=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:178:2: (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' )
                    {
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:178:2: (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' )
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:178:4: otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleTerminalTerm357); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getTerminalTermAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTerminalTermAccess().getTermParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTerm_in_ruleTerminalTerm379);
                    this_Term_1=ruleTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Term_1; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleTerminalTerm390); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getTerminalTermAccess().getRightParenthesisKeyword_0_2());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:197:5: this_Constant_3= ruleConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTerminalTermAccess().getConstantParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleConstant_in_ruleTerminalTerm419);
                    this_Constant_3=ruleConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Constant_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:207:5: this_Arithmetics_4= ruleArithmetics
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTerminalTermAccess().getArithmeticsParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleArithmetics_in_ruleTerminalTerm446);
                    this_Arithmetics_4=ruleArithmetics();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Arithmetics_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:217:5: this_Variable_5= ruleVariable
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTerminalTermAccess().getVariableParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleVariable_in_ruleTerminalTerm473);
                    this_Variable_5=ruleVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Variable_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:227:5: this_Abstraction_6= ruleAbstraction
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTerminalTermAccess().getAbstractionParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAbstraction_in_ruleTerminalTerm500);
                    this_Abstraction_6=ruleAbstraction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Abstraction_6; 
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
    // $ANTLR end "ruleTerminalTerm"


    // $ANTLR start "entryRuleConstant"
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:243:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:244:2: (iv_ruleConstant= ruleConstant EOF )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:245:2: iv_ruleConstant= ruleConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantRule()); 
            }
            pushFollow(FOLLOW_ruleConstant_in_entryRuleConstant535);
            iv_ruleConstant=ruleConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstant; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstant545); if (state.failed) return current;

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
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:252:1: ruleConstant returns [EObject current=null] : (this_StringConstant_0= ruleStringConstant | this_IntConstant_1= ruleIntConstant ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        EObject this_StringConstant_0 = null;

        EObject this_IntConstant_1 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:255:28: ( (this_StringConstant_0= ruleStringConstant | this_IntConstant_1= ruleIntConstant ) )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:256:1: (this_StringConstant_0= ruleStringConstant | this_IntConstant_1= ruleIntConstant )
            {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:256:1: (this_StringConstant_0= ruleStringConstant | this_IntConstant_1= ruleIntConstant )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_STRING) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_INT) ) {
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
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:257:5: this_StringConstant_0= ruleStringConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstantAccess().getStringConstantParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleStringConstant_in_ruleConstant592);
                    this_StringConstant_0=ruleStringConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_StringConstant_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:267:5: this_IntConstant_1= ruleIntConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstantAccess().getIntConstantParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleIntConstant_in_ruleConstant619);
                    this_IntConstant_1=ruleIntConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_IntConstant_1; 
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
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:283:1: entryRuleStringConstant returns [EObject current=null] : iv_ruleStringConstant= ruleStringConstant EOF ;
    public final EObject entryRuleStringConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringConstant = null;


        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:284:2: (iv_ruleStringConstant= ruleStringConstant EOF )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:285:2: iv_ruleStringConstant= ruleStringConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringConstantRule()); 
            }
            pushFollow(FOLLOW_ruleStringConstant_in_entryRuleStringConstant654);
            iv_ruleStringConstant=ruleStringConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringConstant; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringConstant664); if (state.failed) return current;

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
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:292:1: ruleStringConstant returns [EObject current=null] : ( (lv_string_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringConstant() throws RecognitionException {
        EObject current = null;

        Token lv_string_0_0=null;

         enterRule(); 
            
        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:295:28: ( ( (lv_string_0_0= RULE_STRING ) ) )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:296:1: ( (lv_string_0_0= RULE_STRING ) )
            {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:296:1: ( (lv_string_0_0= RULE_STRING ) )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:297:1: (lv_string_0_0= RULE_STRING )
            {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:297:1: (lv_string_0_0= RULE_STRING )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:298:3: lv_string_0_0= RULE_STRING
            {
            lv_string_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringConstant705); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_string_0_0, grammarAccess.getStringConstantAccess().getStringSTRINGTerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getStringConstantRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"string",
                      		lv_string_0_0, 
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
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:322:1: entryRuleIntConstant returns [EObject current=null] : iv_ruleIntConstant= ruleIntConstant EOF ;
    public final EObject entryRuleIntConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntConstant = null;


        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:323:2: (iv_ruleIntConstant= ruleIntConstant EOF )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:324:2: iv_ruleIntConstant= ruleIntConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntConstantRule()); 
            }
            pushFollow(FOLLOW_ruleIntConstant_in_entryRuleIntConstant745);
            iv_ruleIntConstant=ruleIntConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntConstant; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntConstant755); if (state.failed) return current;

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
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:331:1: ruleIntConstant returns [EObject current=null] : ( (lv_int_0_0= RULE_INT ) ) ;
    public final EObject ruleIntConstant() throws RecognitionException {
        EObject current = null;

        Token lv_int_0_0=null;

         enterRule(); 
            
        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:334:28: ( ( (lv_int_0_0= RULE_INT ) ) )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:335:1: ( (lv_int_0_0= RULE_INT ) )
            {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:335:1: ( (lv_int_0_0= RULE_INT ) )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:336:1: (lv_int_0_0= RULE_INT )
            {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:336:1: (lv_int_0_0= RULE_INT )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:337:3: lv_int_0_0= RULE_INT
            {
            lv_int_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIntConstant796); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_int_0_0, grammarAccess.getIntConstantAccess().getIntINTTerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getIntConstantRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"int",
                      		lv_int_0_0, 
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


    // $ANTLR start "entryRuleArithmetics"
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:361:1: entryRuleArithmetics returns [EObject current=null] : iv_ruleArithmetics= ruleArithmetics EOF ;
    public final EObject entryRuleArithmetics() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArithmetics = null;


        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:362:2: (iv_ruleArithmetics= ruleArithmetics EOF )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:363:2: iv_ruleArithmetics= ruleArithmetics EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArithmeticsRule()); 
            }
            pushFollow(FOLLOW_ruleArithmetics_in_entryRuleArithmetics836);
            iv_ruleArithmetics=ruleArithmetics();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArithmetics; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArithmetics846); if (state.failed) return current;

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
    // $ANTLR end "entryRuleArithmetics"


    // $ANTLR start "ruleArithmetics"
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:370:1: ruleArithmetics returns [EObject current=null] : (otherlv_0= '-' ( (lv_term_1_0= ruleTerm ) ) ) ;
    public final EObject ruleArithmetics() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_term_1_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:373:28: ( (otherlv_0= '-' ( (lv_term_1_0= ruleTerm ) ) ) )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:374:1: (otherlv_0= '-' ( (lv_term_1_0= ruleTerm ) ) )
            {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:374:1: (otherlv_0= '-' ( (lv_term_1_0= ruleTerm ) ) )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:374:3: otherlv_0= '-' ( (lv_term_1_0= ruleTerm ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleArithmetics883); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getArithmeticsAccess().getHyphenMinusKeyword_0());
                  
            }
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:378:1: ( (lv_term_1_0= ruleTerm ) )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:379:1: (lv_term_1_0= ruleTerm )
            {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:379:1: (lv_term_1_0= ruleTerm )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:380:3: lv_term_1_0= ruleTerm
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArithmeticsAccess().getTermTermParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTerm_in_ruleArithmetics904);
            lv_term_1_0=ruleTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getArithmeticsRule());
              	        }
                     		set(
                     			current, 
                     			"term",
                      		lv_term_1_0, 
                      		"Term");
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
    // $ANTLR end "ruleArithmetics"


    // $ANTLR start "entryRuleVariable"
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:404:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:405:2: (iv_ruleVariable= ruleVariable EOF )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:406:2: iv_ruleVariable= ruleVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableRule()); 
            }
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable940);
            iv_ruleVariable=ruleVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariable; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable950); if (state.failed) return current;

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
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:413:1: ruleVariable returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:416:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:417:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:417:1: ( (otherlv_0= RULE_ID ) )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:418:1: (otherlv_0= RULE_ID )
            {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:418:1: (otherlv_0= RULE_ID )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:419:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getVariableRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariable994); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getVariableAccess().getRefParameterCrossReference_0()); 
              	
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
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleAbstraction"
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:438:1: entryRuleAbstraction returns [EObject current=null] : iv_ruleAbstraction= ruleAbstraction EOF ;
    public final EObject entryRuleAbstraction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstraction = null;


        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:439:2: (iv_ruleAbstraction= ruleAbstraction EOF )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:440:2: iv_ruleAbstraction= ruleAbstraction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAbstractionRule()); 
            }
            pushFollow(FOLLOW_ruleAbstraction_in_entryRuleAbstraction1029);
            iv_ruleAbstraction=ruleAbstraction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAbstraction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstraction1039); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAbstraction"


    // $ANTLR start "ruleAbstraction"
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:447:1: ruleAbstraction returns [EObject current=null] : (otherlv_0= 'lambda' ( (lv_param_1_0= ruleParameter ) ) otherlv_2= '.' ( (lv_term_3_0= ruleTerm ) ) ) ;
    public final EObject ruleAbstraction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_param_1_0 = null;

        EObject lv_term_3_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:450:28: ( (otherlv_0= 'lambda' ( (lv_param_1_0= ruleParameter ) ) otherlv_2= '.' ( (lv_term_3_0= ruleTerm ) ) ) )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:451:1: (otherlv_0= 'lambda' ( (lv_param_1_0= ruleParameter ) ) otherlv_2= '.' ( (lv_term_3_0= ruleTerm ) ) )
            {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:451:1: (otherlv_0= 'lambda' ( (lv_param_1_0= ruleParameter ) ) otherlv_2= '.' ( (lv_term_3_0= ruleTerm ) ) )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:451:3: otherlv_0= 'lambda' ( (lv_param_1_0= ruleParameter ) ) otherlv_2= '.' ( (lv_term_3_0= ruleTerm ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleAbstraction1076); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAbstractionAccess().getLambdaKeyword_0());
                  
            }
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:455:1: ( (lv_param_1_0= ruleParameter ) )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:456:1: (lv_param_1_0= ruleParameter )
            {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:456:1: (lv_param_1_0= ruleParameter )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:457:3: lv_param_1_0= ruleParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAbstractionAccess().getParamParameterParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleParameter_in_ruleAbstraction1097);
            lv_param_1_0=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAbstractionRule());
              	        }
                     		set(
                     			current, 
                     			"param",
                      		lv_param_1_0, 
                      		"Parameter");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleAbstraction1109); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getAbstractionAccess().getFullStopKeyword_2());
                  
            }
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:477:1: ( (lv_term_3_0= ruleTerm ) )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:478:1: (lv_term_3_0= ruleTerm )
            {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:478:1: (lv_term_3_0= ruleTerm )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:479:3: lv_term_3_0= ruleTerm
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAbstractionAccess().getTermTermParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTerm_in_ruleAbstraction1130);
            lv_term_3_0=ruleTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAbstractionRule());
              	        }
                     		set(
                     			current, 
                     			"term",
                      		lv_term_3_0, 
                      		"Term");
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
    // $ANTLR end "ruleAbstraction"


    // $ANTLR start "entryRuleParameter"
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:503:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:504:2: (iv_ruleParameter= ruleParameter EOF )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:505:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter1166);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter1176); if (state.failed) return current;

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
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:512:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) )? ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:515:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) )? ) )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:516:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) )? )
            {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:516:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) )? )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:516:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) )?
            {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:516:2: ( (lv_name_0_0= RULE_ID ) )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:517:1: (lv_name_0_0= RULE_ID )
            {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:517:1: (lv_name_0_0= RULE_ID )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:518:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParameter1218); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getParameterRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:534:2: (otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:534:4: otherlv_1= ':' ( (lv_type_2_0= ruleType ) )
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleParameter1236); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getParameterAccess().getColonKeyword_1_0());
                          
                    }
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:538:1: ( (lv_type_2_0= ruleType ) )
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:539:1: (lv_type_2_0= ruleType )
                    {
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:539:1: (lv_type_2_0= ruleType )
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:540:3: lv_type_2_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleParameter1257);
                    lv_type_2_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getParameterRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_2_0, 
                              		"Type");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

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
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleType"
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:564:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:565:2: (iv_ruleType= ruleType EOF )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:566:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_ruleType_in_entryRuleType1295);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleType1305); if (state.failed) return current;

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
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:573:1: ruleType returns [EObject current=null] : (this_TerminalType_0= ruleTerminalType ( () otherlv_2= '->' ( (lv_right_3_0= ruleType ) ) )? ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_TerminalType_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:576:28: ( (this_TerminalType_0= ruleTerminalType ( () otherlv_2= '->' ( (lv_right_3_0= ruleType ) ) )? ) )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:577:1: (this_TerminalType_0= ruleTerminalType ( () otherlv_2= '->' ( (lv_right_3_0= ruleType ) ) )? )
            {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:577:1: (this_TerminalType_0= ruleTerminalType ( () otherlv_2= '->' ( (lv_right_3_0= ruleType ) ) )? )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:578:5: this_TerminalType_0= ruleTerminalType ( () otherlv_2= '->' ( (lv_right_3_0= ruleType ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getTypeAccess().getTerminalTypeParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleTerminalType_in_ruleType1352);
            this_TerminalType_0=ruleTerminalType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_TerminalType_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:586:1: ( () otherlv_2= '->' ( (lv_right_3_0= ruleType ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:586:2: () otherlv_2= '->' ( (lv_right_3_0= ruleType ) )
                    {
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:586:2: ()
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:587:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getTypeAccess().getArrowTypeLeftAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleType1373); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getTypeAccess().getHyphenMinusGreaterThanSignKeyword_1_1());
                          
                    }
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:596:1: ( (lv_right_3_0= ruleType ) )
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:597:1: (lv_right_3_0= ruleType )
                    {
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:597:1: (lv_right_3_0= ruleType )
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:598:3: lv_right_3_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getRightTypeParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleType1394);
                    lv_right_3_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"Type");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

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
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleTerminalType"
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:622:1: entryRuleTerminalType returns [EObject current=null] : iv_ruleTerminalType= ruleTerminalType EOF ;
    public final EObject entryRuleTerminalType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalType = null;


        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:623:2: (iv_ruleTerminalType= ruleTerminalType EOF )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:624:2: iv_ruleTerminalType= ruleTerminalType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTerminalTypeRule()); 
            }
            pushFollow(FOLLOW_ruleTerminalType_in_entryRuleTerminalType1432);
            iv_ruleTerminalType=ruleTerminalType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTerminalType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalType1442); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTerminalType"


    // $ANTLR start "ruleTerminalType"
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:631:1: ruleTerminalType returns [EObject current=null] : ( (otherlv_0= '(' this_Type_1= ruleType otherlv_2= ')' ) | this_BasicType_3= ruleBasicType | this_TypeVariable_4= ruleTypeVariable ) ;
    public final EObject ruleTerminalType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Type_1 = null;

        EObject this_BasicType_3 = null;

        EObject this_TypeVariable_4 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:634:28: ( ( (otherlv_0= '(' this_Type_1= ruleType otherlv_2= ')' ) | this_BasicType_3= ruleBasicType | this_TypeVariable_4= ruleTypeVariable ) )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:635:1: ( (otherlv_0= '(' this_Type_1= ruleType otherlv_2= ')' ) | this_BasicType_3= ruleBasicType | this_TypeVariable_4= ruleTypeVariable )
            {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:635:1: ( (otherlv_0= '(' this_Type_1= ruleType otherlv_2= ')' ) | this_BasicType_3= ruleBasicType | this_TypeVariable_4= ruleTypeVariable )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt6=1;
                }
                break;
            case 18:
            case 19:
                {
                alt6=2;
                }
                break;
            case RULE_ID:
                {
                alt6=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:635:2: (otherlv_0= '(' this_Type_1= ruleType otherlv_2= ')' )
                    {
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:635:2: (otherlv_0= '(' this_Type_1= ruleType otherlv_2= ')' )
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:635:4: otherlv_0= '(' this_Type_1= ruleType otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleTerminalType1480); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getTerminalTypeAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTerminalTypeAccess().getTypeParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleTerminalType1502);
                    this_Type_1=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Type_1; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleTerminalType1513); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getTerminalTypeAccess().getRightParenthesisKeyword_0_2());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:654:5: this_BasicType_3= ruleBasicType
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTerminalTypeAccess().getBasicTypeParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBasicType_in_ruleTerminalType1542);
                    this_BasicType_3=ruleBasicType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BasicType_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:664:5: this_TypeVariable_4= ruleTypeVariable
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTerminalTypeAccess().getTypeVariableParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTypeVariable_in_ruleTerminalType1569);
                    this_TypeVariable_4=ruleTypeVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TypeVariable_4; 
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
    // $ANTLR end "ruleTerminalType"


    // $ANTLR start "entryRuleBasicType"
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:680:1: entryRuleBasicType returns [EObject current=null] : iv_ruleBasicType= ruleBasicType EOF ;
    public final EObject entryRuleBasicType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicType = null;


        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:681:2: (iv_ruleBasicType= ruleBasicType EOF )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:682:2: iv_ruleBasicType= ruleBasicType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBasicTypeRule()); 
            }
            pushFollow(FOLLOW_ruleBasicType_in_entryRuleBasicType1604);
            iv_ruleBasicType=ruleBasicType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBasicType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBasicType1614); if (state.failed) return current;

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
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:689:1: ruleBasicType returns [EObject current=null] : ( ( () otherlv_1= 'int' ) | ( () otherlv_3= 'string' ) ) ;
    public final EObject ruleBasicType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:692:28: ( ( ( () otherlv_1= 'int' ) | ( () otherlv_3= 'string' ) ) )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:693:1: ( ( () otherlv_1= 'int' ) | ( () otherlv_3= 'string' ) )
            {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:693:1: ( ( () otherlv_1= 'int' ) | ( () otherlv_3= 'string' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            else if ( (LA7_0==19) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:693:2: ( () otherlv_1= 'int' )
                    {
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:693:2: ( () otherlv_1= 'int' )
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:693:3: () otherlv_1= 'int'
                    {
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:693:3: ()
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:694:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getBasicTypeAccess().getIntTypeAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleBasicType1661); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getBasicTypeAccess().getIntKeyword_0_1());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:704:6: ( () otherlv_3= 'string' )
                    {
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:704:6: ( () otherlv_3= 'string' )
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:704:7: () otherlv_3= 'string'
                    {
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:704:7: ()
                    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:705:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getBasicTypeAccess().getStringTypeAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleBasicType1690); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getBasicTypeAccess().getStringKeyword_1_1());
                          
                    }

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
    // $ANTLR end "ruleBasicType"


    // $ANTLR start "entryRuleTypeVariable"
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:722:1: entryRuleTypeVariable returns [EObject current=null] : iv_ruleTypeVariable= ruleTypeVariable EOF ;
    public final EObject entryRuleTypeVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeVariable = null;


        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:723:2: (iv_ruleTypeVariable= ruleTypeVariable EOF )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:724:2: iv_ruleTypeVariable= ruleTypeVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeVariableRule()); 
            }
            pushFollow(FOLLOW_ruleTypeVariable_in_entryRuleTypeVariable1727);
            iv_ruleTypeVariable=ruleTypeVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeVariable; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeVariable1737); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTypeVariable"


    // $ANTLR start "ruleTypeVariable"
    // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:731:1: ruleTypeVariable returns [EObject current=null] : ( (lv_typevarName_0_0= RULE_ID ) ) ;
    public final EObject ruleTypeVariable() throws RecognitionException {
        EObject current = null;

        Token lv_typevarName_0_0=null;

         enterRule(); 
            
        try {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:734:28: ( ( (lv_typevarName_0_0= RULE_ID ) ) )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:735:1: ( (lv_typevarName_0_0= RULE_ID ) )
            {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:735:1: ( (lv_typevarName_0_0= RULE_ID ) )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:736:1: (lv_typevarName_0_0= RULE_ID )
            {
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:736:1: (lv_typevarName_0_0= RULE_ID )
            // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:737:3: lv_typevarName_0_0= RULE_ID
            {
            lv_typevarName_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeVariable1778); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_typevarName_0_0, grammarAccess.getTypeVariableAccess().getTypevarNameIDTerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getTypeVariableRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"typevarName",
                      		lv_typevarName_0_0, 
                      		"ID");
              	    
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
    // $ANTLR end "ruleTypeVariable"

    // $ANTLR start synpred1_InternalLambda
    public final void synpred1_InternalLambda_fragment() throws RecognitionException {   
        // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:128:2: ( ( () ( ( ruleTerminalTerm ) ) ) )
        // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:128:3: ( () ( ( ruleTerminalTerm ) ) )
        {
        // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:128:3: ( () ( ( ruleTerminalTerm ) ) )
        // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:128:4: () ( ( ruleTerminalTerm ) )
        {
        // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:128:4: ()
        // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:129:1: 
        {
        }

        // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:129:2: ( ( ruleTerminalTerm ) )
        // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:130:1: ( ruleTerminalTerm )
        {
        // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:130:1: ( ruleTerminalTerm )
        // ../it.xsemantics.example.lambda/src-gen/it/xsemantics/example/lambda/parser/antlr/internal/InternalLambda.g:131:1: ruleTerminalTerm
        {
        pushFollow(FOLLOW_ruleTerminalTerm_in_synpred1_InternalLambda240);
        ruleTerminalTerm();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_InternalLambda

    // Delegated rules

    public final boolean synpred1_InternalLambda() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalLambda_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\12\uffff";
    static final String DFA1_eofS =
        "\1\1\11\uffff";
    static final String DFA1_minS =
        "\1\4\2\uffff\6\0\1\uffff";
    static final String DFA1_maxS =
        "\1\16\2\uffff\6\0\1\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\2\7\uffff\1\1";
    static final String DFA1_specialS =
        "\3\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\uffff}>";
    static final String[] DFA1_transitionS = {
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

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "()* loopback of 128:1: ( ( ( () ( ( ruleTerminalTerm ) ) ) )=> ( () ( (lv_arg_2_0= ruleTerminalTerm ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA1_3 = input.LA(1);

                         
                        int index1_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalLambda()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index1_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA1_4 = input.LA(1);

                         
                        int index1_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalLambda()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index1_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA1_5 = input.LA(1);

                         
                        int index1_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalLambda()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index1_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA1_6 = input.LA(1);

                         
                        int index1_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalLambda()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index1_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA1_7 = input.LA(1);

                         
                        int index1_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalLambda()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index1_7);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA1_8 = input.LA(1);

                         
                        int index1_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalLambda()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index1_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 1, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleProgram_in_entryRuleProgram75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProgram85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleProgram130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerm_in_entryRuleTerm165 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerm175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTerm_in_ruleTerm222 = new BitSet(new long[]{0x0000000000006872L});
    public static final BitSet FOLLOW_ruleTerminalTerm_in_ruleTerm270 = new BitSet(new long[]{0x0000000000006872L});
    public static final BitSet FOLLOW_ruleTerminalTerm_in_entryRuleTerminalTerm309 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalTerm319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleTerminalTerm357 = new BitSet(new long[]{0x0000000000006870L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleTerminalTerm379 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleTerminalTerm390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_ruleTerminalTerm419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArithmetics_in_ruleTerminalTerm446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleTerminalTerm473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstraction_in_ruleTerminalTerm500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_entryRuleConstant535 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstant545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringConstant_in_ruleConstant592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntConstant_in_ruleConstant619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringConstant_in_entryRuleStringConstant654 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringConstant664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringConstant705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntConstant_in_entryRuleIntConstant745 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntConstant755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIntConstant796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArithmetics_in_entryRuleArithmetics836 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArithmetics846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleArithmetics883 = new BitSet(new long[]{0x0000000000006870L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleArithmetics904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable940 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariable994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstraction_in_entryRuleAbstraction1029 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstraction1039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleAbstraction1076 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleAbstraction1097 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAbstraction1109 = new BitSet(new long[]{0x0000000000006870L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleAbstraction1130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter1166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParameter1218 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleParameter1236 = new BitSet(new long[]{0x00000000000C0840L});
    public static final BitSet FOLLOW_ruleType_in_ruleParameter1257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType1295 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType1305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalType_in_ruleType1352 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleType1373 = new BitSet(new long[]{0x00000000000C0840L});
    public static final BitSet FOLLOW_ruleType_in_ruleType1394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalType_in_entryRuleTerminalType1432 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalType1442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleTerminalType1480 = new BitSet(new long[]{0x00000000000C0840L});
    public static final BitSet FOLLOW_ruleType_in_ruleTerminalType1502 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleTerminalType1513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicType_in_ruleTerminalType1542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeVariable_in_ruleTerminalType1569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicType_in_entryRuleBasicType1604 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBasicType1614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleBasicType1661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleBasicType1690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeVariable_in_entryRuleTypeVariable1727 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeVariable1737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeVariable1778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTerm_in_synpred1_InternalLambda240 = new BitSet(new long[]{0x0000000000000002L});

}